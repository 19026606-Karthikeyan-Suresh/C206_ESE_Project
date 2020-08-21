import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		// Bernadette
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		menuItemList.add(new MenuItem("Smoothies", "Strawberry", 4.70));
		menuItemList.add(new MenuItem("Soda", "Coca Cola", 1.50));

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
					C206_CaseStudy.addAccount(accountList);

				} else if (itemType == 3) {
					// Delete Account
					C206_CaseStudy.deleteAccount(accountList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Kenneth
				C206_CaseStudy.setHeader("View, Add, Delete Order");
				userTypeMenu();
				String user = Helper.readString("Enter Account Name: ");
				int itemType = Helper.readInt("Enter option to select type > ");

				if (itemType == 1) {
					// View All Order
					System.out.println(C206_CaseStudy.viewAllOrder(orderList, user));

				} else if (itemType == 2) {
					// Add Order
					String itemName = Helper.readString("Enter name of Item in Menu: ");
					C206_CaseStudy.storeOrder(orderList, user, menuItemList, itemName);

				} else if (itemType == 3) {
					// Delete Order
					C206_CaseStudy.deleteOrder(orderList, user);

				} else {
					System.out.println("Invalid type");
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

	// ================================= (Bernadette) Option 1 Add, View, Delete
	// Menu Item =================================

	public static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
		for (int i = 0; i < menuItemList.size(); i++) {
			C206_CaseStudy.setHeader("MENU ITEM LIST");
			String output = String.format("%-10s %-30s %-10s\n", "CATEGORY", "NAME", "PRICE");
			output += String.format("%-10s %-30s %-10.2f\n", menuItemList.get(i).getCategory(),
					menuItemList.get(i).getName(), menuItemList.get(i).getPrice());
			System.out.println(output);
		}

	}

	public static void addMenuItem(ArrayList<MenuItem> menuItemList) {
		String category = Helper.readString("Enter category > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		MenuItem m = new MenuItem(category, name, price);
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i) != null) {
				menuItemList.add(m);
			}
		}
		System.out.println("Menu Item Added");

	}

	public static boolean doDelete(ArrayList<MenuItem> menuItemList, String category, String name, double price) {
		boolean isDeleted = false;

		for (int i = 0; i < menuItemList.size(); i++) {
			String c = menuItemList.get(i).getCategory();
			if (category.equalsIgnoreCase(c)) {
				menuItemList.get(i).setName(name);
				menuItemList.get(i).setPrice(price);
			}
		}
		return isDeleted;
	}

	public static void deleteMenuItem(ArrayList<MenuItem> menuItemList) {
		C206_CaseStudy.viewAllMenuItem(menuItemList);
		String category = Helper.readString("Enter category > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		Boolean isDeleted = doDelete(menuItemList, category, name, price);
		if (isDeleted == false) {
			System.out.println("Invalid category");
		} else {
			System.out.println("Menu Item " + category + " is deleted");
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

		for (Order i : orderList) {
			if (user.equalsIgnoreCase(i.getUsername()))
				for (MenuItem j : i.getItems()) {
					s += String.format("Type: %s, Name: %s, Price: %.2f\n", j.getCategory(), j.getName(), j.getPrice());
				}
		}
		return s;
	}

	// Kenneth
	public static void storeOrder(ArrayList<Order> orderList, String user, ArrayList<MenuItem> menuItemList,
			String itemName) {
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) {
				for (int j = 0; j < orderList.size(); j++) {
					if (itemName.equalsIgnoreCase(menuItemList.get(j).getName())) {
						orderList.get(i).getItems().add(new MenuItem(menuItemList.get(j).getCategory(),
								menuItemList.get(j).getName(), menuItemList.get(j).getPrice()));
					}
				}
			}
		}
	}

	// Kenneth
	public static void deleteOrder(ArrayList<Order> orderList, String user) {
		String orderD = Helper.readString("Enter menu item Name to delete: ");
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) {
				for (int j = 0; j < orderList.get(i).getItems().size(); j++) {
					if (orderD.equalsIgnoreCase(orderList.get(i).getItems().get(j).getName())) {
						orderList.get(i).getItems().remove(j);
					}
				}
			}
		}
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
