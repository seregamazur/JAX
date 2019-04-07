package main.java.restjersey.model;


import org.json.JSONArray;

import java.util.LinkedList;
import java.util.List;

public class BooksData {
    private static List<Book> books = new LinkedList<>();
    private static BooksData mockedBooks;

    private BooksData() {
    }

    public static BooksData getInstance() {
        if (mockedBooks == null) {
            mockedBooks = new BooksData();
            initializeShell();
        }
        return mockedBooks;
    }

    public boolean addBook(Book book) {
        if (books.contains(book)) {
            return false;
        } else {
            book.setID(books.size() + 1);
            books.add(book);
        }
        return true;
    }

    public boolean editBook(Book book) {
        if (book.getID() > books.size()|| book.getID()<1) {
            return false;
        } else {
            books.set(book.getID() - 1, book);
            return true;
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByID(int id) {
        if(id>books.size() || id<1){
            return null;
        }
        for (Book book : mockedBooks.getBooks()) {
            if (book.getID() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int id) {
        if (id > books.size() || id<1) {
            return false;
        } else {
            for (Book book : mockedBooks.getBooks()) {
                if (book.getID() == id) {
                    mockedBooks.getBooks().remove(book);
                }
            }
        }
        return true;
    }

    public JSONArray toJsonArray() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(books);
        return jsonArray;
    }

     private static void initializeShell() {
        books.add(new Book(1, "First Book", "Serhiy Mazur", 10));
        books.add(new Book(2, "Second Book", "Serhiy Mazur", 11));
        books.add(new Book(3, "Third Book", "Serhiy Mazur", 12));
    }


}
