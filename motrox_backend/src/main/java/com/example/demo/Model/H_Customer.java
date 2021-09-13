package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")

public class H_Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerid;
	
	@Column(name = "first_Name")
	private String firstName;
	
	@Column(name = "last_Name")
	private String lastName;
	
	@Column(name = "nic")
	private String nic;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_no")
	private int phoneNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "vehicle_reno")
	private String vehicleRegNo;
	
	public H_Customer() {
		
	}
	
	public H_Customer(String firstName, String lastName, String nic, String address, int phoneNo, String email,
			String vehicleRegNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.vehicleRegNo = vehicleRegNo;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
}
