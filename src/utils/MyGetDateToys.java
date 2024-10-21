/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class MyGetDateToys {
    
    private static final Scanner sc = new Scanner(System.in);
    
    //hàm dùng để chuẩn hóa ngày nhập vào
    public static String normalizeDateString(String input) {
        String result = input.replaceAll("[\\s]+", ""); //Loại bỏ các khoảng trống trong chuỗi nhập
        result = result.replaceAll("[-/.]+", "-"); //Thay thế các kí tự . / - bằng -
                                                   //"15...-/9--2024" --> "15.9.2024"
        return result;
    }
    
    //hàm chuyển chuỗi string thành date data
    public static Date pasrseDate(String inputStr, String dateFormat) {
        inputStr = normalizeDateString(inputStr);  //chuẩn hóa hàm chuẩn hóa
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            return formatter.parse(inputStr);
        } catch (ParseException e) {
            System.err.print(e);
        }
        return null;
    }
    
    //hàm chuyển kiểu dữ liệu date thành chuỗi
    public static String toString(Date date, String dateFormat) {
        if (date == null)
            return "";
        
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }
    
    //hàm dùng để lấy năm của data date
    public static int getPart(Date d, int calendarPart) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal.get(calendarPart);
    }
    
    //hàm để nhập ngày/tháng/năm theo dạng
    public static Date readDate(String inputMsg, String dateFormat) {
        String input;
        Date d;
        do {            
            System.out.print(inputMsg);
            input = sc.nextLine().trim();
            d = pasrseDate(input, dateFormat);
            if (d == null)
                return null;
        } while (d == null);
        return d;
    }
    
    //nhập ngày sau ngày hiện tại
    public static Date readDateAfter(String inputMsg, String dateFormat, Date dateMarker) {
        String input;
        Date d;
        boolean check = false;
        do {            
            System.out.print(inputMsg);
            input = sc.nextLine().trim();
            d = pasrseDate(input, dateFormat);
            check = (d != null && d.after(dateMarker));
            if (d == null)
                System.out.print("Date data is not valid!");
        } while (!check);
        return d;
    }
    
    //nhập ngày trước ngày hiện tại
    public static Date readDateBefore(String inputMsg, String dateFormat, Date dateMarker) {
        String input;
        Date d;
        boolean check = false;
        do {            
            System.out.print(inputMsg);
            input = sc.nextLine().trim();
            d = pasrseDate(input, dateFormat);
            check = (d != null && d.before(dateMarker));
            if (d == null)
                System.out.print("Date data is not valid!");
        } while (!check);
        return d;
    }
}
