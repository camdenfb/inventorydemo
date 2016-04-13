package edu.ittc.training.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ittc.training.filters.User;
import edu.ittc.training.shop.ItemPurchase;
import edu.ittc.training.shop.Order;
import edu.ittc.training.testdb.Connect;
import edu.ittc.training.testdb.DBUtil;

public class ItemDAOImpl implements ItemDAO {
	
	public ItemDAOImpl() {
		
	}
	
	@Override
	public ArrayList<User> getAllUsers() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * from users";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<User> allusers = new ArrayList<User>();
		while(rs.next()){
			allusers.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
		}
		DBUtil.closeConnection(conn);
		return allusers;
	}
	
	@Override
	public boolean saveItem(Item item) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE items SET itemName = ?, unitPrice = ?, onStock = ?" +
					" WHERE stockId = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, item.getItemName());
		stmt.setDouble(2, item.getUnitPrice());
		stmt.setInt(3, item.getOnStock());
		stmt.setString(4, item.getStockId());
		
		stmt.execute();
		DBUtil.closeConnection(conn);
		return true;
	}

	@Override
	public boolean addNewItem(Item item) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO items VALUES (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, item.getStockId());
		stmt.setString(2, item.getItemName());
		stmt.setDouble(3, item.getUnitPrice());
		stmt.setInt(4, item.getOnStock());
		
		stmt.execute();
		DBUtil.closeConnection(conn);
		return true;
	}

	@Override
	public boolean addNewOrder(Order order) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO orders VALUES (null,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, order.getUserId());
		stmt.setString(2, order.getItemId());
		stmt.setInt(3, order.getQuantity());
		stmt.setDouble(4, order.getPrice());
		stmt.execute();
		DBUtil.closeConnection(conn);
		return true;
	}
	
	@Override
	public Item findItemById(String id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT stockId, itemName, unitPrice," +
				" onStock FROM items WHERE stockId = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		Item item = null;
		
		if(rs.first()){
			//String stockId = rs.getString("stockId");
			String itemName = rs.getString("itemName");
			double unitPrice = rs.getDouble("unitPrice");	
			int onStock = rs.getInt("onStock");
			item = new Item(id,itemName,unitPrice,onStock);	
		}
		
		DBUtil.closeConnection(conn);
		return item;
	}

	@Override
	public ArrayList<Item> getAllItems() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * from items";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Item> allitems = new ArrayList<Item>();
		while(rs.next()){
			allitems.add(new Item(rs.getString("stockId"), rs.getString("itemName"), rs.getDouble("unitPrice"), rs.getInt("onStock")));
		}
		DBUtil.closeConnection(conn);
		return allitems;
	}

	@Override
	public boolean deleteItem(String id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM items " +
				"WHERE stockId = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.execute();
		DBUtil.closeConnection(conn);
		return true;
	}

}
