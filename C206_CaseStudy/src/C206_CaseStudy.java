import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		// Bernadette
		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
		
		

	}
	
	public static void userTypeMenu() {
		C206_CaseStudy.setHeader("USER TYPE MENU");
		System.out.println("1. Menu Item");
		System.out.println("2. Account");
		System.out.println("3. Order");
		System.out.println("4. Ingredient");
		System.out.println("5. Promotion");
		
	}
	
	public static void optionMenu() {
		C206_CaseStudy.setHeader("OPTION MENU");
	
			
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	// Bernadette
	public static void addMenuItem(ArrayList<MenuItem> menuList) {
		
	}
	
	// Bernadette
    public static void deleteMenuItem(ArrayList<MenuItem> menuList) {
		
	}
    
    // Bernadette
    public static void viewMenuItem(ArrayList<MenuItem> menuList) {
		
	}

}
