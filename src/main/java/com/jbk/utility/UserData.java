package com.jbk.utility;

import java.util.Scanner;

import com.jbk.entity.Product;

public class UserData {

	public static Product getUserData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Name");
		String name = sc.next();
		
		System.out.println("Enter Product quantity");
		int qty = sc.nextInt();
		
		System.out.println("Enter Product Price");
		double price = sc.nextDouble();
		
		System.out.println("Enter Product manufacturing date");
		String mfgDate = sc.next();
		
		System.out.println("Enter Product expiry date");
		String expDate = sc.next();

		
		Product product = new Product(name, qty, price, mfgDate, expDate);
		
		return product;
	}
}
