import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		// Bernadette
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		// Ariezal
		ArrayList<Account> accountList = new ArrayList<Account>();
		// Kenneth
		ArrayList<Order> orderList = new ArrayList<Order>();
		// Karthik
		ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		
		int option = 0;
		
		while (option != 5) {
			
			C206_CaseStudy.optionMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				// Bernadette
				
				
			} else if (option == 2) {
				// Ariezal
				
				
			} else if (option == 3) {
				// Kenneth
				
				
			} else if (option == 4) {
				// Karthik
				
				
			} else if (option == 5) {
				
				System.out.println("Thank you for using this canteen app");
			} else {
				System.out.println("Invalid option");
				
			}
		}

	}

	public static void userTypeMenu() {
		C206_CaseStudy.setHeader("USER TYPE MENU");
		// Bernadette
		System.out.println("1. View All Menu Item");
		System.out.println("2. Add Menu Item");
		System.out.println("3. Delete Menu Item");
		// Ariezal
		// Kenneth
		// Karthik
	}

	public static void optionMenu() {
		C206_CaseStudy.setHeader("OPTION MENU");
		System.out.println("1. Menu Item");
		System.out.println("2. Account");
		System.out.println("3. Order");
		System.out.println("4. Purchase Order");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Bernadette
	public static void addMenuItem(ArrayList<MenuItem> menuItemList) {

	}

	// Bernadette
	public static void deleteMenuItem(ArrayList<MenuItem> menuItemList) {

	}

	// Bernadette
	public static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {

	}

}
