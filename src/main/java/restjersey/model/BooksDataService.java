package main.java.restjersey.model;


import org.json.JSONArray;

import java.util.LinkedList;
import java.util.List;

public class BooksDataService {
    private static List<Book> books = new LinkedList<>();
    private static BooksDataService mockedBooks;

    private BooksDataService() {
    }

    public static BooksDataService getInstance() {
        if (mockedBooks == null) {
            mockedBooks = new BooksDataService();
        }
        return mockedBooks;
    }

    public Book addBook(Book book) {
        book.setID(books.size() + 1);
        books.add(book);
        return book;
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

    public void putBook(int id, Book book) {
        books.set(id, book);
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
