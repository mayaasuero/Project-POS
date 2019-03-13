/**
 * @author Maya Asuero
 * @author Sheila Garduque
 * @author Sophia Japos
 */
import java.io.Serializable;
import java.util.Scanner;
/**
 * This class includes the different methods which the <code>main</code> method will call on
 * to conduct different transactions. An object of this type will be stored to a
 * text file and restored once user opens the program again.
 */
public class Another_POS implements java.io.Serializable{
	/**
	 * Stores products sold by the store as an array of objects limited only to fifty.
	 */
	private Product[] stocks = new Product[50];
	/**
	 * Stores customer purchased items used in a single transaction as an array of objects
	 * limited only to fifteen. 
	 */
	private Product[] cart = new Product[15];
	/**
	 * Pointer to the next empty index of <code>stocks[]</code>; also the current number on products in array.
	 */
	private int pointer_Stocks;
	/**
	 * Pointer to next empty <code>index</code> of <code>cart[]</code>; also the current number of items in array.
	 */
	private int pointer_Cart;
	/**
	 * Used as an all-around pointer in various methods.
	 */
	private int key;
	/**
	 * Lists all items sold in sales transaction.
	 */
	private LinkedList list = new LinkedList();
	
	/**
	 * Class constructor.
	 * Initializes all attributes to <code>null</code>, zero or empty.
	 */
	public void Another_POS(){
		this.pointer_Stocks = 0;
		this.pointer_Cart = 0;
		this.key = 0;
	}
	
