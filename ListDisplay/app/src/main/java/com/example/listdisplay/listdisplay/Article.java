package com.example.listdisplay.listdisplay;

/**
 * Created by Rebekah Justice on 9/11/16.
 */
public class Article {
    private int id;
    private String name;
    private double price;
    private String website;

    public Article(){
        super();
    }

    public Article(int id, String name, double price, String website) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.website = website;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + " [$" + this.price + "]";
    }

    public String getWebsite() {return this.website;}
}