package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BillItems")
public class S_BillItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	
	@Column(name="Item_Code")
	private String itemcode;
	
	@Column(name="Item_Name")
	private String itemname;
	
	
	@Column(name="Price")
	private int price;
	
	@Column(name="QTY")
	private int QTY;
	
	@Column(name="Amount")
	private int amount;
	
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="Invoice_Number", referencedColumnName = "invoicId", insertable = false, updatable = false)    
	private S_Invoice  s_InvoiceObj ;

	
	
	
	public S_BillItems(){
		
	}


	public S_BillItems(int billId, String itemcode, String itemname, int price, int qTY, int amount,
			S_Invoice s_InvoiceObj) {
		super();
		this.billId = billId;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.price = price;
		QTY = qTY;
		this.amount = amount;
		this.s_InvoiceObj = s_InvoiceObj;
	}


	public int getBillId() {
		return billId;
	}


	public void setBillId(int billId) {
		this.billId = billId;
	}


	public String getItemcode() {
		return itemcode;
	}


	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQTY() {
		return QTY;
	}


	public void setQTY(int qTY) {
		QTY = qTY;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public S_Invoice getS_InvoiceObj() {
		return s_InvoiceObj;
	}


	public void setS_InvoiceObj(S_Invoice s_InvoiceObj) {
		this.s_InvoiceObj = s_InvoiceObj;
	}

	
	
	
}
