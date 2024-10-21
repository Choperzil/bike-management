/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author Mr. Tuan
 */
public class Product implements Comparable<Product>{
    private String id;
    private String name;
    private String brandID;
    private String categoryID;
    private int modelYear = 0;
    private double price;

    //Constructor
    public Product(String id, String name, String brandID, String categoryID, int modelYear, double price) {
        this.id = id;
        this.name = name;
        this.brandID = brandID;
        this.categoryID = categoryID;
        this.modelYear = modelYear;
        this.price = price;
    }

    //Getters, setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    
    public int getModelYear() {
        return modelYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //toString method
    @Override
    public String toString() {
        return  id + ", " + name + ", " + brandID + ", " + categoryID + ", " + modelYear + ", " + price;
    }

    //compare method
    @Override
    public int compareTo(Product o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
}
