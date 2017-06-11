package org.tw.salestax;


import java.util.ArrayList;


public class Cart {

    private boolean isCartEmpty = true;
    private ArrayList<Item> items = new ArrayList<>();
    private static final String AT = " at ";
    private static final String IMPORTED = " imported ";
    public boolean isCartEmpty() {
        return isCartEmpty;
    }


    public void addItem(ArrayList<String> inputItemList) {
        isCartEmpty = false;
        for (String inputItem : inputItemList) {
            String[] itemDetails = inputItem.split(AT);
            double shelfPrice = Double.parseDouble(itemDetails[1]);

            int quantity = getQuantity(itemDetails[0]);
            String name = getItemName(itemDetails[0]);

            boolean isImported = false;
            if (itemDetails[0].contains(IMPORTED))
                isImported = true;

            items.add(new Item(quantity, name, isImported, shelfPrice));

        }
    }


    String getItemName(String itemDetail) {
        String[] itemName = itemDetail.split("", 2);
        return itemName[1];
    }

    int getQuantity(String itemDetails) {
        String[] itemQuantity = itemDetails.split("");
        return Integer.parseInt(itemQuantity[0]);

    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
