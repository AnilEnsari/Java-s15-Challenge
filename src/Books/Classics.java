package Books;

import Enums.Categories;

public class Classics extends Book {

    public Classics(int id, String name, String author) {
        super(id, name, author);
        super.setCategories(Categories.CLASSICS.getName());
        super.setRentPrice(Categories.CLASSICS.getPrice());
    }
}
