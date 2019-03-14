/**
 * @author Maya Asuero
 * @author Sheila Garduque
 * @author Sophia Japos
 */
import java.io.Serializable;
/**
 * This class will hold the information needed when creating objects of type <code>Product</code>
 * for the arrays of class <code>Another_POS</code>. It also has getter methods to access <code>private</code> 
 * variables in the program.
 */
public class Product implements java.io.Serializable{
	/**
	 * Stores the <code>price</code> of item.
	 */
	private float price;
	/**
	 * Stores the <code>size</code> of item.
	 */
	private int size;
	/**
	 * Stores the <code>quantity</code> of item.
	 */
	private int quantity;
	/**
	 * Stores the <code>color</code> of item.
	 */
	private String variant;
	/**
	 * Stores the <code>code</code> of item.
	 */
	private int code;
	/**
	 * Stores the <code>name</code> of item.
	 */
	private String name;
	
	/**
	 * Class constructor.
	 * Initializes all attributes to <code>null</code>, zero or empty.
	 */
	public void Product(){
		this.price = 0;
		this.size = 0;
		this.quantity = 0;
		this.variant = "";
		this.code = 0;
		this.name = "";
	}
	
	/**
	 * This method assigns the variables passed through the parameters to its respective
	 * attribute.
	 *
	 * @param	mod			name of product
	 * @param	cost		price of product
	 * @param	si			size of product
	 * @param	qty			quantity of product
	 * @param	var			color of product
	 * @param	cde			code of product
	 */
	public void new_Product(String mod, float cost, int si, int qty, String var, int cde){
		this.name = mod;
		this.price = cost;
		this.size = si;
		this.quantity = qty;
		this.code = cde;
		this.variant = var;
	}
	
	/**
	 * This method adds a certain number to the current <code>quantity</code> of the product.
	 *
	 * @param	quant	number to be added to the product
	 */
	public void add_Quantity(int quant){
		this.quantity = this.quantity + quant;
	}
	
	/**
	 * This method subtract a certain number from the current <code>quantity</code> of the product.
	 *
	 * @param	purchase	number to be subtracted from the product
	 */
	public void subt_Quantity(int purchase){
		this.quantity = this.quantity - purchase;
	}
	
	/**
	 * This method returns the <code>name</code> of the product.
	 *
	 * @return: String		name of item
	 */
	public String getMod() {
		return this.name;
	}
	
	/**
	 * This method returns the <code>price</code> of the product.
	 *
	 * @return: float		price of item
	 */
	public float getCost() {
		return this.price;
	}
	
	/**
	 * This method returns the <code>size</code> of the product.
	 *
	 * @return: int		size of item
	 */
	public int getSi() {
		return this.size;
	}
	
	
	/**
	 * This method returns the <code>quantity</code> of the product.
	 *
	 * @return: int 	quantity of item
	 */
	public int getAmount() {
		return this.quantity;
	}
	
	/**
	 * This method returns the <code>color</code> of the product.
	 *
	 * @return: String	color of item
	 */
	public String getVar() {
		return this.variant;
	}
	
	/**
	 * This method returns the <code>code</code> of the product.
	 *
	 * @return: int		code of item
	*/
	public int getCde() {
		return this.code;
	}
}
