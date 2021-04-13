package model;

public class Tax {
    private String name;
    private double sum;
    private TaxType taxType;


    public Tax(String name, double sum, TaxType taxType) {
        this.name = name;
        this.sum = sum;
        this.taxType = taxType;
    }

    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    @Override
    public String toString() {
        return "model.Tax{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", taxType=" + taxType +
                '}';
    }
}
