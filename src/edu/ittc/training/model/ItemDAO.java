package edu.ittc.training.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ittc.training.filters.User;
import edu.ittc.training.shop.ItemPurchase;
import edu.ittc.training.shop.Order;

public interface ItemDAO {
	public boolean saveItem(Item item) throws SQLException;
	public boolean addNewItem(Item item) throws SQLException;
	public boolean deleteItem(String id) throws SQLException;
	public Item findItemById(String id) throws SQLException;
	public ArrayList<Item> getAllItems() throws SQLException;
	public boolean addNewOrder(Order order) throws SQLException;
	public ArrayList<User> getAllUsers() throws SQLException;
}
