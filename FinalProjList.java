import java.util.Scanner;
public class FinalProjList {
	
	FinalProjNode head;
	FinalProjNode tail;
	int info;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addToHead(int info) {
		head = new FinalProjNode(info, head);
		if (tail == null)
			tail = head;
	}
	
	public void printAll() {
		FinalProjNode node = head;
		while(node.next!=null)
		{
			System.out.print(node.info+" ");
			node = node.next;
		}
		System.out.print(node.info);
	}
	
	public boolean isInList(int el) {

		FinalProjNode temp;
		for (temp = head; temp != null && temp.info != el; temp = temp.next);
		return temp != null;

	}
	
	public void promptEnterKey(){
		System.out.println();
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
	}

	public void menu() {
			System.out.println();
		    System.out.println("0 - Add a product to inventory");
	        System.out.println("1 - Sale");
	        System.out.println("2 - Inventory List");
	        System.out.println("3 - Sales Report");
	        System.out.println("4 - Exit");
	}
}