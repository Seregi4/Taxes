package dao;

import model.Revenue;

import java.util.List;

public class RevenueDataBase {

    private List<Revenue> revenues;

    public RevenueDataBase(List<Revenue> revenues) {
        this.revenues = revenues;
    }

    public List<Revenue> getRevenues() {
        return revenues;
    }

    public void setRevenues(List<Revenue> revenues) {
        this.revenues = revenues;
    }
}
