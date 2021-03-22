package application;

import dao.RevenueDataBase;
import model.Person;
import model.Revenue;
import model.RevenueType;
import service.PersonService;
import service.PrintService;
import service.TransactionService;

import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
    /*Определить множество и сумму налоговых выплат физического
лица за год с учетом доходов с основного и дополнительного мест работы,
авторских вознаграждений, продажи имущества, получения в подарок
денежных сумм и имущества, переводов из-за границы, льгот на детей и
материальную помощь. Провести сортировку налогов по сумме.

     */
    public static void main(String[] args) {
        Person person = new Person(1, "Ivan", "Ivanov", 0, new ArrayList<>());
        Revenue giftRevenue = new Revenue(LocalDate.of(2020, 1, 2), "ПОдарок от бабушки", 240.0, RevenueType.GIFT);
        Revenue royaltiesRevenue = new Revenue(LocalDate.of(2021, 1, 3), "Научная работа", 350.0, RevenueType.ROYALTIES);
        Revenue soldItemRevenue = new Revenue(LocalDate.of(2020, 1, 4), "Продажа авто", 5000.0, RevenueType.SOLD_ITEMS);
        Revenue abroadTransferRevenue = new Revenue(LocalDate.of(2020, 10, 5), "Перевод от кукловодов", 10000.0, RevenueType.MONEY_TRANSFER_FROM_ABROAD);
        Revenue salaryRevenueJun = new Revenue(LocalDate.of(2021, 1, 6), "Зарплата за декабрь ", 1300.0, RevenueType.SALARY);
        Revenue salaryRevenueFeB = new Revenue(LocalDate.of(2021, 2, 6), "Зарплата за январь", 1250.0, RevenueType.SALARY);
        Revenue salaryRevenueMar = new Revenue(LocalDate.of(2021, 3, 6), "Зарплата за вевраль", 1200.0, RevenueType.SALARY);
        Revenue salaryRevenueApr = new Revenue(LocalDate.of(2021, 4, 6), "Зарплата за март", 1340.0, RevenueType.SALARY);
        Revenue salarySecondRevenue = new Revenue(LocalDate.of(2021, 2, 7), "Подработка ", 810.0, RevenueType.SALARY_SECOND);

        RevenueDataBase revenueDataBase = new RevenueDataBase(new ArrayList<>());
        revenueDataBase.getRevenues().add(giftRevenue);
        revenueDataBase.getRevenues().add(royaltiesRevenue);
        revenueDataBase.getRevenues().add(salaryRevenueJun);
        revenueDataBase.getRevenues().add(salaryRevenueFeB);
        revenueDataBase.getRevenues().add(salaryRevenueMar);
        revenueDataBase.getRevenues().add(salaryRevenueApr);
        revenueDataBase.getRevenues().add(soldItemRevenue);
        revenueDataBase.getRevenues().add(abroadTransferRevenue);
        revenueDataBase.getRevenues().add(salarySecondRevenue);

        TransactionService transactionService = new TransactionService();
        for (Revenue revs : revenueDataBase.getRevenues()) {
            person.getTransactions().add(transactionService.createTransaction(revs, person));
        }

        TaxApplication applicationTaxes = new TaxApplication();
        PersonService service = new PersonService(person);
        PrintService printService = new PrintService();
        applicationTaxes.run(service, printService);
    }
}
