package main.java.restjersey;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class MockedBooks {
    private List<Book> books = new LinkedList<>();
    private static MockedBooks mockedBooks;

    private MockedBooks() {
    }

    public static MockedBooks getInstance() {
        if (mockedBooks == null) {
            mockedBooks = new MockedBooks();
        }
        return mockedBooks;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public void putBook(int id, Book book) {
        books.set(id, book);
    }

    public void deleteBook(int id) {
        books.remove(id);
    }

    public JSONArray toJsonArray(){
        JSONArray jsonArray =new JSONArray();
        jsonArray.put(books);
        return jsonArray;
    }


}
