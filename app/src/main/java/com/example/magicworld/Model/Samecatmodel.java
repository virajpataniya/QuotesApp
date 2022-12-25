package com.example.magicworld.Model;

public class Samecatmodel {
    private String shaPara;

    public Samecatmodel(String shaPara){
        this.shaPara=shaPara;
    }

    public String getCategory() {
        return shaPara;
    }

    public void setCategory(String category) {
        this.shaPara = category;
    }
}
