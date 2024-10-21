/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikemanagement;

import data.BrandList;
import data.CategoryList;
import data.ProductList;
import ui.Menu;

/**
 *
 * @author Mr. Tuan
 */
public class BikeManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("My Menu");
        menu.addOption("1. Add a product.");
        menu.addOption("2. Search product by product name.");
        menu.addOption("3. Update product.");
        menu.addOption("4. Delete product.");
        menu.addOption("5. Save products to file.");
        menu.addOption("6. Print list products from the file.");
        menu.addOption("7. Quit.");
        
        BrandList brandList = BrandList.loadBrandFromFile();
        CategoryList categoryList = CategoryList.loadCategoryromFile();
        ProductList productList = ProductList.loadProductFromFile();
        
        int choice;
        do {            
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    productList.addBrand(brandList, categoryList);
                    break;
                case 2:
                    productList.getProductByName();
                    break;
                case 3:
                    productList.updateProduct(brandList, categoryList);
                    break;
                case 4:
                    productList.deleteProduct();
                    break;    
                case 5:
                    productList.saveProductToFile();
                    break;
                case 6:
                    productList.display();
                    break;
                case 7:
                    System.out.println("Goodbye! See you later!");
                    break;    
            }
        } while (choice < 7);
        
    }
    
}
