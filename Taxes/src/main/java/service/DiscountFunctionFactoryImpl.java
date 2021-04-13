package service;

import model.Person;
import model.Revenue;

import java.util.ArrayList;
import java.util.List;

public class DiscountFunctionFactoryImpl implements DiscountFunctionFactory {
    @Override
    public List<DiscountFunction> createDiscounts(Revenue revenue, Person person) {
        List<DiscountFunction> discountFunctionList = new ArrayList<>();
        if (person.getChildren() == 1) {
            discountFunctionList.add(new OneBabyDiscount());
        } else if (person.getChildren() == 2) {
            discountFunctionList.add(new TwoBabyDiscount());
        }
        else if(person.getChildren() > 2){
            discountFunctionList.add(new ManyBabyDiscount());
        }
        return discountFunctionList;
    }
}
