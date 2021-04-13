package service;

import model.*;
import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionService {
    private static final Logger LOG = Logger.getLogger(TransactionService.class);
    private static final AtomicInteger TRANSACTION_COUNTER = new AtomicInteger(0);

    private final DiscountFunctionFactory discountFunctionFactory;
    private final TaxService taxService;

    public TransactionService(DiscountFunctionFactory discountFunctionFactory, TaxService taxService) {
        this.discountFunctionFactory = discountFunctionFactory;
        this.taxService = taxService;
    }

    private Tax calculateTax(Revenue revenue, Person person) {

//        double revenueSum = revenue.getSum();
//        RevenueType revenueType = revenue.getRevenueType();
//        TaxType appliedTaxType = getTaxType(revenueType);
//        double taxSum;
//        if (revenueType == RevenueType.SALARY) {
//            taxSum = (revenueSum - getDiscount(person)) / 100 * appliedTaxType.getTaxIndex();
//        } else if (RevenueType.ROYALTIES == revenueType) {
//
//        } else {
//            taxSum = (revenueSum) / 100 * appliedTaxType.getTaxIndex();
//        }
//        Tax tax = new Tax(revenue.getName(), taxSum, appliedTaxType);

        Tax tax = taxService.createTax(revenue);
        List<DiscountFunction> discounts = discountFunctionFactory.createDiscounts(revenue, person);

        double discountValue = 0.0;
        for (DiscountFunction discountFunction : discounts) {
            discountValue += discountFunction.getDiscount(revenue);
        }

        double oldSum = tax.getSum();
        double newSum = oldSum - discountValue;
        tax.setSum(newSum);

        String logMessage = MessageFormat.format("created tax {1} for {2} and revenue {3}", tax, person, revenue);
        LOG.info(logMessage);
        return tax;
    }

    private TaxType getTaxType(RevenueType revenueType) {

        if (revenueType == RevenueType.GIFT) {
            return TaxType.GIFT_TAX;
        } else if (revenueType == RevenueType.SALARY) {
            return TaxType.SALARY_TAX;
        } else if (revenueType == RevenueType.SALARY_SECOND) {
            return TaxType.SALARY_SECOND_TAX;
        } else if (revenueType == RevenueType.MONEY_TRANSFER_FROM_ABROAD) {
            return TaxType.MONEY_TRANSFER_FROM_ABROAD_TAX;
        } else if (revenueType == RevenueType.ROYALTIES) {
            return TaxType.ROYALTIES_TAX;
        } else {
            return TaxType.SOLD_ITEM_TAX;
        }
    }

    public Transaction createTransaction(Revenue revenue, Person person) {
        Transaction transaction = new Transaction(TRANSACTION_COUNTER.incrementAndGet());
        transaction.setDate(revenue.getDate());
        transaction.setRevenue(revenue);
        transaction.setTax(calculateTax(revenue, person));
        return transaction;
    }

    private int getDiscount(Person person) {
        int discount = 0;
        if (person.getChildren() > 2) {
            discount = 300;
        } else if (person.getChildren() == 2) {
            discount = 200;
        } else if (person.getChildren() == 1) {
            discount = 100;
        }
        return discount;

    }
}
