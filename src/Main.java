
import Books.Book;
import Enums.Categories;
import Person.Student;
import Person.Person;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Library workintech = new Library();
        Person anil = new Student(1, "Anil", "Ensari", 600);
        Person icardi = new Person(2, "Mauro", "Icardi", 510.00);
        Person admin = new Person(0, "admin", "admin", 500.00);
        workintech.addPersonToLibrary(anil);
        workintech.addPersonToLibrary(icardi);
        boolean isOpen = true;
        Person loggedinPerson = null;
        while (isOpen) {


            if (loggedinPerson == null) {
                System.out.println("Hello, welcome to our library!");
                System.out.println("If you don't have an account please register or login");

                Scanner scanner = new Scanner(System.in);
                System.out.println("1- Login");
                System.out.println("2- Register");
                System.out.println("3- admin");

                System.out.println("0- Exit");
                String loginPerson = scanner.nextLine();
                switch (loginPerson) {
                    case "0":
                        System.out.println("Hope to see you again!");
                        isOpen = false;
                        break;

                    case "1":
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Please enter your id");
                        String id1 = scanner2.nextLine();
                        for (Person persons : workintech.getPersonList()) {

                            if (persons.getId() == Integer.parseInt(id1)) {
                                loggedinPerson = persons;
                                System.out.println("You have successfully logged in.");
                                System.out.println(loggedinPerson);
                                break;


                            }


                        }
                        if (loggedinPerson == null) {
                            System.out.println("Invalid id. You are being directed to upper menu. Please try again or register");
                            break;

                        }
                        break;
                    case "2":
                        boolean validId = false;
                        String id2 = "";

                        while (!validId) {
                            Scanner scanner3 = new Scanner(System.in);
                            System.out.println("Please enter an integer id you want to have! ");
                            id2 = scanner3.nextLine();

                            boolean isUsed = false;

                            for (Person persons : workintech.getPersonList()) {
                                if (persons.getId() == Integer.parseInt(id2)) {
                                    System.out.println("Your entered id is used. Please try again with a new id.");
                                    isUsed = true;
                                    break;
                                }
                            }

                            if (!isUsed) {
                                validId = true;
                            }
                        }

                        System.out.println("Please enter your Name");
                        String firstName2 = scanner.nextLine();
                        System.out.println("Please enter your Lastname");
                        String lastName2 = scanner.nextLine();
                        System.out.println("You have to pay at least 500 to register.");
                        System.out.println("This amount will decrease as you borrow books and increase as you return them");
                        double firstPayment = Double.parseDouble(scanner.nextLine());

                        if (firstPayment > 499) {
                            System.out.println("Thanks for the donation.");
                            System.out.println("Are you a student?");
                            System.out.println("1- Yes ");
                            System.out.println("2- No");
                            String isStudent = scanner.nextLine();

                            if (isStudent.equals("1")) {
                                loggedinPerson = new Student(Integer.parseInt(id2), firstName2, lastName2, firstPayment);
                            } else {
                                loggedinPerson = new Person(Integer.parseInt(id2), firstName2, lastName2, firstPayment);
                            }

                            workintech.addPersonToLibrary(loggedinPerson);
                            System.out.println("Congratulations, you have been registered!");
                        } else {
                            System.out.println("First payment cant be lower than 500.");
                            System.out.println("You are being directed to upper menu");
                        }
                        break;
                    case "3":
                        loggedinPerson = admin;
                        System.out.println("Hello admin, Welcome to the system");

                }
            } else if (loggedinPerson == admin) {

                System.out.println("Here is the List of the operations you can do.");

                Scanner scanner5 = new Scanner(System.in);
                System.out.println("1- Add book to the library");
                System.out.println("2- Remove book from the library");
                System.out.println("3- Set a book");
                System.out.println("4- Check stock");
                System.out.println("5- List books by Categories");
                System.out.println("6- List books by Authors");
                System.out.println("9- Logout");


                String adminOperations = scanner5.nextLine();
                switch (adminOperations) {
                    case "1":
                        Book addedBook;
                        System.out.println("Did the library have the book you want to add before ?");
                        System.out.println("1- Yes");
                        System.out.println("2- No");
                        String answer = scanner5.nextLine();


                        switch (answer) {
                            case "1":
                                System.out.println("Please enter the id of the book");
                                String addedId = scanner5.nextLine();
                                addedBook = workintech.searchBookById(Integer.parseInt(addedId));
                                if (addedBook != null) {
                                    workintech.addBook(addedBook);
                                    System.out.println("Congratulations you have successfully added " + addedBook);
                                    workintech.bookMap.put(addedBook.getName(), workintech.bookMap.get(addedBook.getName()) + 1);

                                }

                                break;
                            case "2":
                                System.out.println("Please enter the id of the book");
                                String addedId2 = scanner5.nextLine();
                                addedBook = workintech.searchBookById(Integer.parseInt(addedId2));
                                if (addedBook == null) {
                                    System.out.println("You entered a valid id please enter the name of the book");
                                    String addName2 = scanner5.nextLine();
                                    System.out.println("Please enter the author's full name of the book");
                                    String author2 = scanner5.nextLine();
                                    System.out.println("Please choose the category you want to add");
                                    System.out.println("1- Sports");
                                    System.out.println("2- Classics");
                                    System.out.println("3- History");
                                    System.out.println("4- Technology");
                                    String categoryResult = scanner5.nextLine();
                                    switch (categoryResult) {
                                        case "1" ->
                                                addedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.SPORT);
                                        case "2" ->
                                                addedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.CLASSICS);
                                        case "3" ->
                                                addedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.HISTORY);
                                        case "4" ->
                                                addedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.TECHNOLOGY);
                                        default -> System.out.println("You entered an invalid category");
                                    }
                                    if (addedBook != null) {
                                        workintech.addBook(addedBook);
                                        workintech.bookMap.put(addedBook.getName(), 1);
                                        System.out.println("Congratulations you have successfully added " + addedBook);
                                    }
                                    ;
                                    break;
                                } else {
                                    System.out.println("The id is already used by another book");

                                }
                                break;

                        }
                        break;
                    case "2":
                        System.out.println("Please select a book to remove from the library");
                        System.out.println("How do you want to select the book ?");
                        System.out.println("1- With Id");
                        System.out.println("2- With Name");
                        Book selectedBook;
                        String searchBookKey = scanner5.nextLine();

                        switch (searchBookKey) {
                            case "1":
                                System.out.println("Please enter the id of the book");

                                String bookId = scanner5.nextLine();
                                selectedBook = workintech.searchBookById(Integer.parseInt(bookId));
                                if (selectedBook != null) {
                                    workintech.removeBook(selectedBook);
                                    System.out.println("The book has been removed successfully");


                                }


                                break;
                            case "2":
                                System.out.println("Please enter the name of the book");
                                String bookName = scanner5.nextLine();
                                selectedBook = workintech.searchBookByName(bookName);
                                if (selectedBook != null) {
                                    workintech.removeBook(selectedBook);
                                    System.out.println("The book has been removed successfully");

                                }

                                break;


                        }
                        break;
                    case "3":
                        System.out.println("Please select the book you want to set from the library");
                        System.out.println("How do you want to select the book ?");
                        System.out.println("1- With Id");
                        System.out.println("2- With Name");
                        Book selectedBook2 = null;
                        String searchBookKey2 = scanner5.nextLine();

                        switch (searchBookKey2) {
                            case "1":
                                System.out.println("Please enter the id of the book");

                                String bookId = scanner5.nextLine();
                                selectedBook2 = workintech.searchBookById(Integer.parseInt(bookId));
                                if (selectedBook2 != null) {
                                    System.out.println("The book has been selected successfully");

                                }


                                break;
                            case "2":
                                System.out.println("Please enter the name of the book");
                                String bookName = scanner5.nextLine();
                                selectedBook2 = workintech.searchBookByName(bookName);
                                if (selectedBook2 != null) {
                                    System.out.println("The book has been selected successfully");

                                }

                                break;


                        }
                        System.out.println("Please enter the asked information about the updated book.");
                        System.out.println("Please enter the id of the book");
                        Book updatedBook;
                        String addedId2 = scanner5.nextLine();
                        updatedBook = workintech.searchBookById(Integer.parseInt(addedId2));
                        if (selectedBook2 != null && (updatedBook == null || updatedBook.getId() == selectedBook2.getId())) {
                            System.out.println("You entered a valid id please enter the name of the book");
                            String addName2 = scanner5.nextLine();
                            System.out.println("Please enter the author's full name of the book");
                            String author2 = scanner5.nextLine();
                            System.out.println("Please choose the category of the book");
                            System.out.println("1- Sports");
                            System.out.println("2- Classics");
                            System.out.println("3- History");
                            System.out.println("4- Technology");
                            String categoryResult = scanner5.nextLine();
                            switch (categoryResult) {
                                case "1" ->
                                        updatedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.SPORT);
                                case "2" ->
                                        updatedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.CLASSICS);
                                case "3" ->
                                        updatedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.HISTORY);
                                case "4" ->
                                        updatedBook = new Book(Integer.parseInt(addedId2), addName2, author2, Categories.TECHNOLOGY);
                                default -> System.out.println("You entered an invalid category");
                            }
                            if (updatedBook != null) {

                                if (workintech.bookMap.containsKey(selectedBook2.getName())) {
                                    workintech.bookMap.put(updatedBook.getName(), workintech.bookMap.get(selectedBook2.getName()));
                                }
                                workintech.bookMap.remove(selectedBook2.getName());
                                workintech.editBook(selectedBook2, updatedBook);


                                System.out.println("Congratulations you have successfully set " + updatedBook);

                            }

                            break;
                        } else {
                            System.out.println("The id is already used by another book");

                        }
                        break;
                    case "4":
                        System.out.println(workintech.getBookMap());
                        break;
                    case "5":
                        System.out.println("Please choose the category of the book");
                        System.out.println("1- Sports");
                        System.out.println("2- Classics");
                        System.out.println("3- History");
                        System.out.println("4- Technology");
                        String categoryResult = scanner5.nextLine();
                        switch (categoryResult) {
                            case "1" -> System.out.println(workintech.listAllByCategories(Categories.SPORT));
                            case "2" -> System.out.println(workintech.listAllByCategories(Categories.CLASSICS));
                            case "3" -> System.out.println(workintech.listAllByCategories(Categories.HISTORY));
                            case "4" -> System.out.println(workintech.listAllByCategories(Categories.TECHNOLOGY));
                            default -> System.out.println("You entered an invalid category");
                        }
                        break;
                    case "6":
                        System.out.println("Please enter the author whose books you want to list ");
                        String authorName = scanner5.nextLine();
                        if (workintech.listAllByAuthors(authorName).isEmpty()) {
                            System.out.println("Sorry we don't have any books authored by " + authorName);
                        } else {
                            System.out.println(workintech.listAllByAuthors(authorName));
                        }

                        break;

                    case "9":

                        loggedinPerson = null;
                        break;


                }
            } else {
                System.out.println("Login has been successful lets start to operations.");
                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Please select the operation you want to do");
                System.out.println("0-Exit");
                System.out.println("1-List all book by current stock");
                System.out.println("2-List books by Categories");
                System.out.println("3-List books by Author");
                System.out.println("4-Borrow book");
                System.out.println("5-Give book back");
                System.out.println("6-Check Balance");
                System.out.println("7- Donate");
                System.out.println("9-Log out");


                String operations = scanner4.nextLine();
                switch (operations) {
                    case "0":
                        System.out.println("Thanks for visiting us " + loggedinPerson.getName() + " " + loggedinPerson.getLastname());
                        isOpen = false;
                        break;

                    case "1":
                        System.out.println(workintech.getBookMap());
                        break;

                    case "2":
                        System.out.println("Please choose the category of the book");
                        System.out.println("1- Sports");
                        System.out.println("2- Classics");
                        System.out.println("3- History");
                        System.out.println("4- Technology");
                        String categoryResult = scanner4.nextLine();
                        switch (categoryResult) {
                            case "1" -> System.out.println(workintech.listAllByCategories(Categories.SPORT));
                            case "2" -> System.out.println(workintech.listAllByCategories(Categories.CLASSICS));
                            case "3" -> System.out.println(workintech.listAllByCategories(Categories.HISTORY));
                            case "4" -> System.out.println(workintech.listAllByCategories(Categories.TECHNOLOGY));
                            default -> System.out.println("You entered an invalid category");
                        }
                        break;
                    case "3":
                        System.out.println("Please enter the author whose books you want to list ");
                        String authorName = scanner4.nextLine();
                        if (workintech.listAllByAuthors(authorName).isEmpty()) {
                            System.out.println("Sorry we don't have any books authored by " + authorName);
                        } else {
                            System.out.println(workintech.listAllByAuthors(authorName));
                        }

                        break;

                    case "4":

                        System.out.println("Please select the book you want to borrow");
                        System.out.println("How do you want to select the book ?");
                        System.out.println("1- With Id");
                        System.out.println("2- With Name");
                        System.out.println("3- With Author");
                        Book selectedBook;
                        String searchBookKey = scanner4.nextLine();

                        switch (searchBookKey) {
                            case "1":
                                System.out.println("Please enter the id of the book");

                                String bookId = scanner4.nextLine();
                                selectedBook = workintech.searchBookById(Integer.parseInt(bookId));
                                if (selectedBook != null) {
                                    workintech.bookBorrowed(loggedinPerson, selectedBook);

                                }
                                break;
                            case "2":
                                System.out.println("Please enter the name of the book");
                                String bookName = scanner4.nextLine();
                                selectedBook = workintech.searchBookByName(bookName);
                                if (selectedBook != null) {
                                    workintech.bookBorrowed(loggedinPerson, selectedBook);


                                }
                                break;
                            case "3":
                                System.out.println("Please enter the author of the book");

                                String authorName2 = scanner4.nextLine();

                                if (workintech.listAllByAuthors(authorName2).isEmpty()) {
                                    System.out.println("Sorry we don't have any books authored by " + authorName2);
                                } else {
                                    System.out.println(workintech.listAllByAuthors(authorName2));
                                    if (workintech.listAllByAuthors(authorName2).size() == 1) {
                                        selectedBook = workintech.searchBookByAuthor(authorName2);
                                        workintech.bookBorrowed(loggedinPerson, selectedBook);
                                    } else {

                                        System.out.println("The author has more than books you could have seen the ID and the name of the books" +
                                                "Please use name or Id to select the book.");

                                    }
                                    break;
                                }

                                break;


                        }
                        break;
                    case "5":
                        if (loggedinPerson.getBorrowedBooks().isEmpty()) {
                            System.out.println("You already don't have any book. So you cant give any book back.");
                            break;
                        } else {
                            System.out.println("Please select the book you want to give Back");
                            for (int i = 0; i < loggedinPerson.getBorrowedBooks().size(); i++) {
                                System.out.println((i + 1) + "- " + loggedinPerson.getBorrowedBooks().get(i));
                            }
                            int bookIndex = (Integer.parseInt(scanner4.nextLine())) - 1;
                            if (bookIndex >= 0 && bookIndex < loggedinPerson.getBorrowedBooks().size()) {
                                workintech.giveBackBook(loggedinPerson, loggedinPerson.getBorrowedBooks().get(bookIndex));
                                break;
                            } else {
                                System.out.println("Please enter a valid integer to give the book back");
                            }

                        }
                        break;
                    case "6":
                        System.out.println(loggedinPerson.getFinancialCheck());
                        break;
                    case "7":
                        System.out.println("Please enter the value you want to pay");
                        Double valueToDonate = Double.parseDouble(scanner4.nextLine());
                        loggedinPerson.getFinancialCheck().pay(valueToDonate);
                        System.out.println("Your payment has been succesfully loaded. \n" +
                                "Your balance is : " + loggedinPerson.getFinancialCheck().getCurrentBalance());
                        break;


                    case "9":

                        loggedinPerson = null;
                        break;


                }


            }


        }
    }
}