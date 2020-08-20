import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		// Bernadette
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		menuItemList.add(new MenuItem("Smoothies", "Strawberry", 4.70));
		menuItemList.add(new MenuItem("Soda", "Coca Cola", 1.50));

		// Ariezal 
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account("James", "canteen123" , "Staff" ));
		accountList.add(new Account("Zac", "canteen123", "Canteen Admin"));
		accountList.add(new Account("Joe", "canteen123", "Customer"));
		accountList.add(new Account("Aaron", "canteen123" , "Staff" ));
		

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
					MenuItem m = inputMenuItem();
					C206_CaseStudy.addMenuItem(menuItemList, m);

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
					C206_CaseStudy.viewAllAccount(accountList);
					
				} else if (itemType == 2) {
					// Add Account

					C206_CaseStudy.addAccount(accountList);

				} else if (itemType == 3) {
					// Delete Account
					C206_CaseStudy.deleteAccount(accountList);

				} else {
					System.out.println("Invalid type");

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

	// ================================= (Bernadette) Option 1 Add, View, Delete Menu Item =================================

	public static String retrieveAllMenuItems(ArrayList<MenuItem> menuItemList) {
		String output = "";
		for (int i = 0; i < menuItemList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", 
					menuItemList.get(i).getCategory(), menuItemList.get(i).getName(), menuItemList.get(i).getPrice());

			output += String.format("%-10s %-30s %-10.2f\n", menuItemList.get(i).getCategory(),
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
	
	public static MenuItem inputMenuItem() {
		String category = Helper.readString("Enter category > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		
		MenuItem m = new MenuItem(category, name, price);
		return m;
	}

	public static void addMenuItem(ArrayList<MenuItem> menuItemList, MenuItem m) {
		
		menuItemList.add(m);
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

	// ================================= Option 2 Add, View, Delete Account =================================


	// ================================= Option 3 Add, View, Delete Order ===================================

	// Kenneth
	public static String viewAllOrder(ArrayList<Order> orderList, String user) {
		String s = "";
		
		for(Order i: orderList) {
			if(user.equalsIgnoreCase(i.getUsername()))
			for(MenuItem j: i.getItems()) {
				 s += String.format("Type: %s, Name: %s, Price: %.2f\n", j.getCategory(), j.getName(), j.getPrice());
		}
	}
		return s;
	}


	// Kenneth
	public static void storeOrder(ArrayList<Order> orderList, String user,ArrayList<MenuItem> menuItemList, String itemName) {
		for(int i = 0; i< orderList.size(); i++) {
			if(user.equalsIgnoreCase(orderList.get(i).getUsername())) {
				for(int j = 0; j< orderList.size(); j++) {
					if(itemName.equalsIgnoreCase(menuItemList.get(j).getName())) {
						orderList.get(i).getItems().add(
								new MenuItem(menuItemList.get(j).getCategory(), menuItemList.get(j).getName(), menuItemList.get(j).getPrice()));
					}
				}
			}
		}
	}

	// Kenneth
	public static void deleteOrder(ArrayList<Order> orderList, String user) {
		String orderD = Helper.readString("Enter menu item Name to delete: ");
		for(int i = 0; i< orderList.size(); i++) {
			if(user.equalsIgnoreCase(orderList.get(i).getUsername())) {
				for(int j = 0; j < orderList.get(i).getItems().size();j++) {
					if(orderD.equalsIgnoreCase(
							orderList.get(i).getItems().get(j).getName())) {
						orderList.get(i).getItems().remove(j);
					}
				}
			}
		}
	}

	// ================================= Option 4 Add, View, Purchase Order =================================

}
