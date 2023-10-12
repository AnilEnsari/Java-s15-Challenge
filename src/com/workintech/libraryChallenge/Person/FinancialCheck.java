package com.workintech.libraryChallenge.Person;

import com.workintech.libraryChallenge.Books.Book;

import java.util.ArrayList;
import java.util.List;

public class FinancialCheck {

    private Double currentBalance = 0.00;
    private List<Double> payments;
    private List<Double> debts;
    private Double totalPayment = 0.00;
    private Double totalDebt = 0.00;
    private List<Book> takenBooks;
    private List<Book> givenBooks;

    public FinancialCheck() {
        payments = new ArrayList<>();
        debts = new ArrayList<>();
        takenBooks = new ArrayList<>();
        givenBooks = new ArrayList<>();


    }

    public Double getCurrentBalance() {


        return currentBalance;
    }


    public List<Double> getPayments() {


        return payments;
    }


    public List<Double> getDebts() {
        return debts;
    }

    public Double getTotalPayment() {
        totalPayment = 0.0;
        if (payments != null) {

            for (Double payment : payments) {

                totalPayment += payment;
            }
        }


        return totalPayment;
    }

    public Double getTotalDebt() {

        totalDebt = 0.0;

        if (debts != null) {
            for (Double debt : debts) {

                totalDebt += debt;
            }
            currentBalance = totalPayment - totalDebt;

        }
        return totalDebt;
    }

    public void pay(Double money) {
        if (payments.isEmpty()) {


            if(money<500){
                System.out.println("Your first payment cant be lower than 500");
            }
            else{
                addPaymentsList(money);
                currentBalance += money;
            }

        }
        else {
            addPaymentsList(money);
            currentBalance += money;
        }

    }

    public void borrowMoney(Double money) {
        addDebtsList(money);
        currentBalance -= money;
    }

    public void addTakenBook(Book book) {
        takenBooks.add(book);
    }

    public void addGivenBook(Book book) {
        givenBooks.add(book);
    }

    public void addDebtsList(Double money) {
        debts.add(money);
    }

    public void addPaymentsList(Double money) {
        payments.add(money);
    }

    @Override
    public String toString() {
        return "FinancialCheck{" + "\n" +
                "currentBalance=" + getCurrentBalance() + "\n" +
                "payments=" + getPayments() + "\n" +
                "totalPayment=" + getTotalPayment() + "\n" +
                "debts=" + getDebts() + "\n" +
                "totalDebt=" + getTotalDebt() + "\n" +
                "takenBooks=" + takenBooks + "\n" +
                "givenBooks=" + givenBooks + "\n" +

                '}';
    }
}

