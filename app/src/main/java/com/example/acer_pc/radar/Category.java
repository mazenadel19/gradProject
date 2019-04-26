package com.example.acer_pc.radar;

/**
 * Created by Acer-PC on 10-Jun-17.
 */

public class Category {

    private String name;
    private  int img;

    public Category(String name, int img)
    {
        this.name=name;
        this.img=img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


}
