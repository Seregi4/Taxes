package service;

import model.Revenue;
import model.Tax;

public interface TaxService {

    Tax createTax(Revenue r);
}
