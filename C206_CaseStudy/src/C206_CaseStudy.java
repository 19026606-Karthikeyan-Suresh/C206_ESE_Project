import java.text.MessageFormat;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		// Bernadette
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		menuItemList.add(new MenuItem("Smoothies", "Strawberry Smoothie", 4.70));
		menuItemList.add(new MenuItem("Soda", "Sprite", 1.50));
		menuItemList.add(new MenuItem("Sweets", "Lollipops", 2.00));

		// Ariezal
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account("James", "canteen123", "Staff"));
		accountList.add(new Account("Zac", "canteen123", "Canteen Admin"));
		accountList.add(new Account("Joe", "canteen123", "Customer"));
		accountList.add(new Account("Aaron", "canteen123", "Staff"));

		// Kenneth
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<MenuItem> orderMenu = new ArrayList<>();
		orderList.add(new Order("Jerry", "pending", true, orderMenu));

		// Karthik
		ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();

		int option = 0;

		while (option != 5) {

			C206_CaseStudy.optionMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Bernadette
				// View Menu Items
				C206_CaseStudy.setHeader("View, Add, Delete Menu Items");
				userTypeMenu();

				int itemType = Helper.readInt("Enter option to select type > ");

				if (itemType == 1) {
					// View All Menu Item
					C206_CaseStudy.viewAllMenuItem(menuItemList);

				} else if (itemType == 2) {
					// Add Menu Item
					C206_CaseStudy.addMenuItem(menuItemList);

				} else if (itemType == 3) {
					// Delete Menu Item
					C206_CaseStudy.deleteMenuItem(menuItemList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 2) {
				// Ariezal
				C206_CaseStudy.setHeader("View, Add, Delete Account");
				userTypeMenu();

				int itemType = Helper.readInt("Enter option to select type > ");

				if (itemType == 1) {
					// View All Accounts
					C206_CaseStudy.viewAllAccounts(accountList);

				} else if (itemType == 2) {
					// Add Account

//					C206_CaseStudy.addAccount(accountList);

					//TODO C206_CaseStudy.addAccount(accountList);

				} else if (itemType == 3) {
					// Delete Account
					C206_CaseStudy.deleteAccount(accountList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Kenneth
				C206_CaseStudy.setHeader("1. View Order(s) \n2. Add Order \n3. Delete Order");
				int itemType = Helper.readInt("Enter option to select type > ");
				String user = Helper.readString("Enter Account Name: ");
				System.out.println("");
				
				String itemName;
				if (itemType == 1) {
					// View All Order
					System.out.println("");
					System.out.println(C206_CaseStudy.viewAllOrder(orderList, user));

				} else if (itemType == 2) {
					// Add Order
					itemName = Helper.readString("Enter name of Item in Menu: ");
					System.out.println("");					
					C206_CaseStudy.storeOrder(orderList, user, menuItemList, itemName);

				} else if (itemType == 3) {
					// Delete Order

					String itemName = Helper.readString("Enter name of Item in Menu: ");
					C206_CaseStudy.deleteOrder(orderList, user, itemName);

					System.out.println("");
					C206_CaseStudy.deleteOrder(orderList, user);


				} else {
					System.out.println("\nInvalid type");
				}

			} else if (option == 4) {
				// Karthik
				C206_CaseStudy.setHeader("View, Add, Delete Purchase Order");
				userTypeMenu();

				int itemType = Helper.readInt("Enter option to select type > ");

				if (itemType == 1) {
					// View all purchase orders
					C206_CaseStudy.viewAllPurchaseOrders(purchaseOrderList);

				} else if (itemType == 2) {
					// Add item to purchase
					C206_CaseStudy.addPurchaseOrder(purchaseOrderList);

				} else if (itemType == 3) {
					// Delete purchase in order list
					C206_CaseStudy.deletePurchaseOrder(purchaseOrderList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {

				System.out.println("Thank you for using this canteen app");
			} else {
				System.out.println("Invalid option");

			}
		}

	}

	public static void userTypeMenu() {
		C206_CaseStudy.setHeader("USER TYPE MENU");
		System.out.println("1. View All");
		System.out.println("2. Add");
		System.out.println("3. Delete");

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

	// ================================= Option 1 Add, View, Delete
	// Menu Item =================================

	public static String retrieveAllMenuItems(ArrayList<MenuItem> menuItemList) {
		String output = "";
		for (int i = 0; i < menuItemList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", menuItemList.get(i).getCategory(),
					menuItemList.get(i).getName(), menuItemList.get(i).getPrice());
		}
		return output;
	}
	
	public static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
		for (int i = 0; i < menuItemList.size(); i++) {
			C206_CaseStudy.setHeader("MENU ITEM LIST");
			String output = String.format("%-10s %-30s %-10s\n", "CATEGORY", "NAME", "PRICE");
			output += retrieveAllMenuItems(menuItemList);

			System.out.println(output);
		}

	}

	public static boolean doAddMenuItem(ArrayList<MenuItem> menuItemList, String category, String name, double price) {
		boolean isAdded = false;

		MenuItem addItem = new MenuItem(category, name, price);

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i) != null) {
				menuItemList.add(addItem);
				isAdded = true;

			}
		}
		return isAdded;
	}

	public static void addMenuItem(ArrayList<MenuItem> menuItemList) {
		String category = Helper.readString("Enter category > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");

		Boolean isAdded = doAddMenuItem(menuItemList, category, name, price);
		if (isAdded == false) {
			System.out.println("Menu Item is not added");
		} else {
			System.out.println("Menu Item is added");
		}
	}

	public static boolean doDeleteMenuItem(ArrayList<MenuItem> menuItemList, String category, String name, double price) {
		boolean isDeleted = false;

		MenuItem deleteItem = new MenuItem(category, name, price);

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i) == deleteItem) {
				menuItemList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;
	}

	public static void deleteMenuItem(ArrayList<MenuItem> menuItemList) {
		String category = Helper.readString("Enter category > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");

		Boolean isDeleted = doDeleteMenuItem(menuItemList, category, name, price);
		
		if (isDeleted == false) {
			System.out.println("Menu Item is not deleted");
		} else {
			System.out.println("Menu Item is deleted");
		}

	}

	// ================================= Option 2 (Ariezal) Add, View, Delete
	// Account =================================
	// Retrieving account list.
	public static String retrieveAllAccounts(ArrayList<Account> accountList) {
		String output = "";
		for (int i = 0; i < accountList.size(); i++) {

			output += String.format("%-10s %-30s %-10.2f\n", accountList.get(i).getUsername(),
					accountList.get(i).getPassword(), accountList.get(i).getUserRole());

		}
		return output;
	} // Viewing Account List

	public static void viewAllAccounts(ArrayList<Account> accountList) {
		for (int i = 0; i < accountList.size(); i++) {
			C206_CaseStudy.setHeader("ACCOUNT LIST");
			String output = String.format("%-10s %-30s %-10s\n", "USERNAME", "PASSWORD", "USER ROLE");
			output += retrieveAllAccounts(accountList);
			System.out.println(output);
		}
	} // Inputing Account

	public static Account inputAccount() {
		String username = Helper.readString("Enter Username > ");
		String password = Helper.readString("Enter Password > ");
		String userRole = Helper.readString("Enter userRole > ");

		Account a = new Account(username, password, userRole);
		return a;
	} // Adding Account

	public static void addAccount(ArrayList<Account> accountList, Account a) {

		accountList.add(a);
		System.out.println("New Account Added!");

	}

	public static boolean doDelete(ArrayList<Account> accountList, String username, String password, String userRole) {
		boolean isDeleted = false;

		for (int i = 0; i < accountList.size(); i++) {
			String z = accountList.get(i).getUsername();
			if (username.equalsIgnoreCase(z)) {
				accountList.get(i).setPassword(password);
				accountList.get(i).setUserRole(userRole);
			}
		}
		return isDeleted;
	}

	public static void deleteAccount(ArrayList<Account> accountList) {
		C206_CaseStudy.viewAllAccounts(accountList);
		String username = Helper.readString("Enter Username > ");
		String password = Helper.readString("Enter Password > ");
		String userRole = Helper.readString("Enter User Role > ");
		Boolean isDeleted = doDelete(accountList, username, password, userRole);
		if (isDeleted == false) {
			System.out.println("Account does not exist.");
		} else {
			System.out.println("Staff " + username + "'s account has been deleted.");
		}

	}

	// ================================= Option 3 Add, View, Delete Order
	// ===================================

	// Kenneth
	public static String viewAllOrder(ArrayList<Order> orderList, String user) {
		String s = "";
		String pattern = "Type: {1}, Name: {2}, Price: {3}\n";
		for (Order i : orderList) {
			if (user.equalsIgnoreCase(i.getUsername()))
				for (MenuItem j : i.getItems()) {
					s += MessageFormat.format(pattern, j.getCategory(), j.getName(), j.getPrice());
				}
		int u = 0;
		for(Order i: orderList) {
			if(user.equalsIgnoreCase(i.getUsername())) {
				u++;
				for(MenuItem j: i.getItems()) {
					String pattern = "Type: %s, Name: %s, Price: %.2f\n";
					s += String.format(pattern, j.getCategory(), j.getName(), j.getPrice());
				}
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!\n");
		return s;
	}

	// Kenneth

	public static void storeOrder(ArrayList<Order> orderList, String user, ArrayList<MenuItem> menuItemList,
			String itemName) {
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) {
				for (int j = 0; j < orderList.size(); j++) {
					if (itemName.equalsIgnoreCase(menuItemList.get(j).getName())) {

	public static void storeOrder(ArrayList<Order> orderList, String user, ArrayList<MenuItem> menuItemList, String itemName) {
		int u = 0;
		int k = 0;
		for(int i = 0; i< orderList.size(); i++) {
			if(user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
				u++;
				for(int j = 0; j< orderList.size(); j++) {
					if(itemName.equalsIgnoreCase(menuItemList.get(j).getName())) {
						k++;
						orderList.get(i).getItems().add(menuItemList.get(j));
						System.out.println("Item Stored!");
					}
				}
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!");
		else if(k == 0)
			System.out.println("Invalid Menu Item!");
	}

	// Kenneth
	public static void deleteOrder(ArrayList<Order> orderList, String user) {
		int u = 0;
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
				u++;
				orderList.remove(i);
				System.out.println("Orders Deleted!");
			}
//				for (int j = 0; j < orderList.get(i).getItems().size(); j++) {
//					if (itemToDelete.equalsIgnoreCase(orderList.get(i).getItems().get(j).getName())) 
//						orderList.get(i).getItems().remove(j);
//				}
		}
		if(u == 0)
			System.out.println("Invalid Account name!");
	}

	// ================================= Option 4 Add, View, Purchase
	// Order=================================

	private static void deletePurchaseOrder(ArrayList<PurchaseOrder> purchaseOrderList) {
		// TODO Auto-generated method stub

	}

	private static void addPurchaseOrder(ArrayList<PurchaseOrder> purchaseOrderList) {
		// TODO Auto-generated method stub

	}

	private static void viewAllPurchaseOrders(ArrayList<PurchaseOrder> purchaseOrderList) {
		// TODO Auto-generated method stub

	}

}
