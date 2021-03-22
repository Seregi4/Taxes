package model;


import java.time.LocalDate;

public class Transaction {


    private final int id;
    private LocalDate date;
    private Tax tax;
    private Revenue revenue;


    public Transaction(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Tax getTax() {
        return tax;
    }

    public Revenue getRevenue() {
        return revenue;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public void setRevenue(Revenue revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "model.Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", tax=" + tax +
                ", revenue=" + revenue +
                '}';
    }
}
