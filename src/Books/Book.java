package Books;

import Enums.Categories;


import java.util.Objects;

public class Book {
   private int id ;
    private String name;
    private String author ;
    private double rentPrice ;

    private String categories;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;

    }

    public Book(int id, String name, String author, Categories categories) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.rentPrice = categories.getPrice();
        this.categories = categories.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
    public void setBook(Book book){
        this.setId(book.getId());
        this.setName(book.getName());
        this.setAuthor(book.getAuthor());
        this.setCategories(book.getCategories());
        this.setRentPrice(book.getRentPrice());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", rentPrice=" + rentPrice +
                ", categories='" + categories + '\'' +
                '}';
    }

}
