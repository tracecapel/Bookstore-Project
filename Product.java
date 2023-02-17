package Project1;

import java.util.ArrayList;

public class Product {
    private String type;
    private String title;
    private String author;
    private int stock;
    private double price;
    
    public Product(String type, String title, String author, int stock, double price){
        this.type = type;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.price = price;
    }

     

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
