package com.workintech.libraryChallenge.Person;

import com.workintech.libraryChallenge.Books.Book;

public interface Billable {
    public void  borrowBill(Book book);
    public void giveBackBill(Book book);

}
