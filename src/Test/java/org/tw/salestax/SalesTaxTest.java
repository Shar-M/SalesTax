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
        Item item1 = new Item(1,"Box of chocolates", false, 12.99);
        Item item2 = new Item(1,"Bottle  of perfume ", false, 20.00);
        assertTrue(item1.isTaxExempted());
        assertFalse(item2.isTaxExempted());
    }

    @Test
    public void taxOnATaxExemptedItemShouldBeZero(){
        Item item = new Item(1,"Box of chocolates", false, 10.00);
        assertEquals(0, item.computeTax(), 0.1);
    }

    @Test
    public void priceOfAnImportedItemShouldBeFivePercentMoreThanTheShelfPrice(){
        Item item = new Item(1,"Box of chocolates", true, 10.00);
        assertEquals(10.50, item.getFinalPrice(), 0.1);
    }

    @Test
    public void priceOfATaxableItemShouldBeTenPercentMoreThanTheShelfPrice(){
        Item item = new Item(1,"Music CD", false, 10.00);
        assertEquals(11.0, item.getFinalPrice(), 0.1);
    }
    @Test
    public void priceOfATaxableImportedItemShouldBeFifteenPercentMoreThanTheShelfPrice(){
        Item item = new Item(1,"Music DVD", true, 10.00);
        assertEquals(11.5, item.getFinalPrice(), 0.1);
    }
    @Test
    public void sumOfSalesTaxesOfAllItemsInTheCart(){
        ArrayList<String> inputItemList = new ArrayList<String>();
        inputItemList.add("1 Box of chocolates at 10.00");
        inputItemList.add("1 imported book at 20.00" );
        Cart cart = new Cart();
        cart.addItem(inputItemList);
        BillCalculator billCalculator = new BillCalculator();
        assertEquals(1.0, billCalculator.getTotalSalesTax(cart.getItems()),0.1);

    }
    @Test
    public void shouldGetTotalBillOfAllItemsInTheCart(){
        ArrayList<String> inputItemList = new ArrayList<String>();
        inputItemList.add("1 Box of chocolates at 10.00");
        inputItemList.add("1 imported book at 20.00" );
        Cart cart = new Cart();
        cart.addItem(inputItemList);
        BillCalculator billCalculator = new BillCalculator();
        assertEquals(31.00, billCalculator.getTotalPrice(cart.getItems()),0.1);
    }
    @Test
    public void shouldOutputTheAddedItemAsAString() {
        Item item = new Item(1, "Box of chocolates", true, 10.00);
        assertEquals(("1 Box of chocolates - 10.5"),item.toString());
    }
    @Test
    public void shouldOutputMultipleAddedItemsAsAnArrayList(){
        ArrayList<String> inputItemList = new ArrayList<String>();
        ArrayList<String> outputItemList;
        ArrayList<String> expectedItemList = new ArrayList<String>();

        inputItemList.add("1 Box of chocolates at 10.00");
        inputItemList.add("1 imported book at 12.99" );
        expectedItemList.add("1  Box of chocolates - 10.0");
        expectedItemList.add("1  imported book - 13.6395");
        Cart cart = new Cart();
        cart.addItem(inputItemList);
        BillCalculator billCalculator = new BillCalculator();
        outputItemList = billCalculator.generateBill(cart.getItems());

        assertEquals(expectedItemList, outputItemList);
    }
}
