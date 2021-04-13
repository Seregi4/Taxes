package service;

import model.Revenue;

public class ManyBabyDiscount implements DiscountFunction{
    @Override
    public double getDiscount(Revenue revenue) {
        return 300;
    }
}
