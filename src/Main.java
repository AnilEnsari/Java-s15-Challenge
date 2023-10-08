
import Person.Student;
import Person.Person;


public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Person anil = new Student("Anil","Ensari");

        System.out.println(library.getBookMap());
        System.out.println(library.getBookList());

    }
}