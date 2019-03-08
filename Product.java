import java.io.*;
public class Product implements java.io.Serializable{
	private float price;
	private int size;
	private int quantity;
	private String color;
	private int code;
	private String name;
	
	/**Constructor method
	  *@params: n/a
	  *@return: void
	*/
	public void Product(){
		this.price = 0;
		this.size = 0;
		this.quantity = 0;
		this.color = "";
		this.code = 0;
		this.name = "";
	}
	
	/**new_Prouct method: defines attributes of object
	  *@params: String mod, float cost, int si, int qty, String col, int cde
	  *@return: void
	*/
	public void new_Product(String mod, float cost, int si, int qty, String col, int cde){
		this.name = mod;
		this.price = cost;
		this.size = si;
		this.quantity = qty;
		this.code = cde;
		this.color = col;
	}
	
	/**getMod method: returns name of product
	  *@params: n/a
	  *@return: String
	*/
	public String getMod() {
		return this.name;
	}
	
	/**getCost method: returns cost of product
	  *@params: n/a
	  *@return: float
	*/
	public float getCost() {
		return this.price;
	}
	
	/**getSi method: returns size of product
	  *@params: n/a
	  *@return: int
	*/
	public int getSi() {
		return this.size;
	}
	
	/**getAmount method: returns quantity of product
	  *@params: n/a
	  *@return: int
	*/
	public int getAmount() {
		return this.quantity;
	}
	
	/**getCol method: returns color of product
	  *@params: n/a
	  *@return: String
	*/
	public String getCol() {
		return this.color;
	}
	
	/**getCde method: returns code of product
	  *@params: n/a
	  *@return: int
	*/
	public int getCde() {
		return this.code;
	}

	/**add_Quantity method: adds to the current quantity of object
	  *@params: int quant
	  *@return: void
	*/
	public void add_Quantity(int quant){
		this.quantity = this.quantity + quant;
	}
	
	/**subt_Quantity method: subtract to current quantity of object
	  *@params: int quant
	  *@return: void
	*/
	public void subt_Quantity(int purchase){
		this.quantity = this.quantity - purchase;
	}
}