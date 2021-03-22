package service;

import model.Tax;

import java.util.List;

public class PrintService {
    public void printList(List<Tax> taxes) {
        for (Tax tax : taxes) {
            System.out.println(tax.getName() + " " + tax.getSum());
        }
        System.out.println("Общая сумма налоговых выплат за год = " + getSumAllTax(taxes));
    }

    public int getSumAllTax(List<Tax> taxes) {
        int sum = 0;
        for (Tax tax : taxes) {
            sum += tax.getSum();
        }
        return sum;
    }
}
