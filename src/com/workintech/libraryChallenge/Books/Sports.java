package com.workintech.libraryChallenge.Books;


import com.workintech.libraryChallenge.Enums.Categories;


public class Sports extends Book {
    public Sports(int id, String name, String author) {
        super(id, name, author);
        super.setCategories(Categories.SPORT.getName());
        super.setRentPrice(Categories.SPORT.getPrice());

    }
}
