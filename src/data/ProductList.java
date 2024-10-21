/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;
import utils.FileUtil;
import utils.MyGetDateToys;
import utils.MyToys;
import static utils.MyToys.getID;

/**
 *
 * @author Mr. Tuan
 */
public class ProductList extends ArrayList<Product> {
    
    private final Scanner sc = new Scanner(System.in);
   
    private static final String PRODUCT_FILE = "01_Product.txt";
    
    //add product method
    public void addBrand(BrandList brandList, CategoryList categoryList) {
        String id, name, brandID, categoryID;
        Date modelDate;
        int modelYear = 0;
        double price;
        
        do {            
            id = MyToys.getID("Enter product's ID: ", "Can not be blanked!");
            if (searchProductById(id) != null)
                System.out.println("Product's ID can not be duplicated!");
        } while (searchProductById(id) != null);
        
        name = MyToys.getString("Enter product's name: ", "Can not be blanked!");
       
        Brand brand;
        do {            
            brandID = MyToys.getID("Enter id (Bxxx): ", "Wrong format(x stands for a digit)!", "^[B|b]\\d{3}$");
            if (brandList.searchBrandById(brandID) == null)
                System.out.println("Brand's ID does not exist");
            else
                break;
        } while (brandList.searchBrandById(id) == null);
        
        do {            
            categoryID = MyToys.getID("Enter id (Cxxx): ", "Wrong format(x stands for a digit)! ", "^[C|c]\\d{3}$");
            if (categoryList.searchCategoryById(categoryID) == null)
                System.out.println("Category's ID does not exist");
        } while (categoryList.searchCategoryById(categoryID) == null);
        
        
        do {            
            modelDate = MyGetDateToys.readDate("Enter model date (dd-MM-yyyy): ", "dd-MM-yyyy");
            if (modelDate != null) {
                modelYear = MyGetDateToys.getPart(modelDate, Calendar.YEAR);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                if (modelYear < 1990 || modelYear > currentYear) {
                    System.out.println("Invalid model year!");
                    modelDate = null;
                } 
            }
        } while (modelDate == null);
        
        price = MyToys.getDouble("Enter price: ", "Can not be blanked!");
        this.add(new Product(id, name, brandID, categoryID, modelYear, price));
        System.out.println("Added successfully!");
    }
    
    //print a part of product name
    public void getProductByName() {
        System.out.print("Enter a part of product name: ");
        String name = sc.nextLine().toLowerCase().trim();  //enter a search string
        List<Product> matchingProducts = new ArrayList<>();
        
        for (Product product : this) { 
            if (product.getName().toLowerCase().contains(name)) //check the products that has the search string inside
                matchingProducts.add(product); //add products with search string to list
        }
        
        if (matchingProducts.isEmpty())
            System.out.println("There is no matched products!");
        else {
            matchingProducts.sort(Comparator.comparingInt(Product::getModelYear)); //sort by year
            System.out.println("Matching products: ");
            for (Product product : matchingProducts) {
                System.out.println(product);
            }
        }
    }
    
    //update method
    public boolean updateProduct(BrandList brandList, CategoryList categoryList) {
        System.out.print("Enter product's ID: ");
        String id = sc.nextLine().trim();
        
        Product pos = searchProductById(id);
        if (pos == null) {
            System.out.println("Product does not exist");
            return false;
        } else {
            System.out.print("Enter product's name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Update failed!");
                return false;
            }
            
            System.out.print("Enter brand's ID (Bxxx): ");
            String brandID = sc.nextLine().toUpperCase().trim();
            if (brandList.searchBrandById(brandID) == null) {
                System.out.println("Update failed!");
                return false;
            }
            
            System.out.print("Enter category's ID (Cxxx): ");
            String categoryID = sc.nextLine().toUpperCase().trim();
            if (categoryList.searchCategoryById(categoryID) == null) {
                System.out.println("Update failed!");
                return false;
            }
            
            System.out.print("Enter model date: ");
            String input = sc.nextLine();
            Date modelDate;
            int modelYear;
            if (input.isEmpty()) {
                System.out.println("Update failed!");
                return false;
            } else {
                modelDate = MyGetDateToys.pasrseDate(input, "dd-MM-yyyy");
                modelYear = MyGetDateToys.getPart(modelDate, Calendar.YEAR);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                if (modelYear < 1990 || modelYear > currentYear) {
                    System.out.println("Invalid model year!");
                    System.out.println("Update failed!");
                    return false;
                } 
            }
            
            System.out.print("Enter price: ");
            String inputPrice = sc.nextLine();
            double price;
            if (inputPrice.isEmpty()) {
                System.out.println("Update failed!");
                return false;
            } else {
                price = Double.parseDouble(inputPrice);
                if (price <= 0) {
                    System.out.println("Price must be above 0!");
                    System.out.println("Update failed!");
                    return false;
                }
            }
            
            Product update = pos;
            update.setName(name);
            update.setBrandID(brandID);
            update.setCategoryID(categoryID);
            update.setModelYear(modelYear);
            update.setPrice(price);
            System.out.println("Update successfully!");
        }
        return true;
    }
    
    //delete method
    public boolean deleteProduct() {
        System.out.print("Enter product's ID: ");
        String id = sc.nextLine().trim();
        
        Product pos = searchProductById(id);
        if (pos == null) {
            System.out.println("Product does not exist");
            return false;
        } else {
            boolean check = MyToys.getBoolean("Are you sure you want too delete: ");
            if (check == false) {
                System.out.print("Update failed!");
                return false;
            } else
                this.remove(pos);
            System.out.println("Remove successfully!");
        }
        return true;
    }
    
    //save to file method
    public void saveProductToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCT_FILE))) {
            for (Product x : this) {
                writer.write(x.getId() + "," + x.getName() + "," + x.getBrandID() + "," 
                        + x.getCategoryID() + "," + x.getModelYear() + "," + x.getPrice());
                writer.newLine();
            }
            System.out.println("Save successfully!");
        } catch (IOException e) {
            System.out.println("Save failed!");
        }
    }
    
    //load from file method
    public static ProductList loadProductFromFile() {
        ProductList list = new ProductList();
        List<String> lines = FileUtil.readFile(PRODUCT_FILE);
        for (String line : lines) {
            String[] parts = line.split(",", 6);
            String id = parts[0];
            String name = parts[1];
            String brandID = parts[2];
            String categoryID = parts[3];
            int modelYear = Integer.parseInt(parts[4]);
            double price = Double.parseDouble(parts[5]);
            list.add(new Product(id, name, brandID, categoryID, modelYear, price));
        }
        return list;
    }
  
    //search method
    public Product searchProductById(String id) {
        for (Product x : this) {
            if (x.getId().equalsIgnoreCase(id))
                return x;
        }
        return null;
    }
    
    //print products method
    public void display() {
        Collections.sort(this);
        for (Product x : this) {
            System.out.println(x);
        }
    }
    
    
    
}
