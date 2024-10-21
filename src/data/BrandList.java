/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import utils.FileUtil;

/**
 *
 * @author Mr. Tuan
 */
public class BrandList extends ArrayList<Brand> {
    
    private static final String BRAND_FILE = "01_Brand.txt";
    
    public static BrandList loadBrandFromFile() {
        BrandList list = new BrandList();
        List<String> lines = FileUtil.readFile(BRAND_FILE);
        for (String line : lines) {
            String[] parts = line.split(",", 3);
            String brandID = parts[0];
            String type = parts[1];
            String country = parts[2];
            list.add(new Brand(brandID, type, country));
        }
        return list;
    }
    
    public Brand searchBrandById(String id) {
        for (Brand x : this) {
            if (x.getBrandID().equals(id))
                return x;
        }
        return null;
    }
    
    public void display() {
        for (Brand x : this) {
            System.out.println(x);
        }
    }
}
