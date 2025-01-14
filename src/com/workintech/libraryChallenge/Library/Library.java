package com.workintech.libraryChallenge.Library;

import com.workintech.libraryChallenge.Books.*;
import com.workintech.libraryChallenge.Enums.Categories;
import com.workintech.libraryChallenge.Person.Person;

import java.util.*;


public class Library {

    public Map<String, Integer> bookMap = new TreeMap<>();
    private List<Book> bookList = new ArrayList<>();
    private Set<Book> categorizedBookSet = new LinkedHashSet<>();


    private List<Person> personList = new LinkedList<>();


    public Library() {
        Book book1 = new Sports(1, "Mourinho: further anatomy of a winner", "Patrick Barclay");
        Book book2 = new Classics(2, "Crime and Punishment", "Fyodor Dostoyevski");
        Book book3 = new Technology(3, "Energy Flash", "Simon Reynold");
        Book book4 = new History(4, "Grant", "Ron Chernow");
        Book book5 = new Sports(5, "Arda Turan - Bayrampasanin Dahisi", "M.Ozgur Sancar");
        Book book6 = new Sports(6, "Fever Pitch", "Nick Hornby");
        Book book7 = new Classics(7, "War and peace", "Lev Tolstoy");
        Book book8 = new Classics(8, "Les Misrables", "Victor Hugo");
        Book book9 = new Classics(9, "The Karamazov brothers", "Fyodor Dostoyevski");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book9);
        bookList.add(book9);
        bookList.add(book3);
        bookList.add(book1);
        bookList.add(book3);
        bookList.add(book2);


        stockCheck();


    }

    public Map<String, Integer> stockCheck() {
        for (Book book : bookList) {
            bookMap.put(book.getName(), 0);
        }
        for (Book book : bookList) {
            if (bookMap.containsKey(book.getName())) {

                bookMap.put(book.getName(), bookMap.get(book.getName()) + 1);

            }
        }
        return bookMap;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void addPersonToLibrary(Person person) {
        personList.add(person);
    }

    public void setBookMap(Map<String, Integer> bookMap) {
        this.bookMap = bookMap;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public Map<String, Integer> getBookMap() {
        return bookMap;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Book searchBookById(int id) {
        for (Book book : bookList) {

            if (book.getId() == id) {
                return book;

            }


        }
        System.out.println("The id is not used by library");
        return null;

    }

    public Book searchBookByName(String name) {
        for (Book book : bookList) {

            if (book.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                return book;

            }


        }
        System.out.println("Please enter a valid Book Name");
        return null;

    }

    public Book searchBookByAuthor(String author) {
        for (Book book : bookList) {

            if (book.getAuthor().toLowerCase(Locale.ROOT).contains(author.toLowerCase(Locale.ROOT))) {
                return book;


            }


        }
        System.out.println("Please enter a valid author");
        return null;

    }

    public void addBook(Book book) {
        bookList.add(book);


    }

    public void editBook(Book oldBook, Book newBook) {

        for (Book book : bookList) {

            if (book.equals(oldBook)) {

                book.setId(newBook.getId());
                book.setName(newBook.getName());
                book.setAuthor(newBook.getAuthor());
                book.setCategories(newBook.getCategories());
                book.setRentPrice(newBook.getRentPrice());

            }
        }
        System.out.println("Please enter a valid book");

    }

    public void removeBook(Book book) {
        if (bookList.contains(book)) {
            bookList.remove(book);
            if (bookMap.get(book.getName()) > 0) {
                bookMap.put(book.getName(), bookMap.get(book.getName()) - 1);
            }
        } else {

            System.out.println("The com.workintech.libraryChallenge.com.workintech.libraryChallenge.Books.Books.Library already doesn't have the book. Please select a valid book");
        }


    }

    public Set<Book> listAllByCategories(Categories categories) {
        if (!categorizedBookSet.isEmpty()) {
            categorizedBookSet.clear();
        }
        for (Book book : bookList) {
            if (book.getCategories().equals(categories.getName())) {

                categorizedBookSet.add(book);
            }


        }
        return categorizedBookSet;

    }

    public Set<Book> listAllByAuthors(String name) {
        if (!categorizedBookSet.isEmpty()) {
            categorizedBookSet.clear();
        }

        for (Book book : bookList) {
            if (book.getAuthor().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {

                categorizedBookSet.add(book);
            }


        }
        return categorizedBookSet;

    }

    public void bookBorrowed(Person person1, Book book) {

        if (person1.getBorrowedBooks().size() >= 5) {
            System.out.println("Sorry you cant borrow any more books.You already have 5 books");
            System.out.println("Your books are: " + person1.getBorrowedBooks());
        } else {
            if (bookMap.containsKey(book.getName())) {
                if (bookMap.get(book.getName()) > 0) {


                    if(book.getRentPrice()<= person1.getFinancialCheck().getCurrentBalance()){

                        bookMap.put(book.getName(), bookMap.get(book.getName()) - 1);
                        person1.borrowBook(book);
                        System.out.println("Congratulations you have borrowed the book successfully " + book);
                        person1.borrowBill(book);

                    }

                    else if ("com.workintech.libraryChallenge.com.workintech.libraryChallenge.Books.Books.Person.Student".equals(person1.getClass().getName())&&book.getRentPrice()*0.9<= person1.getFinancialCheck().getCurrentBalance()) {
                        bookMap.put(book.getName(), bookMap.get(book.getName()) - 1);
                        person1.borrowBook(book);
                        System.out.println("Congratulations you have borrowed the book successfully" + book);
                        person1.borrowBill(book);
                    }


                    else {

                        System.out.println("Your current balance is not enouth to borrow the book. " +"\n"
                                +"Please make a payment to borrow the book. ");

                    }


                } else {
                    List<Person> ownerList = new ArrayList<>();
                    for (Person person : personList) {
                        if (!person.getBorrowedBooks().isEmpty() && person.getBorrowedBooks().contains(book)) {
                            ownerList.add(person);
                        }
                    }

                    System.out.println("This book is out of library. It is borrowed by: ");
                             for(Person owner : ownerList){

                                 System.out.println(owner.getName()+" "+owner.getLastname()+", ");
                    }



                }

            } else {
                System.out.println("This book has never been in the library");
            }
        }

    }

    public void giveBackBook(Person person1, Book book) {
        if (bookMap.containsKey(book.getName())) {

            bookMap.put(book.getName(), bookMap.get(book.getName()) + 1);
            person1.giveBack(book);
            person1.giveBackBill(book);


        } else {
            System.out.println("This book has never been in the library");
        }


    }
}



