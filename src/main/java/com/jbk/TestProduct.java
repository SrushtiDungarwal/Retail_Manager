package com.jbk;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.jbk.entity.Product;
import com.jbk.operation.Operation;
import com.jbk.utility.UserData;


public class TestProduct {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;
		Operation operation = new Operation();
		boolean wantToContinue = true;
		do {
			System.out.println("1. Add Product.");
			System.out.println("2. Delete Product by Id.");
			System.out.println("3. Get Product by Id.");
			System.out.println("4. Update Product.");
			System.out.println("5. Get all Product.");
			System.out.println("6. Get all Product Ordered by Name.");
			System.out.println("7. Get limited Product.");
			System.out.println("8. Get Product by name.");
			System.out.println("9. Get all Products above given price.");
			System.out.println("10. Get Product count.");		
			System.out.println("11. Get Product by Query1.");		
			System.out.println("12. Get Product by Query2.");		
			System.out.println("13. Get Product by Query3.");		
			System.out.println("14. Get Product names without using query.");		
			System.out.println("Press 0 to exit.");
			System.out.println("Enter you choice:");
			choice = sc.nextInt();
			
			switch (choice) {
			
			case 0:
				wantToContinue = false;
				break;
			case 1:{
				Product product = UserData.getUserData();
				String msg = operation.addProduct(product);
				System.out.println(msg);
				break;
			}
			case 2:{
				System.out.println("Enter product Id");
				int id = sc.nextInt();
				String msg = operation.deleteProduct(id);
				System.out.println(msg);
				break;
			}
			case 3:{
				System.out.println("Enter product Id");
				int id = sc.nextInt();
				Object msg = operation.getProductById(id);
				System.err.println(msg);
				break;
			}
			case 4:{
				System.out.println("Enter Product Id");
				int id = sc.nextInt();
				Product product = UserData.getUserData();
				product.setProductId(id);
				String msg = operation.updateProduct(product);
				System.out.println(msg);
				break;
			}
			case 5:{
				List<Product> list = operation.getAllProducts(); 
				if(!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 6:{
				List<Product> list = operation.getAllProductsByOrder(); 
				if(!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 7:{
				List<Product> list = operation.getLimitedProduct(); 
				if(!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 8:{
				System.out.print("Enter product name: ");
				String name = sc.next();
				List<Product> list = operation.getProductByName(name); 
				if(!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 9:{
				System.out.print("Enter product price: ");
				double price = sc.nextDouble();
				List<Product> list = operation.getProductByHigherPrice(price); 
				if(!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 10:{
				System.out.println("Total Products: " + operation.getProductCount());
				break;
			}
			case 11:{
				
				List<Product> list = operation.queryEx1(); 
				if(!list.isEmpty()) {
					list.forEach(s -> System.out.println(s));
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 12:{
				
				List<Object[]> list = operation.queryEx2(); 
				if(!list.isEmpty()) {
					for (Object[] obj : list) {
						System.out.println(Arrays.toString(obj));
					}
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 13:{
				
				List<Product> list = operation.queryEx3(); 
				if(!list.isEmpty()) {
					list.forEach(s -> System.out.println(s));
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			case 14:{
				
				List<String> list = operation.withoutQueryEx1(); 
				if(!list.isEmpty()) {
					for (String obj : list) {
						System.out.println(obj);
					}
				}else {
					System.out.println("No records found!!");
				}
				break;
			}
			
		default:
			System.out.println("Invalid choice");
			break;
		}
			
		} while (wantToContinue);
		System.out.println("App terminating..");
		
		sc.close();
	}

}
