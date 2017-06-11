package org.tw.salestax;


import java.util.ArrayList;

public class BillCalculator {
    double totalSalesTax = 0;
    double totalBill = 0;
    ArrayList<String> itemsList= new ArrayList<>();



    double getTotalSalesTax(ArrayList<Item> items) {
        for (Item item : items) {
            totalSalesTax += item.getSalesTax();
        }
        return totalSalesTax;
    }

    double getTotalPrice(ArrayList<Item> items) {
        for (Item item : items) {
            totalBill += item.getFinalPrice();
        }
        return totalBill;
    }
    ArrayList<String> generateBill(ArrayList<Item> items){
        for (Item item: items) {
            itemsList.add(item.toString());
        }
        return itemsList;

    }

}
