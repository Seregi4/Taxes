package service;

import model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;

@RunWith(JUnit4.class)
public class TransactionServiceServiceTest {

    @Test
    public void shouldCreateTransactionWithSalaryTaxAndDiscount() {

        // Prepare

        TaxService taxServiceMock = Mockito.mock(TaxService.class);
        DiscountFunctionFactory discountFunctionFactory = new DiscountFunctionFactoryImpl();


        Mockito.when(taxServiceMock.createTax(Mockito.any())).thenReturn(new Tax("",30,null));

        TransactionService transactionService = new TransactionService(discountFunctionFactory, taxServiceMock);

        Person person = new Person(2,"Ivanov","Ivan",2,null);
        Revenue abroadTransferRevenue = new Revenue(LocalDate.of(2020, 10, 5), "Перевод от кукловодов", 10000.0, RevenueType.MONEY_TRANSFER_FROM_ABROAD);

        // Test
        Transaction transaction = transactionService.createTransaction(abroadTransferRevenue, person);

        // Verify
        double expectedTaxValue = 20;
        Assert.assertNotNull(transaction.getTax());
        Assert.assertEquals(expectedTaxValue, transaction.getTax().getSum(), 0);

    }
}
