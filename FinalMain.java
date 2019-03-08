import java.io.*;
import java.util.Scanner;
public class FinalMain implements java.io.Serializable{
	public static void main (String args[]) {
		Scanner scan_Int = new Scanner(System.in);
		Scanner scan_String = new Scanner(System.in);
		Another_POS POS = new Another_POS();
		int choice, value; 
		boolean flag = true;
		String product;
		
		System.out.println("POS booting . . .");
		pause();
		
		try{
			FileInputStream file_Input = new FileInputStream("POS_History.txt");
			ObjectInputStream object_Input = new ObjectInputStream(file_Input);
			
			Object obj = object_Input.readObject();
			if(obj instanceof Another_POS){
				POS = (Another_POS)obj;
			}
			object_Input.close();
			file_Input.close();
		}
		catch(Exception e){
			//nothing
		}
		
		System.out.println("\nWELCOME!");

		
		while (flag) {
			printMenu();
			choice = scan_Int.nextInt();
			switch (choice) {
				case 0: //search a product in inventory
					System.out.println("\nSEARCH PRODUCT");
					System.out.println("[0] Product Name");
					System.out.println("[1] Product Code");
					System.out.print("Search by: ");
					int var = scan_Int.nextInt();
					if(var == 0){
						System.out.print("Product Name: ");
						String name = scan_String.nextLine();
						POS.print_Search_Result(POS.Search(name));
					}
					else if(var == 1){
						System.out.print("Product Code: ");
						int code = 0;
						code = scan_Int.nextInt();
						POS.print_Search_Result(POS.Search(code));
					}
					else{
						System.out.println("Invalid choice.");
					}
					pause();
					break;
				case 1: //add product
					System.out.print("Enter a product to be added to the inventory: ");
					product = scan_String.nextLine();
					POS.add_Item(product);
					pause();
					
					break;
				case 2: //delete item from inventory
					System.out.print("Enter product to delete: ");
					product = scan_String.nextLine();
					POS.delete_Item(product);
					pause();
					break;
				case 3: //conduct sales transaction
					System.out.print("Enter a product to add to cart: ");
					product = scan_String.nextLine();
					POS.Sales(product);
					pause();
					break;
				case 4: //print inventory
					POS.Inventory();
					pause();
					break;
				case 5: //print sales report (sales report mismo c/o pia)
					System.out.println("Sales Report: ");
					POS.Sales_Report();
					pause();
					break;
				case 6: //exit program
					try{
					//for sales report
						FileOutputStream file_Output = new FileOutputStream("POS_History.txt");
						ObjectOutputStream object_Output = new ObjectOutputStream(file_Output);
						
						object_Output.writeObject(POS);
						
						object_Output.flush();
						object_Output.close();
						file_Output.close();
					}
					catch(Exception e){
						System.out.println("Error encountered writing to sales report.");
						e.printStackTrace();
					}
					//POS.close_Program();
					flag = false;
					break;
				default:
					System.out.println("Invalid.");
					pause();
					break;
			}
		}
		System.out.println("Exited the program..");
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("0 - Search a product in inventory.");
		System.out.println("1 - Add to inventory.");
		System.out.println("2 - Delete a product from inventory.");
		System.out.println("3 - Sales Transaction");
		System.out.println("4 - Inventory List");
		System.out.println("5 - Sales Report");
		System.out.println("6 - Exit");
		System.out.println();
		System.out.print("Choose a number: ");
	}
	
	public static void pause() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("Press Enter to Continue...");
		String c = scan.nextLine();
	}
}