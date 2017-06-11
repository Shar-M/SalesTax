package org.tw.salestax;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesTaxMain {
    public static void main(String[] args) {

        ArrayList<String> inputItemList = new ArrayList<String>();
        ArrayList<String> outputItemList;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = bufferedReader.readLine();
            while(line.length()!=0){
                inputItemList.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cart cart = new Cart();
        cart.addItem(inputItemList);
        BillCalculator billCalculator = new BillCalculator();
        outputItemList = billCalculator.generateBill(cart.getItems());
        for (String string : outputItemList) {
            System.out.println(string);
        }
        double totalSalesTax = billCalculator.getTotalSalesTax(cart.getItems());
        System.out.println("Sales Tax - " + (Math.floor(totalSalesTax * 100)) / 100);
        double totalBill = billCalculator.getTotalPrice(cart.getItems());
        System.out.println("Total Bill - " + Math.floor(totalBill * 100) / 100);
    }
}