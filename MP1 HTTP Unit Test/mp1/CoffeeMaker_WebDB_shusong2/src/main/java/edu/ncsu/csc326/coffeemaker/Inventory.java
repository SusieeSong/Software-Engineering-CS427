package edu.ncsu.csc326.coffeemaker;
import  edu.ncsu.csc326.coffeemaker.db.InventoryDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

/**
 * @author Sarah Heckman
 * The Inventory class contains the amounts of all the
 * inventory in the CoffeeMaker system.  The types of
 * inventory in the system include coffee, milk, sugar
 * and chocolate.
 */

public class Inventory {

    /**
     * Inventory for coffee, milk, sugar, chocolate
     * coffee      Amount of coffee in the current inventory
     * milk        Amount of milk in the current inventory
     * sugar       Amount of sugar in the current inventory
     * chocolate   Amount of sugar in the current inventory
     */

    private int coffee;
    private int milk;
    private int sugar;
    private int chocolate;

    /**
     * Clear the database before first initialize the inventory
     * Creates a coffee maker inventory object and
     * fills each item in the inventory with 15 units.
     */
    public Inventory() {
        InventoryDB.clearInventory();
        setCoffee(15);
        setMilk(15);
        setSugar(15);
        setChocolate(15);
    }

    /**
     * Returns the current number of chocolate units in
     * the inventory.
     * @return int
     */
    public int getChocolate() {
        InventoryDB curDb = new InventoryDB();
        int check[] = curDb.checkInventory();
        return check[3];
    }

    /**
     * Sets the number of chocolate units in the inventory
     * to the specified amount.
     * @param chocolate
     */
    public synchronized void setChocolate(int chocolate) {
        if(chocolate >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(0,0,0,chocolate);
            //Inventory.chocolate = chocolate;
        }
    }

    /**
     * Add the number of chocolate units in the inventory
     * to the current amount of chocolate units.
     * @param chocolate
     * @throws InventoryException
     */
    public synchronized void addChocolate(String chocolate) throws InventoryException {
        int amtChocolate = 0;
        try {
            amtChocolate = Integer.parseInt(chocolate);
        } catch (NumberFormatException e) {
            throw new InventoryException("Units of chocolate must be a positive integer");
        }
        if (amtChocolate >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(0,0,0,amtChocolate);
            //Inventory.chocolate += amtChocolate;
        } else {
            throw new InventoryException("Units of chocolate must be a positive integer");
        }
    }

    /**
     * Returns the current number of coffee units in
     * the inventory.
     * @return int
     */
    public int getCoffee() {
        InventoryDB curDb = new InventoryDB();
        int check[] = curDb.checkInventory();
        return check[0];
        //return coffee;
    }

    /**
     * Sets the number of coffee units in the inventory
     * to the specified amount.
     * @param coffee
     */
    public synchronized void setCoffee(int coffee) {
        if(coffee >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(coffee,0,0,0);
            //Inventory.coffee = coffee;
        }
    }

    /**
     * Add the number of coffee units in the inventory
     * to the current amount of coffee units.
     * @param coffee
     * @throws InventoryException
     */
    public synchronized void addCoffee(String coffee) throws InventoryException {
        int amtCoffee = 0;
        try {
            amtCoffee = Integer.parseInt(coffee);
        } catch (NumberFormatException e) {
            throw new InventoryException("Units of coffee must be a positive integer");
        }
        if (amtCoffee >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(amtCoffee,0,0,0);
            //Inventory.coffee += amtCoffee;
        } else {
            throw new InventoryException("Units of coffee must be a positive integer");
        }
    }

    /**
     * Returns the current number of milk units in
     * the inventory.
     * @return int
     */
    public int getMilk() {
        InventoryDB curDb = new InventoryDB();
        int check[] = curDb.checkInventory();
        return check[1];
        //return milk;
    }

    /**
     * Sets the number of milk units in the inventory
     * to the specified amount.
     * @param milk
     */
    public synchronized void setMilk(int milk) {
        if(milk >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(0,milk,0,0);
            //Inventory.milk = milk;
        }
    }

    /**
     * Add the number of milk units in the inventory
     * to the current amount of milk units.
     * @param milk
     * @throws InventoryException
     */
    public synchronized void addMilk(String milk) throws InventoryException {
        int amtMilk = 0;
        try {
            amtMilk = Integer.parseInt(milk);
        } catch (NumberFormatException e) {
            throw new InventoryException("Units of milk must be a positive integer");
        }
        if (amtMilk >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(0,amtMilk,0,0);
            //Inventory.milk += amtMilk;
        } else {
            throw new InventoryException("Units of milk must be a positive integer");
        }
    }

    /**
     * Returns the current number of sugar units in
     * the inventory.
     * @return int
     */
    public int getSugar() {
        InventoryDB curDb = new InventoryDB();
        int check[] = curDb.checkInventory();
        return check[2];
        //return sugar;
    }

    /**
     * Sets the number of sugar units in the inventory
     * to the specified amount.
     * @param sugar
     */
    public synchronized void setSugar(int sugar) {
        if(sugar >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(0,0,sugar,0);
            //Inventory.sugar = sugar;
        }
    }

    /**
     * Add the number of sugar units in the inventory
     * to the current amount of sugar units.
     * @param sugar
     * @throws InventoryException
     */
    public synchronized void addSugar(String sugar) throws InventoryException {
        int amtSugar = 0;
        try {
            amtSugar = Integer.parseInt(sugar);
        } catch (NumberFormatException e) {
            throw new InventoryException("Units of sugar must be a positive integer");
        }
        if (amtSugar >= 0) {
            InventoryDB curDb = new InventoryDB();
            curDb.addInventory(0,0,amtSugar,0);
            //Inventory.sugar += amtSugar;
        } else {
            throw new InventoryException("Units of sugar must be a positive integer");
        }
    }

    /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     * @param r
     * @return boolean
     */
    protected synchronized boolean enoughIngredients(Recipe r) {
        boolean isEnough = true;

        InventoryDB db = new InventoryDB();
        int ingredient[] = db.checkInventory();
        if(ingredient[0]< r.getAmtCoffee()) {
            isEnough = false;
        }
        if(ingredient[1] < r.getAmtMilk()) {
            isEnough = false;
        }
        if(ingredient[2] < r.getAmtSugar()) {
            isEnough = false;
        }
        if(ingredient[3] < r.getAmtChocolate()) {
            isEnough = false;
        }
        return isEnough;
    }

    /**
     * Removes the ingredients used to make the specified
     * recipe.  Assumes that the user has checked that there
     * are enough ingredients to make
     * @param r
     */
    public synchronized boolean useIngredients(Recipe r) {
        if (enoughIngredients(r)) {
            InventoryDB curDb = new InventoryDB();
            curDb.useInventory(-r.getAmtCoffee(), -r.getAmtMilk(), -r.getAmtSugar(), -r.getAmtChocolate());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string describing the current contents
     * of the inventory.
     * @return String
     */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Coffee: ");
        buf.append(getCoffee());
        buf.append("\n");
        buf.append("Milk: ");
        buf.append(getMilk());
        buf.append("\n");
        buf.append("Sugar: ");
        buf.append(getSugar());
        buf.append("\n");
        buf.append("Chocolate: ");
        buf.append(getChocolate());
        buf.append("\n");
        return buf.toString();
    }
}