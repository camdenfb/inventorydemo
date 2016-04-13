package edu.ittc.training.shop;

import java.util.ArrayList;

public class MyCart {
	private ArrayList<ItemPurchase> list = new ArrayList<ItemPurchase>();
	
	public MyCart() {}
	
	public void addToCart(ItemPurchase item) {
		list.add(item);
	}

	public ArrayList<ItemPurchase> getList() {
		return list;
	}

	public void setList(ArrayList<ItemPurchase> list) {
		this.list = list;
	}
	
	public void remove(ItemPurchase item){
		list.remove(item);
	}
}
