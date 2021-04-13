package service;

import model.Revenue;

public class TwoBabyDiscount implements DiscountFunction{
    @Override
    public double getDiscount(Revenue revenue) {

        return 200;
    }
}
