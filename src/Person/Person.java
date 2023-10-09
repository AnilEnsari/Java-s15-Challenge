package Person;

import Books.Book;

import java.util.List;
import java.util.Objects;

public class Person implements Billable {
   private int id;
    private String name;
    private String lastname;
    private List<Book> borrowedBooks;


    public Person(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
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
        System.out.println("Your payment is : " + book.getRentPrice());
    }

    @Override
    public void giveBackBill(Book book) {
        System.out.println("Thanks for your %10 donation to our library. After the donation, you will be paid: " + (book.getRentPrice() * 0.9));

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
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
