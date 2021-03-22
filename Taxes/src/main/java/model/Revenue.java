package model;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Revenue {

    private String name;
    private LocalDate date;
    private double sum;
    private RevenueType revenueType;

    public Revenue(LocalDate date, String name, double sum, RevenueType revenueType) {
        this.date = date;
        this.name = name;
        this.sum = sum;
        this.revenueType = revenueType;
    }

    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }

    public RevenueType getRevenueType() {
        return revenueType;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "model.Revenue{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", sum=" + sum +
                ", revenueType=" + revenueType +
                '}';
    }
}

