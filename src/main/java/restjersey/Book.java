package main.java.restjersey;

import org.json.JSONObject;

public class Book {
    private String name;
    private float price;
    private String author;

    public Book(String name, String author, float price) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Book name:", this.name);
        jsonObject.put("Book author:", this.author);
        jsonObject.put("Book price:", this.price);
        return jsonObject;
    }


}

