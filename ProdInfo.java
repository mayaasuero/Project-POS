import java.util.Scanner;
public class ProdInfo{
	private String[] stringarray = new String[50];
	Scanner input = new Scanner(System.in);
	Product prodName = new Product();
	
	public void Add_Product(String search){
		int i = 0;
		boolean found = false;
		while(i < this.stringarray.length();){
			if(this.stringarray[i].name == search){
				System.out.print(this.prodName.name + " " + this.prodName.size+ " " +this.prodName.price);
				found = true;
			}
			i++;
		}
		if(!found){
			Product prodName = new Product();
			System.out.print("Name: ");
			String name = input.nextString();
			this.prodName.name() = name;
			
			System.out.print("Price: ");
			int price = input.nextInt();
			this.prodName.price() = price;
			
			System.out.print("Size: ");
			int size = input.nextInt();
			this.prodName.size() = size;
			
			System.out.print("Quantity: ");
			int quantity = input.nextInt();
			this.prodName.quantity() = quantity;
			
		}
		
		System.out.println("Add more products? (Yes/No)");
		String answer = input.nextString();
			
			if(answer == "Yes"){
				System.out.print("Item to search: ");
				search = input.nextString();
				Add_Product(search);
			}
		//exit or end
	}
	
	public void Sale(){
		String cart[] = new String[];
		boolean found = false;
		while(i < this.stringarray.length()){
			if(this.stringarray[i].name == search){
				System.out.print(this.prodName.name + " " + this.prodName.size+ " " +this.prodName.price);
				found = true;
			}
			i++;
		}
		if(!found){
			System.out.println("Product not found.");
			//do another search
		}
		
		//if found
		//add to cart
		//calculate total
		//deduct to inventory
		//question - add another item? (do another search)
		//if not, enter rendered amount; calculate for change
		//confirm sale
		//exit (Y - end program; N - back to main menu)
	}
	
	public void Inventory(){
		int i = 0;
		while(i < this.stringarray.length()){
			System.out.println(this.prodName.name() + " " +this.prodName.price() + " " + this.prodName.quantity() + " " + this.prodName.color());
			//format: name / price / quantity / color)
			i++;
		}
		//or end program
	}
	
	public void SalesReport(){
		//calculate total units per product sold
		//calculate total sales for certain product
		//total sales every day
		System.out.println(this.prodName.name() + " " + this.prodName.color());
		
		//exit or end
	}
}