import Books.*;
import Enums.Categories;
import Person.Person;

import java.util.*;


public class Library {
    public Map<String, Integer> bookMap = new TreeMap<>();
    private List<Book> bookList = new LinkedList<>();
    private Set<Book> bookSet = new HashSet<>();
    private Set<Book> categorizedBookSet = new HashSet<>();
    private Set<Book> listedBookSet = new HashSet<>();
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

        for (Book book : bookList) {
            bookMap.put(book.getName(), 0);
            bookSet.add(book);
        }
        for (Book book : bookList) {
            if (bookMap.containsKey(book.getName())) {

                bookMap.put(book.getName(), bookMap.get(book.getName()) + 1);

            }
        }


    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void setBookMap(Map<String, Integer> bookMap) {
        this.bookMap = bookMap;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Set<Book> getCategorizedBookSet() {
        return categorizedBookSet;
    }

    public void setCategorizedBookSet(Set<Book> categorizedBookSet) {
        this.categorizedBookSet = categorizedBookSet;
    }

    public Set<Book> getListedBookSet() {
        return listedBookSet;
    }

    public void setListedBookSet(Set<Book> listedBookSet) {
        this.listedBookSet = listedBookSet;
    }

    public Map<String, Integer> getBookMap() {
        return bookMap;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Book searchBookById(int id) {
        for (Book book : bookSet) {

            if (book.getId() == id) {
                return book;

            }


        }
        System.out.println("Please enter a valid Id");
        return null;

    }

    public Book searchBookByName(String name) {
        for (Book book : bookSet) {

            if (book.getName().equals(name)) {
                return book;

            }


        }
        System.out.println("Please enter a valid Book Name");
        return null;

    }

    public Book searchBookByAuthor(String author) {
        for (Book book : bookSet) {

            if (book.getAuthor().equals(author)) {
                return book;

            }


        }
        System.out.println("Please enter a valid author");
        return null;

    }

    public void addBook(Book book) {
        bookList.add(book);


    }

    public Book editBook(Book oldBook, Book newBook) {

        for (Book book : bookList) {

            if (book.equals(oldBook)) {

                book.setId(newBook.getId());
                book.setName(newBook.getName());
                book.setAuthor(newBook.getAuthor());
                return book;
            }
        }
        System.out.println("Please enter an valid book");
        return null;
    }

    public void removeBook(Book book) {
        if (bookList.contains(book)) {
            bookList.remove(book);
        } else {

            System.out.println("The Library already doesnt have the book. Please enter a valid book");
        }


    }

    public Set<Book> ListAllByCategories(Categories categories) {
        for (Book book : bookSet) {
            if (book.getCategories().equals(categories.getName())) {

                categorizedBookSet.add(book);
            }


        }
        return categorizedBookSet;

    }

    public Set<Book> listAllByAuthors(String name) {
        for (Book book : bookSet) {
            if (book.getAuthor().equals(name)) {

                listedBookSet.add(book);
            }


        }
        return categorizedBookSet;

    }

    public void bookBorrowed(Person person1, Book book) {
        if (person1.getBorrowedBooks().size() >= 5) {
            System.out.println("You already have 5 books");
        } else {
            if (bookMap.containsKey(book.getName())) {
                if (bookMap.get(book.getName()) > 0) {
                    bookMap.put(book.getName(), bookMap.get(book.getName()) - 1);
                    person1.borrowBook(book);

                } else {
                    String owner = "";
                    for (Person person : personList) {
                        if (!person.getBorrowedBooks().isEmpty() && person.getBorrowedBooks().contains(book)) {
                            owner = person.getName() + person.getLastname();
                        }
                    }

                    System.out.println("This book is out of library. It is borrowed by: " + owner);
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



            } else {
                System.out.println("This book has never been in the library");
            }


    }
}



