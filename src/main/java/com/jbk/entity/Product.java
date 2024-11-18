package com.jbk.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int productId;
	private String productName;
	private int productQty;
	private double productPrice;
	private String mfgDate;
	private String expDate;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, int productQty, double productPrice, String mfgDate, String expDate) {
		super();
		this.productName = productName;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQty=" + productQty
				+ ", productPrice=" + productPrice + ", mfgDate=" + mfgDate + ", expDate=" + expDate + "]";
	}
	
	
}
