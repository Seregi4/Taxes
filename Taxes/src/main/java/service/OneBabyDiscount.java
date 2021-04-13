package service;

import model.Revenue;

public class OneBabyDiscount implements DiscountFunction {
    @Override
    public double getDiscount(Revenue revenue) {
        return 100;
    }
}
