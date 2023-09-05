package com.shopping.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="purchase")
public class Purchase 
{
	private int purcahseId;
	private String username;
	private int amount;
	private Date purchaseDate;
	private String items;
	public int getPurcahseId() {
		return purcahseId;
	}
	public void setPurcahseId(int purcahseId) {
		this.purcahseId = purcahseId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getItems() {
		return items;
	}
	@Override
	public String toString() {
		return "Purchase [purcahseId=" + purcahseId + ", username=" + username + ", amount=" + amount
				+ ", purchaseDate=" + purchaseDate + ", items=" + items + "]";
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase(int purcahseId, String username, int amount, Date purchaseDate, String items) {
		super();
		this.purcahseId = purcahseId;
		this.username = username;
		this.amount = amount;
		this.purchaseDate = purchaseDate;
		this.items = items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	
	
		
	

}
