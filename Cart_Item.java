public class Cart_Item{
	private String name;
	private float price;
	private int size;
	private int quantity;
	private String color;
	private int code;
	
	public void Customer_Cart(){
		this.name = "";
		this.price = 0;
		this.size = 0;
		this.quantity = 0;
		this.color = "";
		this.code = 0;
	}
	
	public void set_Name(String el){
		this.name = el;
	}
	
	public String get_Name(){
		return.this.name;
	}
}