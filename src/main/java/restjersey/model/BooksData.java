package main.java.restjersey.model;


import org.json.JSONArray;

import javax.persistence.EntityManager;
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
        if (book.getID() > books.size()) {
            return false;
        } else {
            books.set(book.getID()-1, book);
            return true;
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByID(int id) {
        for (Book book : mockedBooks.getBooks()) {
            if (book.getID() == id) {
                return book;
            }
        }
        return null;
    }

    public void deleteBook(int id) {
        for (Book book : mockedBooks.getBooks()) {
            if (book.getID() == id) {
                mockedBooks.getBooks().remove(book);
            }
        }
    }

    public JSONArray toJsonArray() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(books);
        return jsonArray;
    }


}
