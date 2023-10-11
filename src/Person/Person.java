package Person;

import Books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Billable {
   private int id;
    private String name;
    private String lastname;
    private List<Book> borrowedBooks;
    private FinancialCheck financialCheck;



    public Person(int id, String name, String lastname,Double firstPayment) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.borrowedBooks = new ArrayList<>();
        this.financialCheck = new FinancialCheck();
        if(firstPayment>= 500){
            this.financialCheck.pay(firstPayment);
        }else {
            System.out.println("First payment must be 500 or more");
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() <= 5) {
            borrowedBooks.add(book);
        } else {
            System.out.println("You already have 5 books");
        }
    }

    public void giveBack(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }



    @Override
    public void borrowBill(Book book) {
        System.out.println("Your payment is : "+book.getRentPrice());
        financialCheck.borrowMoney(book.getRentPrice());
        financialCheck.addTakenBook(book);
        System.out.println("Your current balance is "+ financialCheck.getCurrentBalance());
    }

    @Override
    public void giveBackBill(Book book) {
        System.out.println("We take %20 of the book price for use and %80 will be paid back. Your refund is: " + (book.getRentPrice() * 0.8));
        financialCheck.pay(book.getRentPrice()*0.8);
        financialCheck.addGivenBook(book);
        System.out.println("This amount has been added to your current balance "+(book.getRentPrice()*0.8));
        System.out.println("Your current balance is "+ financialCheck.getCurrentBalance());
    }

    public FinancialCheck getFinancialCheck() {
        return financialCheck;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + "\n"+
                ", borrowedBooks=" + borrowedBooks +"\n"+
        "current Balance: " + financialCheck.getCurrentBalance() +" TL";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
