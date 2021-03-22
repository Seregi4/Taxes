package service;

import model.Person;
import model.Tax;
import model.Transaction;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    private static final Logger LOG = Logger.getLogger(PersonService.class);

   private Person person;

    public PersonService(Person person) {
        this.person = person;
    }

    public List<Tax> getTaxesByYear(int year) {
        List<Tax> taxesByYear = new ArrayList<>();
        for (Transaction transaction : person.getTransactions()) {
            if (transaction.getDate().getYear() == Integer.parseInt(String.valueOf(year))) {
                taxesByYear.add(transaction.getTax());
            }
        }
        LOG.info(taxesByYear);
        return taxesByYear;
    }

    public List<Tax> sortTAxBySum() {
        List<Tax> sortedTaxes = new ArrayList<>();
        for (Transaction transaction : person.getTransactions()) {
            sortedTaxes.add(transaction.getTax());
        }
        sortedTaxes.sort(Comparator.comparing(Tax::getSum));
        LOG.info(sortedTaxes);
        return sortedTaxes;
    }

}
