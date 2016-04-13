package edu.ittc.training.shop;

import edu.ittc.training.model.Item;

public class ItemPurchase {
	private String itemId;
	private String itemName;
	private double unitPrice;
	private int noItems;
	
	public ItemPurchase() {
		
	}
	
	public ItemPurchase(Item item, int qnty) {
		itemId = item.getStockId();
		itemName = item.getItemName();
		unitPrice = item.getUnitPrice();
		noItems = qnty;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getNoItems() {
		return noItems;
	}

	public void setNoItems(int noItems) {
		this.noItems = noItems;
	}
	
	
	
}
