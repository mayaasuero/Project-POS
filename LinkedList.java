//for final project nga linked list; more of a stack type nga LL
import java.io.*;
public class LinkedList implements java.io.Serializable{
	public Node_Product head;
	private Node_Product tail;
	
	/**Constructor method
	  *@params: n/a
	  *@return: void
	*/
	public void LinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	/**add_To_List method: adds an object to the linked list by creating
		a node (and sorts character into list)
	  *@params: Product el
	  *@return: void
	*/
	public void add_To_List(Product el){
		//if list is empty
		if(this.head == null){
			Node_Product newNode = new Node_Product();
			
			String mod = el.getMod();
			float cost = el.getCost();
			int size = el.getSi();
			int quant = el.getAmount();
			String color = el.getCol();
			int code = el.getCde();
			
			newNode.defineAttributes(mod, cost, size, quant, color, code);
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
					current.add_Quantity(el.getAmount());
					found = true;
					break;
				}
				current = current.reference;
			}
			//if list is not found in list; add new node to list
			
			if(!found){
				Node_Product newNode = new Node_Product();
				newNode.defineAttributes(el.getMod(), el.getCost(), el.getSi(), el.getAmount(), el.getCol(), el.getCde());
				newNode.reference = null;
				this.tail.reference = newNode;
				this.tail = newNode;
			}
		}
	}
	
	/**print_List method: print contents of list
	  *@params: n/a
	  *@return: void
	*/
	public void print_List(){
		if(this.head != null){
			System.out.println("\nFormat: Product Name, Price, Size, Color, Quantity, Product Code.");
			Node_Product current = this.head;
			while(current != this.tail.reference){
				System.out.println(current.getMod() + ", " + current.getCost() +", " + current.getSi() + ", " + current.getCol() + ", " + current.getAmount() + ", " + current.getCde());
				current = current.reference;
			}
		}
		else{
			System.out.println("Report is empty.");
		}
	}
	
	/**total_Sales method: calculates total sales by traversing list
	  *@params: n/a
	  *@return: float
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