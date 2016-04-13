package edu.ittc.training.model;

public class Item {
	private String stockId;
	private String itemName;
	private double unitPrice;
	private int onStock;
	
	public Item() {}
	
	public Item(String stockId, String itemName, double unitPrice, int onStock) {
		super();
		this.stockId = stockId;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.onStock = onStock;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
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
	public int getOnStock() {
		return onStock;
	}
	public void setOnStock(int onStock) {
		this.onStock = onStock;
	}
}
