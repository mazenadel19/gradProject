package com.example.acer_pc.radar;

/**
 * Created by Acer-PC on 26-Jun-17.
 */

public class OtherUserProduct {


    private int image_id;
    private String title;
    private String state;
    private String condition;
    private String price;
    private String region;

    private String transmission;
    private String model;
    private String kilometer;
    private String year;
    private String description;



    public OtherUserProduct(int image_id, String title, String state, String condition, String price, String region,String transmission,String model,String kilometer
            ,String year,String description){

        this.setImage_id(image_id);
        this.setTitle(title);
        this.setState(state);
        this.setCondition(condition);
        this.setPrice(price);
        this.setRegion(region);

        this.setTransmission(transmission);
        this.setModel(model);
        this.setKilometer(kilometer);
        this.setYear(year);
        this.setDescription(description);

    }


    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKilometer() {
        return kilometer;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
