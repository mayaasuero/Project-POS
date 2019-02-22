public class Product{
	public float price;
	public int size;
	public int quantity;
	public String color;
	public int code;
	public String name;
	
	public void Product(){
		this.price = 0;
		this.size = 0;
		this.quantity = 0;
		this.color = "";
		this.code = 0;
		this.name = "";
	}
	
	public void Product(String mod, float cost, int si, int amount){
		this.price = cost;
		this.name = mod;
		this.size = si;
		this.quantity = amount;
	}
	
	public void add_Quantity(int quant){
		this.quantity = this.quantity + quant;
	}
	
	public void subt_Quantity(int purchase){
		this.quantity = this.quantity - purchase;
	}
	
	//price gettter method
	//size getter method
	//quantity getter mod
	//color getter method
	//code getter method
	//nam getter method
}