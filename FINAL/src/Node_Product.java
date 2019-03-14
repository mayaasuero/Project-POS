/**
 * @author Maya Asuero
 * @author Sheila Garduque
 * @author Sophia Japos
 */
import java.io.Serializable;
/**
 * This class holds the information used for the node in the linked list.
 */
public class Node_Product implements java.io.Serializable{
	/**
	 * Stores the <code>reference</code> to the next node.
	 */
	public Node_Product reference;
	/**
	 * Stores the attributes and methods of the product.
	 */
	public Product item;
	
	
	/**
	 * Class constructor.
	 * Initializes all attributes to <code>null</code>, zero or empty.
	 */
	public void Node_Product(){
		this.reference = null;
	}
	
	/**
	 * This method assigns the variables passed through the parameters to its respective
	 * attribute.
	 * 
	 * @param	mod		name of product
	 * @param	cost	price of prouct
	 * @param	si		size of product
	 * @param	qty		quantity of product
	 * @param	col		color of product
	 * @param	cde		code of product
	 */
	public void defineAttributes(String mod, float cost, int si, int qty, String col, int cde){
		this.item = new Product();
		this.item.new_Product(mod, cost, si, qty, col, cde);
		this.reference = null;
	}
	
	/**
	 * This method adds a certain number to the current <code>quantity</code> of the product.
	 *
	 * @param	quant	number to be added to the product
	 */
	public void add(int quant){
		this.item.add_Quantity(quant);
	}
	
	/**
	 * This method subtract a certain number from the current <code>quantity</code> of the product.
	 *
	 * @param	purchase	number to be subtracted from the product
	 */
	public void subtract(int purchase){
		this.item.subt_Quantity(purchase);
	}
	
	/**
	 * This method returns the <code>name</code> of the product.
	 *
	 * @return: String		name of item
	 */
	public String getMod() {
		return this.item.getMod();
	}
	
	/**
	 * This method returns the <code>price</code> of the product.
	 *
	 * @return: float		price of item
	 */
	public float getCost() {
		return this.item.getCost();
	}
	
	/**
	 * This method returns the <code>size</code> of the product.
	 *
	 * @return: int		size of item
	 */
	public int getSi() {
		return this.item.getSi();
	}
	
	
	/**
	 * This method returns the <code>quantity</code> of the product.
	 *
	 * @return: int 	quantity of item
	 */
	public int getAmount() {
		return this.item.getAmount();
	}
	
	/**
	 * This method returns the <code>color</code> of the product.
	 *
	 * @return: String	color of item
	 */
	public String getVar() {
		return this.item.getVar();
	}
	
	/**
	 * This method returns the <code>code</code> of the product.
	 *
	 * @return: int		code of item
	*/
	public int getCde() {
		return this.item.getCde();
	}
}