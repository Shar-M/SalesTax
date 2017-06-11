package org.tw.salestax;


import java.util.ArrayList;

public class SalesTaxMain {
    public static void main(String[] args) {

        ArrayList<String> inputItemList = new ArrayList<String>();
        ArrayList<String> outputItemList;

        inputItemList.add("1 Box of chocolates at 10.00");
        inputItemList.add("1 imported book at 12.99");

        Cart cart = new Cart();
        cart.addItem(inputItemList);
        BillCalculator billCalculator = new BillCalculator();
        outputItemList = billCalculator.generateBill(cart.getItems());
        for (String string : outputItemList) {
            System.out.println(string);
        }
        double totalSalesTax = billCalculator.getTotalSalesTax(cart.getItems());
        System.out.println("Sales Tax - s" + (Math.floor(totalSalesTax * 100)) / 100);
        double totalBill = billCalculator.getTotalPrice(cart.getItems());
        System.out.println("Total Bill - " + Math.floor(totalBill * 100) / 100);
    }
}