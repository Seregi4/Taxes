package service;

import model.*;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class TransactionService {
    private static final Logger LOG = Logger.getLogger(TransactionService.class);
    private static final AtomicInteger TRANSACTION_COUNTER = new AtomicInteger(0);

    private Tax calculateTax(Revenue revenue, Person person) {

        double revenueSum = revenue.getSum();
        RevenueType revenueType = revenue.getRevenueType();
        TaxType appliedTaxType = getTaxType(revenueType);
        double taxSum;
        if (revenueType == RevenueType.SALARY) {
            taxSum = (revenueSum - getDiscount(person)) / 100 * appliedTaxType.getTaxIndex();

        } else {
            taxSum = (revenueSum) / 100 * appliedTaxType.getTaxIndex();

        }
        LOG.info(taxSum);
        return new Tax(revenue.getName(), taxSum, appliedTaxType);
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
