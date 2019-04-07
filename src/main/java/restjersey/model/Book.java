package main.java.restjersey.model;

import org.json.JSONObject;

public class Book {

    private int ID;
    private String name;
    private String author;
    private int price;

    public Book() {
    }

    public Book(int ID, String name, String author, int price) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ID:", this.ID);
        jsonObject.put("name:", this.name);
        jsonObject.put("author:", this.author);
        jsonObject.put("price:", this.price);
        return jsonObject;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.name.equals(book.name) && this.author.equals(book.author);
        }
        return false;
    }
}