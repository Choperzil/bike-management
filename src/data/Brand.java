/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Mr. Tuan
 */
public class Brand {
    private String brandID;
    private String type;
    private String country;

    //Constructor
    public Brand(String brandID, String type, String country) {
        this.brandID = brandID;
        this.type = type;
        this.country = country;
    }

    //Getters, setters
    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //toString method
    @Override
    public String toString() {
        return "Brand{" + "brandID=" + brandID + ", type=" + type + ", country=" + country + '}';
    }
}
