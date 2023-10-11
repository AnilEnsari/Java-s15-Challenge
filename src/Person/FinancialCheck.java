package Person;

import Books.Book;

import java.util.ArrayList;
import java.util.List;

public class FinancialCheck {

   private Double currentBalance;
   private List<Double> payments;
   private List <Double> debts ;
   private Double totalPayment= 0.00;
   private  Double totalDebt = 0.00 ;
    private List<Book> takenBooks = new ArrayList<>();
    private List <Book> givenBooks = new ArrayList<>();
    public FinancialCheck(){
        payments = new ArrayList<>();
        debts = new ArrayList<>();



    }

    public Double getCurrentBalance() {
        totalPayment = 0.0;
        totalDebt = 0.0 ;
        if( payments != null ){

            for (Double payment : payments){

                totalPayment += payment;
            }
        }
        if (debts!=null){
            for (Double debt : debts){

                totalDebt += debt;
            }
            currentBalance = totalPayment-totalDebt;

        }



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
        if( payments != null ){

            for (Double payment : payments){

                totalPayment += payment;
            }
        }


        return totalPayment;
    }

    public Double getTotalDebt() {

        totalDebt = 0.0 ;

        if (debts!=null){
            for (Double debt : debts){

                totalDebt += debt;
            }
            currentBalance = totalPayment-totalDebt;

        }
        return totalDebt;
    }
    public void pay(Double money){

        payments.add(money);
    }
    public void borrowMoney(Double money){
        debts.add(money);
    }
    public void addTakenBook(Book book){
        takenBooks.add(book);
    }
    public void addGivenBook(Book book){
        givenBooks.add(book);
    }

    @Override
    public String toString() {
        return "FinancialCheck{" +"\n"+
                "currentBalance=" + currentBalance +"\n"+
                "payments=" + payments + "\n"+
                "totalPayment=" + totalPayment +"\n"+
                "debts=" + debts +"\n"+
                "totalDebt=" + totalDebt +"\n"+
                "takenBooks=" + takenBooks +"\n"+
                "givenBooks=" + givenBooks +"\n"+

                '}';
    }
}

