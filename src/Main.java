
import Enums.Categories;
import Person.Student;
import Person.Person;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Library workintech = new Library();
        Person anil = new Student(1, "Anil", "Ensari");
        Person icardi = new Person(2, "Mauro", "Icardi");
        workintech.addPersonToLibrary(anil);
        workintech.addPersonToLibrary(icardi);
        boolean isOpen = true;
        Person loggedinPerson = null;
        while (isOpen) {


            if (loggedinPerson == null) {
                System.out.println("Hello, wellcome to our library!");
                System.out.println("If you dont have an account please register or login");

                Scanner scanner = new Scanner(System.in);
                System.out.println("1- Login");
                System.out.println("2- Register");
                System.out.println("3- admin");

                System.out.println("0- Exit");
                String loginPerson = scanner.next();
                switch (loginPerson) {
                    case "0":
                        System.out.println("Hope to see you again!");
                        isOpen = false;
                        break;

                    case "1":
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Please enter your id");
                        String id1 = scanner2.next();
                        for (Person persons : workintech.getPersonList()) {

                            if (persons.getId() == Integer.parseInt(id1)) {
                                loggedinPerson = persons;
                                System.out.println("You have succesfully logged in.");
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
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Please enter an integer id you want to have! ");

                        String id2 = scanner3.next();
                        int validatedId = 0;
                        for (Person persons : workintech.getPersonList()) {
                            if (persons.getId() == Integer.parseInt(id2)) {
                                System.out.println("Your entered id is used. Please try again a new id");
                                validatedId = 0;
                                break;
                            }

                            validatedId = Integer.parseInt(id2);

                        }
                        if (validatedId == Integer.parseInt(id2)) {
                            System.out.println("Please enter your Name");
                            String firstName2 = scanner.next();
                            System.out.println("Please enter your Lastname");
                            String lastName2 = scanner.next();
                            System.out.println("Are you a student ?");
                            System.out.println("1- Yes ");
                            System.out.println("2- No");
                            String isStudent = scanner.next();
                            if (isStudent.equals("1")){
                                loggedinPerson= new Student(validatedId,firstName2,lastName2);
                            }
                            else {
                                loggedinPerson= new Person(validatedId,firstName2,lastName2);
                            }
                            workintech.addPersonToLibrary(loggedinPerson);
                            System.out.println("Congrulations you have been registered!");
                            break ;



                        }


                }
            } else {
                System.out.println("Login has been successful lets start to operations.");
                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Please select the operation you want to do");
                System.out.println("0-Exit");
                System.out.println("1-List All Book by Current Stock");
                System.out.println("2-List Books by Categories");
                System.out.println("3-List Books by Author");
                System.out.println("4-Borrow Book");
                System.out.println("5-Give Book Back");



                String operations = scanner4.next();
switch (operations){
    case "0" :
        System.out.println("Thanks for visiting us "+loggedinPerson.getName()+" "+loggedinPerson.getLastname());
        isOpen=false ;
        break;

    case "1":
        System.out.println(workintech.getBookMap());
        break;

    case "2":
        System.out.println("Lütfen aramak istediğiniz kategoriyi seçin");
        System.out.println("1- Sports");
        System.out.println("2- Classics");
        System.out.println("3- History");
        System.out.println("4- Technology");
       String categoryResult = scanner4.next();
        switch (categoryResult) {
            case "1" -> System.out.println(workintech.listAllByCategories(Categories.SPORT));
            case "2" -> System.out.println(workintech.listAllByCategories(Categories.CLASSICS));
            case "3" -> System.out.println(workintech.listAllByCategories(Categories.HISTORY));
            case "4" -> System.out.println(workintech.listAllByCategories(Categories.TECHNOLOGY));
            default -> System.out.println("You entered an invalid id");
        }





}






            }


        }
    }
}