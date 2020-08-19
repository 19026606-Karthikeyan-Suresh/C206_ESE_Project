import java.util.ArrayList;

public class C206_CaseStudy {
	private static ArrayList<String> orderList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		orderList.add("Gyoza Set A");
		orderList.add("Large Hawaiian Pizza");
		int option = 0;
		while(option != 5) {
			menu();
			option = 3;/* no helper so just enter some random number you want to test your code Helper.readInt("Enter an option> ");*/
			if(option == 1) {
				
			}else if (option == 2) {
				
			}else if (option == 3) {
				C206_CaseStudy.order();
			}else if(option == 4) {
				
			}
			
		}
		
	}
	

	public static void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. User Account"
				+ "\n2. Menu Items"
				+ "\n3. Order"
				+ "\n4. Purchase Order"
				+ "\n5. Quit");
	}

	
	public static void order() {
		// TODO Auto-generated method stub
		int option = 0;
		
		while(option != 4) {
			
			System.out.println("1. Add to order"
					+ "\n2. View order"
					+ "\n3. Delete item in order"
					+ "\n4. Exit order menu");
			
			option = 3;/* no helper so just enter some random number you want to test your code Helper.readInt("Enter an option> ");*/
			if(option == 1) {
				String item = "Gyoza"; /* no helper so just enter some random number you want to test your code Helper.readInt("Enter an option> ");*/
				if (!item.equalsIgnoreCase("") && !item.isEmpty())
					C206_CaseStudy.addOrder(orderList, item);
				else 
					System.out.println("Invalid item");
			}else if (option == 2) {
				System.out.println(C206_CaseStudy.retrieveAllOrder(orderList));
			}else if (option == 3) {
				String item = "Gyoza"; /* no helper so just enter some random number you want to test your code Helper.readInt("Enter an option> ");*/
				if (!item.equalsIgnoreCase("") && !item.isEmpty())
				for(String o: orderList) {
					if(item.equalsIgnoreCase(o))
						C206_CaseStudy.removeOrder(orderList, item);
				}
				else 
					System.out.println("Invalid item");
				
			}
		}
	}


	 static String retrieveAllOrder(ArrayList<String> orderList2) {
		// TODO Auto-generated method stub
		 String returnS = "";
		 for(String o: orderList) {
			 returnS += String .format("\n%s", o);
		 }
		 return returnS;
	}


	static void removeOrder(ArrayList<String> orderList, String item) {
		// TODO Auto-generated method stub
		orderList.remove(item);
	}


	static void addOrder(ArrayList<String> orderList, String item) {
		// TODO Auto-generated method stub
		orderList.add(item);

	}
}
