package Person;

import Books.Book;

import java.util.List;

public  class  Student extends Person {


    public Student(int id,String name, String lastname,double firstPayment) {
        super(id,name, lastname,firstPayment);

    }
    @Override
    public void borrowBill(Book book) {
        System.out.println("You are a student. You have %10 discount. So your payment is : "+(book.getRentPrice()*0.9));
        super.getFinancialCheck().borrowMoney(book.getRentPrice()*0.9);
        super.getFinancialCheck().addTakenBook(book);
        System.out.println("Your current balance is "+ super.getFinancialCheck().getCurrentBalance());
    }
    @Override
    public void giveBackBill(Book book) {
        System.out.println("We take %20 of the book price for use and %80 will be paid back." );
        System.out.println("This amount has been added to your current balance "+(book.getRentPrice()*0.8*0.9));
        super.getFinancialCheck().pay(book.getRentPrice()*0.8*0.9);
        super.getFinancialCheck().addGivenBook(book);
        System.out.println("Your current balance is "+ super.getFinancialCheck().getCurrentBalance());



    }


    @Override
    public String toString() {
        return "Student{} " + super.toString();
    }
}
