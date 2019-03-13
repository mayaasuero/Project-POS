/**
 * @author Maya Asuero
 * @author Sheila Garduque
 * @author Sophia Japos
 */
import java.io.Serializable;
/**
 * This class implements a linked list which will store all data related to sold products.
 * <code>Products</code> sold upon <code>checkout()</code> will be sent here and be either added as a new node if no product
 * exists of the same attributes. However, when the product already exists in the list, only
 * the <code>quantity</code> of the product will be changed to add the number of new items sold.
 */
public class LinkedList implements java.io.Serializable{
	/**
	 * Points to the first element added to the list.
	 */
	public Node_Product head;
	/**
	 * Points to the most recently added element in the list.
	 */
	private Node_Product tail;
	
	/**
	 * Class constructor.
	 * Initializes all attributes to <code>null</code>, zero or empty.
	 */
	public void LinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * This method adds an object to the linked list by creating a node
	 * with the attributes of the product and a reference to the next node.
	 * <p>
	 * Attributes of the product will be the same as the item in the parameter.
	 * It will utilize the getter methods of the item and assigning it to the
	 * attributes of the product in the list. If the item already exists
	 * in the list, then the <code>quantity</code> of the product in the list will be added by
	 * the <code>quantity</code> of item purchased.
	 *
	 * @param	el		item to be added to the list
	 */
	public void add_To_List(Product el){
		//if list is empty
		if(this.head == null){
			Node_Product newNode = new Node_Product();
			
			String mod = el.getMod();
			float cost = el.getCost();
			int size = el.getSi();
			int quant = el.getAmount();
			String variant = el.getVar();
			int code = el.getCde();
			
			newNode.defineAttributes(mod, cost, size, quant, variant, code);
			newNode.reference = null;
			this.head = newNode;
			this.tail = newNode;
		}
		//if list is not empty
		else{
			Node_Product current = this.head;
			boolean found = false;
			
			//if item is already found in list; add to quant only
			while(current != this.tail.reference){
				if(el.getCde() == current.getCde()){
					current.add(el.getAmount());
					found = true;
					break;
				}
				current = current.reference;
			}
			//if list is not found in list; add new node to list
			
			if(!found){
				Node_Product newNode = new Node_Product();
				newNode.defineAttributes(el.getMod(), el.getCost(), el.getSi(), el.getAmount(), el.getVar(), el.getCde());
				newNode.reference = null;
				this.tail.reference = newNode;
				this.tail = newNode;
			}
		}
	}
	
	/**
	 * This method prints the contents of the list. It utilizes the getter methods
	 * of the product in the node as it traverses the list node by node.
	 */
	public void print_List(){
		if(this.head != null){
			System.out.printf("%-30s","Product Name");
			System.out.printf("%-10s","Code");
			System.out.printf("%-20s","Variant");
			System.out.printf("%-10s","Size");
			System.out.printf("%10s","Price");
			System.out.printf("%10s","Quantity");
			System.out.println();
			Node_Product current = this.head;
			while(current != this.tail.reference){
				System.out.printf("%-30s",current.getMod());
				System.out.printf("%-10d",current.getCde());
				System.out.printf("%-20s",current.getVar());
				System.out.printf("%-10d",current.getSi());
				System.out.printf("%10f",current.getCost());
				System.out.printf("%10d",current.getAmount());
				System.out.println();
				current = current.reference;
			}
		}
		else{
			System.out.println("Report is empty.");
		}
	}
	
	/**
	 * This method calculate the total sales of the items in the list multiplied by
	 * the quantity of items bought. To get the total, it will traverse the whole list
	 * and utilize the getter methods <code>getCost()</code> and <code>getAmount()</code>. 
	 *
	 * @return	float	return the total sales or revenue
	 */
	public float total_Sales(){
		Node_Product current = this.head;
		float total_Sales  = 0;
		if(this.tail != null){
			while(current != this.tail.reference){
				total_Sales = total_Sales + (current.getCost() * (float)current.getAmount());
				current = current.reference;
			}
		}
		return total_Sales;
	}
}
