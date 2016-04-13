package edu.ittc.training.shop;

public class Order {
	private String userId;
	private String itemId;
	private int quantity;
	private double price;
	
	public Order() {
		
	}

	public Order(String userId, String itemId, int quantity, double price) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}

