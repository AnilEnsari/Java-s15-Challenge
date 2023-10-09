package Person;

import Books.Book;

import java.util.List;

public  class  Student extends Person {


    public Student(int id,String name, String lastname) {
        super(id,name, lastname);
    }
    @Override
    public void borrowBill(Book book) {
        System.out.println("Your payment is : "+(book.getRentPrice()*0.8));
    }
    @Override
    public void giveBackBill(Book book) {
        System.out.println("We dont accept any donations from the students. All the money will be paid back: "+(book.getRentPrice()*0.8));

    }

    @Override
    public String toString() {
        return "Student{} " + super.toString();
    }
}
