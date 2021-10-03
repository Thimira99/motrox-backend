package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class ND_Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "supplier")
	private String supplier;
	
	@Column(name = "item_code")
	private String itemCode;
	
	@Column(name = "Item_name")
	private String itemName;
	
	@Column(name = "Quantity")
	private String quantity;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "Total_price")
	private int totalPrice;
	
	public ND_Order() {
		
	}
	
	
	
	public ND_Order(String date, String supplier, String itemCode, String itemName, String quantity, int price,
			int totalPrice) {
		super();
		this.date = date;
		this.supplier = supplier;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
