/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;


public class MyToys {

    private static final Scanner sc = new Scanner(System.in);
    

    public static String getString(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 | str.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return str.trim();
            }
        }
    }

    public static String getString() {
        return sc.nextLine().trim();
    }

    public static int getInt(String inputMsg, String errorMsg) {
        int x;
        while (true) {
            try {
                System.out.print(inputMsg);
                x = Integer.parseInt(sc.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getInt(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n;

        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) 
                    throw new Exception();
                return n;
                
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getDouble(String inputMsg, String errorMsg) {
        double x;
        while (true) {
            try {
                System.out.print(inputMsg);
                x = Double.parseDouble(sc.nextLine());
                if (x < 0)
                    System.out.println("Enter positive value!");
                else
                    return x;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getID(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }
    
    public static String getID(String inputMsg, String errorMsg, String pattern) {
        String id;
        boolean match;
        while (true) {            
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(pattern);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
              else
                return id;
        }
    }

    public static boolean parseBoolean(String input) {
        input = input.trim().toUpperCase();
        char c = input.charAt(0);
        return c == 'Y' || c == '1' || c == 'T';
    }
    
    public static boolean getBoolean(String inputMsg) {
        System.out.print(inputMsg);
        String id = sc.nextLine();
        if (id.isEmpty() || id.length() == 0)
            return false;
        else
            return parseBoolean(id);
    }
    
    public static boolean getBoolean(String inputMsg, String errorMsg) {
        while (true) {            
            System.out.print(inputMsg);
            String id = sc.nextLine();
            if (id.isEmpty() || id.length() == 0)
                System.out.println(errorMsg);
            else
                return parseBoolean(id);
        }
    }
    
    
    public static void main(String[] args) {
        String id = getID("Enter id (Cxxx): ", "Wrong format X stands for a digit", "^[C|c]\\d{3}$");
        System.out.println("Id:" + id);
    }

}
