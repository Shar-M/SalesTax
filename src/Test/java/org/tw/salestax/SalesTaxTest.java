package org.tw.salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SalesTaxTest {

    @Test
    public void ToCheckIfTheCartIsNotEmptyAfterAddingAnItem() {
        Item item = new Item("1 book at 12.99");

        Cart cart = new Cart();
        cart.add(item);
        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.getTotal(cart);

        assertFalse(cart.isCartEmpty());

    }


}
