package order;

public class Pizza {
	private String meat;
	private String vegetable;
	private String cheese;
	private String crust;
	private String size;
	private String numOfPizza;
	private double price;
	
	public Pizza(String meat, String vegetable, String cheese,
	   String crust, String size, String numOfPizza) {
	this.meat = meat;
	this.vegetable = vegetable;
	this.cheese = cheese;
	this.crust = crust;
	this.size = size;
	this.numOfPizza = numOfPizza;
	}
	
	public String getMeat() {
		return this.meat;
	}
	public String getVegetable() {
		return this.vegetable;
	}
	public String getCheese() {
		return this.cheese;
	}
	public String getCrust() {
		return this.crust;
	}
	public String getSize() {
		return this.size;
	}
	public String getNumOfPizza() {
		return this.numOfPizza;
	}
	public double getPrice() {
		if (size.equals("Large")) {
			this.price = 15.99;
		}
		else if (size.equals("Medium")) {
			this.price = 8.99;
		}
		else {
			this.price = 4.99;
		}
		return this.price;
	}
}
