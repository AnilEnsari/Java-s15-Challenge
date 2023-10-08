package Person;

import Books.Book;

import java.util.List;

public class Person {
    private String name;
    private String lastname;
    private List<Book> borrowedBooks;


    public Person(String name, String lastname) {

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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
