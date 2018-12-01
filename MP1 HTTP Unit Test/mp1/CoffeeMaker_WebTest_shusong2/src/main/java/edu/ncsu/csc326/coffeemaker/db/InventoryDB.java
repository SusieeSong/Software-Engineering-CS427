
package edu.ncsu.csc326.coffeemaker.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class InventoryDB {
	//same as insert
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

	//same as edit
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

	//same as get
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