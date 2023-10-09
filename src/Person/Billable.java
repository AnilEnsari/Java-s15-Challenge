package Person;

import Books.Book;

public interface Billable {
    public void  borrowBill(Book book);
    public void giveBackBill(Book book);

}
