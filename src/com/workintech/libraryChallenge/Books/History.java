package com.workintech.libraryChallenge.Books;


import com.workintech.libraryChallenge.Enums.Categories;


public class History extends Book {
    public History(int id, String name, String  author) {
        super(id, name, author);
        super.setCategories(Categories.HISTORY.getName());
        super.setRentPrice(Categories.HISTORY.getPrice());


    }
}
