package org.tw.salestax;


public class Item {
    private int quantity;
    private String itemName;
    private boolean isImported;
    private double cost;
    private String[] taxExemptedItems = {"book", "pills", "chocolate"};

    public Item(int quantity, String name, boolean isImported, double cost) {
        this.quantity = quantity;
        this.itemName = name;
        this.isImported = isImported;
        this.cost = cost;
    }


    public boolean isTaxExempted() {
        for (String taxExemptedItem : taxExemptedItems) {
            if (itemName.contains(taxExemptedItem))
                return true;
        }
        return false;
    }


    public double computeTax() {
        if (!isTaxExempted()) {
            cost = (cost + 0.1 * cost);
        }
        if (isImported) {
            cost = (cost + 0.05 * cost);
        }
        return cost;
    }
}
