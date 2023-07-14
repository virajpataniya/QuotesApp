package com.vyp.quotes.Model;

/**
 * Created by Admin on 21-06-2018.
 */

public class QuoteModel {
    private String quote;
    private String timestamp;
    private int id;
    private String row;
    private String category;

//    public QuoteModel(String quote) {
//        this.quote = quote;
//    }

    public String getQuote() {
        return quote;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getRow() {
        return row;
    }

    public String getCategory() {
        return category;
    }
}
