package org.tw.salestax;


import java.util.HashMap;
import java.util.Map;

public class Cart {

    private boolean isCartEmpty = true;

    public void add(Item item) {
        isCartEmpty = false;
    }

    public boolean isCartEmpty() {
        return isCartEmpty;
    }



}