	/**
	 * This allows users to choose between adding a new product to <code>stocks[]</code>
	 * or add <code>quantity</code> to already existing stocks. For the first addition of
	 * <code>stocks</code>, the method will automatically add a product instead of <code>quantity</code>.
	 * <p>
	 * During the addition of new stocks, the user will be required to input
	 * the different characteristics of the item. These characteristics will
	 * then be set as the attributes of the object product.
	 *
	 * @param	item		name of item to be added
	 */
	public void add_Item(String item){
		Scanner input = new Scanner(System.in);
		Scanner input_String = new Scanner(System.in);	
		String name = "";
		float price = 0;
		int size = 0;
		String variant = "";
		int code = 0;
		int quantity = 0;
		
		if(this.pointer_Stocks == 0){
			System.out.println("NEW PRODUCT");

			this.stocks[this.pointer_Stocks] = new Product();

			name = item;
			System.out.print("Variant: ");
			variant = input_String.nextLine();
			System.out.print("Size (number): ");
			size = input.nextInt();
			System.out.print("Cost: ");
			price = input.nextFloat();
			System.out.print("Quantity: ");
			quantity = input.nextInt();
			System.out.print("Code: ");
			code = input.nextInt();
			
			this.stocks[this.pointer_Stocks].new_Product(name, price, size, quantity, variant, code);
			this.pointer_Stocks++;
			System.out.println("Item successfully added.");
		}
		else{
			System.out.println("[0] Add more stocks.");
			System.out.println("[1] Add new product.");
			System.out.print("Select option: ");
			int choice = 0;
			choice = input.nextInt();
			
			switch (choice){
				case 0: 
					int i = 0;
					boolean found = false;
					while(i < this.pointer_Stocks){
						if((this.stocks[i].getMod()).equalsIgnoreCase(item)){
							System.out.print("["+i+"] ");
							System.out.printf("%-30s",this.stocks[i].getMod());
							System.out.printf("%-10d",this.stocks[i].getCde());
							System.out.printf("%-20s",this.stocks[i].getVar());
							System.out.printf("%-10d",this.stocks[i].getSi());
							System.out.printf("%10f",this.stocks[i].getCost());
							System.out.printf("%10d",this.stocks[i].getAmount());
							System.out.println();

							found = true;
						}
						i++;
					}
					System.out.println();
					
					if(found){
						System.out.println("ADD STOCKS");
						System.out.print("Enter number of selected item: ");
						int index = input.nextInt();
						System.out.print("Quantity to add: ");
						int quant = input.nextInt();
						this.stocks[index].add_Quantity(quant);
						
						System.out.println("Item successfully restocked.");

					}
					else{
						System.out.println("Cannot add new stocks. Item does not exist.");
					}
					break;
				case 1:
					if(this.pointer_Stocks < this.stocks.length){
						System.out.println("NEW PRODUCT");
						this.stocks[this.pointer_Stocks] = new Product();

						name = item;
						System.out.print("Variant: ");
						variant = input_String.nextLine();
						System.out.print("Size: ");
						size = input.nextInt();
						System.out.print("Cost: ");
						price = input.nextFloat();
						System.out.print("Quantity: ");
						quantity = input.nextInt();
						System.out.print("Code: ");
						code = input.nextInt();
						
						if(Search(code)){
							System.out.println("Item with this code already exist.");
						}
						else{
							this.stocks[this.pointer_Stocks].new_Product(name, price, size, quantity, variant, code);
							this.pointer_Stocks++;
							
							System.out.println("Item successfully added.");
						}
					}
					else{
						System.out.println("Storage is full. Cannot add another product.");
					}
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
		}
		System.out.println();
	}

	/**
	 * This deletes an item in <code>stocks[]</code>. The method will traverse the array while
	 * using a method <code>getMod()</code> which returns the name of the object in an <code>index</code>.
	 * The method will then match the names of the product the user wishes to
	 * delete and prints all matches. Finally, the user will have to select which
	 * of the items listed the user would want to delete.
	 * <p>
	 * If no items are found to match the name of the user-defined item, then the
	 * program will display an error message.
	 *
	 * @param  item		item to delete
	 */
	public void delete_Item(String item){
		Scanner input = new Scanner(System.in);
		int i = 0;
		boolean found = false;
		while(i < this.pointer_Stocks){
			if((stocks[i].getMod()).equalsIgnoreCase(item)){
				System.out.print("["+i+"]");
				System.out.printf("%-30s",this.stocks[i].getMod());
				System.out.printf("%-10d",this.stocks[i].getCde());
				System.out.printf("%-20s",this.stocks[i].getVar());
				System.out.printf("%-10d",this.stocks[i].getSi());
				System.out.printf("%10f",this.stocks[i].getCost());
				System.out.println();
				found = true;
			}
			i++;
		}
		if(found){
			System.out.print("Select item to delete: ");
			int el =0;
			Product temp;
			el = input.nextInt();
			this.stocks[el] = null;
			while(el < this.pointer_Stocks){
				temp = this.stocks[el];
				this.stocks[el] = this.stocks[el+1];
				this.stocks[el+1] = temp;
				el++;
			}
			this.pointer_Stocks--;
			System.out.println(item + " has been deleted.");
		}
		else{
			System.out.println("Item is not in the system.");
		}
	}
	
	/**
	 * This method replicate sales transactions. The method will accept a
	 * String item which will be used to search <code>stocks[]</code> with items matching
	 * the <code>String</code>. Matches will be printed and user has to choose which item
	 * will be part of the purchase. This item will then be added to <code>cart[]</code>.
	 * <p>
	 * The method will ask the user whether he/she would like to add more
	 * items in his/her cart. If they do, the program will recurse with a new
	 * user-defined product name. Otherwise, the program will call method 
	 * <code>checkout()</code>.
	 *
	 * @param  item	item to be bought
	 */
	public void Sales(String item){
		Scanner input = new Scanner(System.in);
		Scanner input_String = new Scanner(System.in);	
		System.out.println("SALES TRANSACTION");
		
		int i = 0;
		boolean found = false;
		while(i < this.pointer_Stocks){
			if(this.stocks[i].getMod().equalsIgnoreCase(item)){
				System.out.print("["+i+"] ");
				System.out.printf("%-30s",this.stocks[i].getMod());
				System.out.printf("%-10d",this.stocks[i].getCde());
				System.out.printf("%-20s",this.stocks[i].getVar());
				System.out.printf("%-10d",this.stocks[i].getSi());
				System.out.printf("%10f",this.stocks[i].getCost());
				System.out.printf("%10d",this.stocks[i].getAmount());
				System.out.println();

				found = true;
			}
			i++;
		}
		System.out.println();
		
		if(found){
			System.out.print("Enter number of selected item: ");
			int index = 0;
			String name = "";
			float price = 0;
			int size = 0;
			String variant = "";
			int code = 0;
			int quant = 0;
			
			index =input.nextInt();
		
			this.cart[this.pointer_Cart] = new Product();
			name= this.stocks[index].getMod();
			price = this.stocks[index].getCost();
			size = this.stocks[index].getSi();
			variant = this.stocks[index].getVar();
			code = this.stocks[index].getCde();

			System.out.print("Quantity: ");
			quant = input.nextInt();
			if(quant == 0){
				// nothing
			}
			else if(quant < this.stocks[index].getAmount() || quant == this.stocks[index].getAmount()){
				this.stocks[index].subt_Quantity(quant);
				this.cart[this.pointer_Cart].new_Product(name, price, size, quant, variant, code);
				this.pointer_Cart++;
				
				System.out.println("Product successfully added to cart.");
			}
			else{
				System.out.println("Not enough stocks");
			}	
		}
		
		else{
			System.out.println("Item is not in the system.");
		}
		
		System.out.println();

		String add_More = "";
		String yes = "Yes";
		String no = "No";
		
		while(!add_More.equalsIgnoreCase(yes) && !add_More.equalsIgnoreCase(no)){
			add_More = input.nextLine();
			
			if(add_More.equalsIgnoreCase(yes)){
				System.out.print("Name of Item: ");
				String prod = input.nextLine();
				Sales(prod);
			}
			else if(add_More.equalsIgnoreCase(no)) {
				checkout();
			}
			else{
				System.out.print("Add another item to cart? (Yes/No)");
			}
		}
	}
	
	/**
	 * This method prints the contents or attributes of <code>stocks[]</code> as the
	 * inventory of the system.
	 */
	public void Inventory(){
		int i = 0;
		if(this.pointer_Stocks > 0){
			System.out.printf("%-30s","Product Name");
			System.out.printf("%-10s","Code");
			System.out.printf("%-20s","Variant");
			System.out.printf("%-10s","Size");
			System.out.printf("%10s","Price");
			System.out.printf("%10s","Quantity");
			System.out.println();
			while(i < this.pointer_Stocks){
				System.out.printf("%-30s",this.stocks[i].getMod());
				System.out.printf("%-10d",this.stocks[i].getCde());
				System.out.printf("%-20s",this.stocks[i].getVar());
				System.out.printf("%-10d",this.stocks[i].getSi());
				System.out.printf("%10f",this.stocks[i].getCost());
				System.out.printf("%10d",this.stocks[i].getAmount());
				System.out.println();
				
				i++;
			}
		}
		else{
			System.out.println("No items in inventory.");
		}
		System.out.println();
	}
	
	/**
	 * This method prints the attributes of the content of <code>cart[]</code>.
	 */
	public void print_Cart(){
		int i = 0;
		System.out.printf("%-30s","Product Name");
		System.out.printf("%-10s","Code");
		System.out.printf("%-20s","Variant");
		System.out.printf("%-10s","Size");
		System.out.printf("%10s","Price");
		System.out.printf("%10s","Quantity");
		System.out.println();
		while(i < this.pointer_Cart){
			System.out.printf("%-30s",this.cart[i].getMod());
			System.out.printf("%-10d",this.cart[i].getCde());
			System.out.printf("%-20s",this.cart[i].getVar());
			System.out.printf("%-10d",this.cart[i].getSi());
			System.out.printf("%10f",this.cart[i].getCost());
			System.out.printf("%10d",this.cart[i].getAmount());
			System.out.println();
			i++;
		}
		System.out.println();
	}

	/**
	 * This method searches <code>stocks[]</code> with a user-defined item.
	 * It does so by the use of <code>getMod()</code> which returns the name/model of
	 * the <code>Product</code> object at a certain <code>index</code>. It will then match the 
	 * <code>String item</code> to the result of <code>getMod()</code>. All matches found will be printed.
	 *
	 * @param	item		item to be searched
	 * @return	boolean			returns whether a match is found or not
	 */
	public boolean Search(String item){
		int i = 0;
		boolean found = false;
		System.out.println();
		while(i < this.pointer_Stocks){
			if((this.stocks[i].getMod()).equalsIgnoreCase(item)){
				System.out.printf("%-30s",this.stocks[i].getMod());
				System.out.printf("%-10d",this.stocks[i].getCde());
				System.out.printf("%-20s",this.stocks[i].getVar());
				System.out.printf("%-10d",this.stocks[i].getSi());
				System.out.printf("%10f",this.stocks[i].getCost());
				System.out.printf("%10d",this.stocks[i].getAmount());
				System.out.println();
				found = true;
				this.key = i;
			}
			i++;
		}
		System.out.println();
		return found;
	}
	
	/**
	 * This method searches <code>stocks[]</code> with a user-defined code. It does so 
	 * by the use of <code>getCde()</code> which returns the code of the <code>Product</code> object 
	 * at a certain index. It will then match the int item to the result 
	 * of <code>getCde()</code>. It will then display is a match is found.
	 * <p>
	 * NOTE: ONLY ONE MATCH SHOULD BE POSSIBLE
	 *
	 * @param	code		code to be searched
	 * @return	boolean		returns whether a match is found or not
	 */
	public boolean Search(int code){
		int i = 0;
		boolean found = false;
		System.out.println();
		while(i < this.pointer_Stocks){
			if(this.stocks[i].getCde() == code){
				System.out.printf("%-30s",this.stocks[i].getMod());
				System.out.printf("%-10d",this.stocks[i].getCde());
				System.out.printf("%-20s",this.stocks[i].getVar());
				System.out.printf("%-10d",this.stocks[i].getSi());
				System.out.printf("%10f",this.stocks[i].getCost());
				System.out.printf("%10d",this.stocks[i].getAmount());
				System.out.println();
				found = true;
			}
			i++;
		}
		return found;
	}
	
	/**
	 * This method print the final result of the <code>Search()</code> - whether a match of
	 * the item or code being search is found.
	 *
	 * @param  result	determines whether there was match found
	 */
	public void print_Search_Result(boolean result){
		if(result){
			System.out.println("Item is found in the system.");
		}
		else{
			System.out.println("Item is not found in the system.");
		}
		this.key = 0;
	}
	
	/**
	 * This method considers items found in <code>cart[]</code> to be sold and is added to a
	 * linked list of sold items. Moreover, this will also calculate the total
	 * sales from the items bought through traversing the <code>cart[]</code>. Before moving
	 * to the next item in the cart, the element at the current <code>index</code> will be
	 * cleared or set to <code>null</code>.
	 * <p>
	 * This will print the final total of all items bought.
	 */
	public void checkout(){
		int i = 0;
		float total = 0;
		float item = 0;
		
		System.out.println("\nItems purchased:");
		print_Cart();
		send_To_List(this.cart);
		while(i < this.pointer_Cart){
			item = (float)this.cart[i].getAmount() * this.cart[i].getCost();
			total = total + item;
			this.cart[i] = null;
			i++;
		}
		this.pointer_Cart = 0;
		System.out.println("\nTotal checkout: " + total);		
	}
	
	/**
	 * This method adds each item in <code>cart[]</code> to a linked list.
	 *
	 * @param sold[]	equivalent to <code>cart[]</code>; 
	 *					items in this array will be added to the list.
	 */
	private void send_To_List(Product sold[]){		
		int i = 0;
		while(i < this.pointer_Cart){
			this.list.add_To_List(sold[i]);
			i++; 
		}
	}

	/**
	 * This prints the list of sold items and total sales by calling <code>print_List()</code>.
	 */
	public void Sales_Report(){
		this.list.print_List();
		System.out.println("Total Sales: "+this.list.total_Sales());
	}
}