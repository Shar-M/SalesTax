package org.tw.salestax;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SalesTaxTest {

    @Test
    public void ToCheckIfTheCartIsNotEmptyAfterAddingAnItem() {
        ArrayList<String> inputItemList = new ArrayList<String>();
        inputItemList.add("1 book at 12.99");
        Cart cart = new Cart();
        cart.addItem(inputItemList);
        assertFalse(cart.isCartEmpty());

    }
    @Test
    public void checkIfItemsAreTaxExempted() {
        Item item1 = new Item(1,"Box of chocolates", false, 12.56);
        Item item2 = new Item(1,"Bottle  of perfume ", false, 20.00);
        assertTrue(item1.isTaxExempted());
        assertFalse(item2.isTaxExempted());
    }



}
