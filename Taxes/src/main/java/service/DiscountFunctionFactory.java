package service;

import model.Person;
import model.Revenue;

import java.util.List;

public interface DiscountFunctionFactory {

    List<DiscountFunction> createDiscounts(Revenue revenue, Person person);
}
