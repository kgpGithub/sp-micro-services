package org.ssl.examples.customer.dto;

public class Customer {
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	private int id=0;
	 private String name = "";
	 	
		
	 public Customer(final int id,final String name) {
		 this.id=id;
		 this.name=name;
	 }

} 
