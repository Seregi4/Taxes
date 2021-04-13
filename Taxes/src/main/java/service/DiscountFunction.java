package service;

import model.Revenue;

public interface DiscountFunction {

    double getDiscount(Revenue revenue);
}
