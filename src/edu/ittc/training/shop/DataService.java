package edu.ittc.training.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.ittc.training.model.Item;
import edu.ittc.training.model.ItemDAO;
import edu.ittc.training.model.ItemDAOImpl;

public class DataService {
	private HashMap<String,Item> itemList = new HashMap<String,Item>();
	
	public DataService() {
		try {
			ItemDAO itemDB = new ItemDAOImpl();
			//itemDB.openConnection();
			
			List<Item> allitems = new ArrayList<Item>();
			allitems = itemDB.getAllItems();
			for (Item item : allitems) {
				itemList.put(item.getStockId(), new Item(item.getStockId(),item.getItemName(),item.getUnitPrice(),item.getOnStock()));
			}
			//itemDB.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Item retrieveItem(String id) {
		if(itemList.containsKey(id)) {
			Item item = (Item) itemList.get(id);
			return item;
		}
		return null;
	}

	public HashMap<String, Item> getList() {
		return itemList;
	}
	
	public ArrayList<Item> getAsList() {
		ArrayList<Item> items = new ArrayList<Item>();
		for(Item item: itemList.values()) {
			items.add(item);
		}
		return items;
	}
	
	
}
