import java.util.Scanner;

public class FinalProjMain {
public static void main (String []args) {
	Scanner scan = new Scanner(System.in);
	FinalProjList list = new FinalProjList();
	int choice, value; 
	String product;
	boolean flag = true;
	
	while (flag) {
		printMenu();
		choice = scan.nextInt();
		switch (choice) {
			case 0:
				System.out.print("Enter a product to be added to the inventory: ");
				value = scan.nextInt();
				list.addToHead(value);
				System.out.println( value + " has been added to the inventory.");
				pause();
				break;
			case 1:
				System.out.println("Sale: ");
				
				pause();
				break;
			case 2:
				if (!list.isEmpty()) {
					System.out.print("Inventory List: ");
					list.printAll();
				}
				else
					System.out.println("Inventory is empty.");
				pause();
				break;
				default:
					System.out.println("Enter a valid choice: ");
					pause();
			case 3:
				System.out.println("Sales Report: ");
			case 4:
				flag = false;
				break;
		}
	}
	System.out.println("Exited the program..");
}

	private static void printMenu() {
		System.out.println();
		System.out.println("0 - Add a product to inventory.");
		System.out.println("1 - Sale");
		System.out.println("2 - Inventory List");
		System.out.println("3 - Sales Report");
		System.out.println("4 - Exit");
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
		
				