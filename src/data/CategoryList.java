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
public class CategoryList extends ArrayList<Category> {
    private static final String CATEGORY_FILE = "01_Category.txt";
    
    public static CategoryList loadCategoryromFile() {
        CategoryList list = new CategoryList();
        List<String> lines = FileUtil.readFile(CATEGORY_FILE);
        for (String line : lines) {
            String[] parts = line.split(",", 2);
            String id = parts[0];
            String name = parts[1];
            list.add(new Category(id, name));
        }
        return list;
    }
    
    public Category searchCategoryById(String id) {
        for (Category x : this) {
            if (x.getId().equals(id))
                return x;
        }
        return null;
    }
    
    public void display() {
        for (Category x : this) {
            System.out.println(x);
        }
    }
}
