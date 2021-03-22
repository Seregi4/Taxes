package model;

import java.util.List;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int children;
    private List<Transaction> transactions;

    public Person(int id, String firstName, String lastName, int children, List<Transaction> transactions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.children = children;
        this.transactions = transactions;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getChildren() {
        return children;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "model.Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", children=" + children +
                ", transactions=" + transactions +
                '}';
    }
}
