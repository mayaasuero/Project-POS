import java.io.*;
public class Node_Product implements java.io.Serializable{
	public Node_Product reference;
	private String item;
	private float price;
	private int size;
	private int quantity;
	private String color;
	private int code;
	
	/**Constructor method
	  *@params: n/a
	  *@return: void
	*/
	public void Node_Product(){
		this.reference = null;
		this.item = "";
		this.size = 0;
		this.price = 0;
		this.quantity = 0;
		this.code = 0;
		this.color = "";
	}
	
	/**defineAttributes method: defines attributes of object
	  *@params: String mod, float cost, int si, int qty, String col, int cde
	  *@return: void
	*/
	public void defineAttributes(String mod, float cost, int si, int qty, String col, int cde){
		this.item = mod;
		this.price = cost;
		this.size = si;
		this.quantity = qty;
		this.code = cde;
		this.color = col;
		this.reference = null;
	}
	
	/**getMod method: returns name of product
	  *@params: n/a
	  *@return: String
	*/
	public String getMod() {
		return this.item;
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