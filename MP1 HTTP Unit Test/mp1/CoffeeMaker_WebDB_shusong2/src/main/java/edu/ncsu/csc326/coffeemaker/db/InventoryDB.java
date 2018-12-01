
package edu.ncsu.csc326.coffeemaker.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

/**
 * The InventoryDB class contains the functions needed
 * dealing with inventory, including insert, edit, get
 * and clear
 */
public class InventoryDB {
	//same as insert

	/**
	 * Insert a new list of inventory to the table
	 * @param n_coffee 		amount of coffee to be added to the inventory
	 * @param n_milk 		amount of milk to be added to the inventory
	 * @param n_sugar 		amount of coffee to be added to the inventory
	 * @param n_chocolate	amount of sugar to be added to the inventory
	 * @return
	 */
	public static boolean addInventory(int n_coffee, int n_milk, int n_sugar, int n_chocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean inventoryAdded = false;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?)");
			stmt.setInt(1, n_coffee);
			stmt.setInt(2, n_milk);
			stmt.setInt(3, n_sugar);
			stmt.setInt(4, n_chocolate);
			int updated = stmt.executeUpdate();
			if (updated == 1) {
				inventoryAdded = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return inventoryAdded;
	}

	/**
	 * Edit the current inventory
	 * Removes the ingredients used to make the specified recipe
	 * @param n_coffee		amount of coffee to be used from the inventory
	 * @param n_milk		amount of milk to be used from the inventory
	 * @param n_sugar		amount of sugar to be used from the inventory
	 * @param n_chocolate	amount of chocolate to be used from the inventory
	 * @return
	 */
	public static boolean useInventory(int n_coffee, int n_milk, int n_sugar, int n_chocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean inventoryChecked = false;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?)");
			stmt.setInt(1, n_coffee);
			stmt.setInt(2, n_milk);
			stmt.setInt(3, n_sugar);
			stmt.setInt(4, n_chocolate);
			int updated = stmt.executeUpdate();
			if (updated == 1) {
				inventoryChecked = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return inventoryChecked;
	}

	/**
	 * Get the current inventory parameters
	 * @return int[]
	 * @param0 coffee
	 * @param1 milk
	 * @param sugar
	 * @param chocolate
	 */
	public static int[] checkInventory() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		int answer[] = new int[4];
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT sum(coffee) AS sum_coffee,"+
					"sum(milk) AS sum_milk,"+
					"sum(sugar) AS sum_sugar,"+
					"sum(chocolate) AS sum_chocolate"+
					" FROM inventory");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				answer[0] = rs.getInt("sum_coffee");
				answer[1] = rs.getInt("sum_milk");
				answer[2] = rs.getInt("sum_sugar");
				answer[3] = rs.getInt("sum_chocolate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}

		return answer;
	}

	/**
	 * Clear the current Inventory database
	 */
	public static void clearInventory() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("TRUNCATE TABLE inventory");
			int update = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
	}

}