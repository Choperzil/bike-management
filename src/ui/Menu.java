/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.*;
import utils.MyToys;

/**
 *
 * @author Mr. Tuan
 */
public class Menu {
    private String menuTittle;
    private ArrayList<String> option = new ArrayList<>(); //khởi tạo cái Tủ để bỏ các option vào

    //khởi tạo tên của menu
    public Menu(String menuTittle) {
        this.menuTittle = menuTittle;
    }
    
    public void addOption(String newOption) {
        //hàm dùng để thêm vào các options cho menu
        option.add(newOption);
    }
    
    //in ra danh sách để người dùng chọn menu
    public void printMenu() {
        if (option.isEmpty())
            System.out.println("There is no option in the menu");
        
        System.out.println("-----------------------------");
        System.out.println("Welcome to " + this.menuTittle); 
        for (String x : option) {
            System.out.println(x);
        }
    }
    
    //hàm dùng đẻ người dùng chọn các chức năng của menu
    public int getChoice() {
        int maxOption = option.size();
        String inputMsg = "Choose option[1.." + maxOption + "]: ";
        //Choose option[1..n]:
        String errorMsg = "You are required to choose from 1 to " + maxOption;
        return MyToys.getInt(inputMsg, errorMsg, 1, maxOption);
    }
}
