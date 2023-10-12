package com.workintech.libraryChallenge.Books;


import com.workintech.libraryChallenge.Enums.Categories;


public class Technology extends Book {
    public Technology(int id, String name, String author) {
        super(id, name, author);
        super.setCategories(Categories.TECHNOLOGY.getName());
        super.setRentPrice(Categories.TECHNOLOGY.getPrice());
    }
}
