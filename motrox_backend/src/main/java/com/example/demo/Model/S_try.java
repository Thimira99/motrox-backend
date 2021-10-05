package com.example.demo.Model;

import java.util.List;

public class S_try {
	private String itemcode2;
	private String itemname2;
	private int price2;
	private int QTY2;
	private int amount2;
	private String invoiceNumber2;
	private String Date2;
	private int totalAmount2;
	

	
	public S_try(String itemcode2, String itemname2, int price2, int qTY2, int amount2, String invoiceNumber2,
			String date2, int totalAmount2) {
		super();
		this.itemcode2 = itemcode2;
		this.itemname2 = itemname2;
		this.price2 = price2;
		QTY2 = qTY2;
		this.amount2 = amount2;
		this.invoiceNumber2 = invoiceNumber2;
		Date2 = date2;
		this.totalAmount2 = totalAmount2;
	}


	public String getItemcode2() {
		return itemcode2;
	}


	public void setItemcode2(String itemcode2) {
		this.itemcode2 = itemcode2;
	}


	public String getItemname2() {
		return itemname2;
	}


	public void setItemname2(String itemname2) {
		this.itemname2 = itemname2;
	}


	public int getPrice2() {
		return price2;
	}


	public void setPrice2(int price2) {
		this.price2 = price2;
	}


	public int getQTY2() {
		return QTY2;
	}


	public void setQTY2(int qTY2) {
		QTY2 = qTY2;
	}


	public int getAmount2() {
		return amount2;
	}


	public void setAmount2(int amount2) {
		this.amount2 = amount2;
	}


	public String getInvoiceNumber2() {
		return invoiceNumber2;
	}


	public void setInvoiceNumber2(String invoiceNumber2) {
		this.invoiceNumber2 = invoiceNumber2;
	}


	public String getDate2() {
		return Date2;
	}


	public void setDate2(String date2) {
		Date2 = date2;
	}


	public int getTotalAmount2() {
		return totalAmount2;
	}


	public void setTotalAmount2(int totalAmount2) {
		this.totalAmount2 = totalAmount2;
	}
	
	
	
}
