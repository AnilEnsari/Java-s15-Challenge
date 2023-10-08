package Person;

import Books.Book;

import java.util.List;

public  class  Student extends Person {


    public Student(String name, String lastname) {
        super(name, lastname);
    }




    @Override
    public String toString() {
        return "Student{} " + super.toString();
    }
}
