package org.tw.salestax;


public class Item {
    private int quantity;
    private String itemName;
    private boolean isImported;
    private double cost;
    private String[] taxExemptedItems = {"book", "pills", "chocolate"};
    private double salesTax;
    private double finalPrice = 0;

    Item(int quantity, String name, boolean isImported, double cost) {
        this.quantity = quantity;
        this.itemName = name;
        this.isImported = isImported;
        this.cost = cost;
        computeTax();
    }


    boolean isTaxExempted() {
        for (String taxExemptedItem : taxExemptedItems) {
            if (itemName.contains(taxExemptedItem))
                return true;
        }
        return false;
    }


    double computeTax() {
        salesTax = 0;
        if (!isTaxExempted()) {
            salesTax = (0.1 * cost);
        }
        if (isImported) {
            salesTax += (0.05 * cost);
        }
        return salesTax;
    }

    double getFinalPrice() {
        finalPrice = cost + salesTax;
        return finalPrice;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return getQuantity() + " " + getItemName() + " - " + getFinalPrice() + "\n";
    }
}
