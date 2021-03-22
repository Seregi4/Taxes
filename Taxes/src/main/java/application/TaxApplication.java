package application;

import org.apache.log4j.Logger;
import service.PersonService;
import service.PrintService;

import java.util.Scanner;

public class TaxApplication {
    private static final Logger LOG = Logger.getLogger(TaxApplication.class);

    public void run(PersonService service, PrintService printService) {

        String choice;
        boolean check = false;

        do {
            System.out.println("Если хотите получить список налогов за год введите 1");
            System.out.println("Если хотите получить сортированный список налогов введите 2");
            System.out.println("Для выхода введите 3");
            choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "1" -> {
                    try {
                        System.out.println(" Введите год");
                        String year = new Scanner(System.in).nextLine();
                        printService.printList(service.getTaxesByYear(Integer.parseInt(year)));
                    } catch (NumberFormatException e) {
                        System.out.println("Неверное значение");
                    }
                }
                case "2" -> printService.printList(service.sortTAxBySum());
                case "3" -> check = true;
                default -> System.out.println("Incorrect value");
            }
        } while (!check);
        LOG.info(choice);
        LOG.info(service);
    }

}

