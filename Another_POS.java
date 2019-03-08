import java.io.*;
import java.util.Scanner;
public class Another_POS implements java.io.Serializable{
	private Product[] stocks = new Product[50]; //store stocks of store
	private Product[] cart = new Product[15]; //store items to buy
	private int pointer_Stocks; //points to next empty in stocks
	private int pointer_Cart; //points to next empty in cart
	private int key;
	private LinkedList list = new LinkedList();
	
	/**Constructor method
	  *@params: n/a
	  *@return: void
	*/
	public void Another_POS(){
		this.pointer_Stocks = 0;
		this.pointer_Cart = 0;
		this.key = 0;
	}
	
	
	/**add_Item method: adds either a new product or adds stock to items in inventory
	  *@params: String item
	  *@return: void
	*/
	public void add_Item(String item){
		Scanner input = new Scanner(System.in);
		Scanner input_String = new Scanner(System.in);	
		String name = "";
		float price = 0;
		int size = 0;
		String color = "";
		int code = 0;
		int quantity = 0;
		
		if(this.pointer_Stocks == 0){
			System.out.println("NEW PRODUCT");

			this.stocks[this.pointer_Stocks] = new Product();

			name = item;
			System.out.print("Color: ");
			color = input_String.nextLine();
			System.out.print("Size (number): ");
			size = input.nextInt();
			System.out.print("Cost: ");
			price = input.nextFloat();
			System.out.print("Quantity: ");
			quantity = input.nextInt();
			System.out.print("Code: ");
			code = input.nextInt();
			
			this.stocks[this.pointer_Stocks].new_Product(name, price, size, quantity, color, code);
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
							System.out.println("["+i+"] " + this.stocks[i].getMod() + ", " + this.stocks[i].getCol() + ", " + this.stocks[i].getSi() + ", " + this.stocks[i].getCost());
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
						System.out.print("Color: ");
						color = input_String.nextLine();
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
							this.stocks[this.pointer_Stocks].new_Product(name, price, size, quantity, color, code);
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

	/**delete_Item method: deletes an item in stocks[]
	  *@params: String item
	  *@return: void
	*/
	public void delete_Item(String item){
		Scanner input = new Scanner(System.in);
		int i = 0;
		boolean found = false;
		while(i < this.pointer_Stocks){
			if((stocks[i].getMod()).equalsIgnoreCase(item)){
				System.out.println("["+i+"] " + this.stocks[i].getMod() + ", " + this.stocks[i].getCol() + ", " + this.stocks[i].getSi() + ", " + this.stocks[i].getCost());
			}
			i++;
		}
		
		System.out.print("Select item to delete: ");
		int el =0;
		el = input.nextInt();
		
		while(el < pointer_Stocks){
			this.stocks[el] = this.stocks[el+1];
			el++;
		}
		
		this.pointer_Stocks--;
		System.out.println(item + " has been deleted.");
	}
	
	/**Sales Method: conducts sales transtaction 
	  *@params: String item
	  *@return: void
	*/
	public void Sales(String item){
		Scanner input = new Scanner(System.in);
		Scanner input_String = new Scanner(System.in);	
		System.out.println("SALES TRANSACTION");
		
		int i = 0;
		boolean found = false;
		while(i < this.pointer_Stocks){
			if(this.stocks[i].getMod().equalsIgnoreCase(item)){
				System.out.println("["+i+"] " + this.stocks[i].getMod() + ", " + this.stocks[i].getCol() + ", " + this.stocks[i].getSi() + ", " + this.stocks[i].getCost());
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
			String color = "";
			int code = 0;
			int quant = 0;
			
			index =input.nextInt();
		
			this.cart[this.pointer_Cart] = new Product();
			name= this.stocks[index].getMod();
			price = this.stocks[index].getCost();
			size = this.stocks[index].getSi();
			color = this.stocks[index].getCol();
			code = this.stocks[index].getCde();

			System.out.print("Quantity: ");
			quant = input.nextInt();
			if(quant == 0){
				// nothing
			}
			else if(quant < this.stocks[index].getAmount() || quant == this.stocks[index].getAmount()){
				this.stocks[index].subt_Quantity(quant);
				this.cart[this.pointer_Cart].new_Product(name, price, size, quant, color, code);
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
	
	/**Inventory method: prints contents of stock[]
	  *@params: n/a
	  *@return: void
	*/
	public void Inventory(){
		int i = 0;
		if(this.pointer_Stocks > 0){
			System.out.println("\nINVENTORY\nFormat: Product Name, Product Code, Color, Size, Cost, No. of products.");
			while(i < this.pointer_Stocks){
				System.out.println(this.stocks[i].getMod() + ", " + this.stocks[i].getCde() + ", " + this.stocks[i].getCol() + ", " + this.stocks[i].getSi() + ", " + this.stocks[i].getCost() + ", " + this.stocks[i].getAmount());
				i++;
			}
		}
		else{
			System.out.println("No items in inventory.");
		}
		System.out.println();
	}
	
	/**print_Cart method: print contents of cart[]
	  *@params: n/a
	  *@return: void
	*/
	public void print_Cart(){
		int i = 0;
		System.out.println("\nCART\nFormat: Product Name, Quantity, Color, Size, Cost, Product Code.");
		while(i < this.pointer_Cart){
			System.out.print(this.cart[i].getMod() + ", " + this.cart[i].getCde() + ", " + this.cart[i].getCol() + ", " + this.cart[i].getSi() + ", " + this.cart[i].getCost() + ", " + this.cart[i].getAmount());
			System.out.println();
			i++;
		}
		System.out.println();
	}

	/**Search method: searches stocks with user-defined product name
	  *@params: String item
	  *@return: boolean - returns whether item is found or not
	*/
	public boolean Search(String item){
		int i = 0;
		boolean found = false;
		System.out.println();
		while(i < this.pointer_Stocks){
			if((this.stocks[i].getMod()).equalsIgnoreCase(item)){
				System.out.println("["+i+"] " + this.stocks[i].getMod() + ", " + this.stocks[i].getCol() + ", " + this.stocks[i].getSi() + ", " + this.stocks[i].getCost());
				found = true;
				this.key = i;
			}
			i++;
		}
		System.out.println();
		return found;
	}
	
	/**Search method: searches stocks with user-defined product code
	  *@params: int code
	  *@return: boolean - returns whether item is found or not
	*/
	public boolean Search(int code){
		int i = 0;
		boolean found = false;
		while(i < this.pointer_Stocks){
			if(this.stocks[i].getCde() == code){
				System.out.println("["+i+"] " + this.stocks[i].getMod() + ", " + this.stocks[i].getCol() + ", " + this.stocks[i].getSi() + ", " + this.stocks[i].getCost() + ", " + this.stocks[i].getCde());
				found = true;
			}
			i++;
		}
		return found;
	}
	
	/**print_Search_Result method: prints status of search method if necessary
	  *@params: boolean result
	  *@return: void
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
	
	/**checkout method: sends items in cart to a linked list through another method; 
		and totals the purchases; clears cart[] during traversal
	  *@params: n/a
	  *@return: void
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
	
	/**send_To_List method: adds each item in cart[] to linked list
	  *@params: Product sold[] (equivalent to cart[])
	  *@return: void
	*/
	private void send_To_List(Product sold[]){		
		int i = 0;
		while(i < this.pointer_Cart){
			this.list.add_To_List(sold[i]);
			i++; 
		}
	}

	/**Sales_Report method: prints the list of sold items and total sales
	  *@params: n/a
	  *@return: void
	*/
	public void Sales_Report(){
		this.list.print_List();
		System.out.println("Total Sales: "+this.list.total_Sales());
	}
}