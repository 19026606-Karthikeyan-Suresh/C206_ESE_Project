import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// Bernadette
	private MenuItem m1;
	private MenuItem m2;

	// Kenneth
	private Order o1;
	private Order o2;

	// Ariezal
	private Account a1;
	private Account a2;
	
	//Karthik
	private PurchaseOrder po1;
	private PurchaseOrder po2;
		
	// Ariezal
	private ArrayList<Account> accountList;

	// Karthik
	private ArrayList<PurchaseOrder> purchaseOrderList;

	// Bernadette
	private ArrayList<MenuItem> menuItemList;

	// Kenneth
	private ArrayList<Order> orderList;
	private ArrayList<MenuItem> orderMenuList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// Bernadette
		menuItemList = new ArrayList<MenuItem>();
		m1 = new MenuItem("Snacks", "Biscuits", 3.70);
		m2 = new MenuItem("Desserts", "Cakes", 3.00);
		
		// Ariezal
		a1 = new Account("Danny", "canteen123","Staff" );
		a2 = new Account("Biden", "canteen123","Staff" );

		//Karthik
		po1 = new PurchaseOrder("Strawberry", 10, 10.50, "21/08/2020");
		po1 = new PurchaseOrder("Banana", 15, 12.40, "21/08/2020");	
		
		// Bernadette
		menuItemList = new ArrayList<MenuItem>();

		// Kenneth
		orderList = new ArrayList<Order>();
		orderMenuList = new ArrayList<MenuItem>();
		o1 = new Order("Jerry", "pending", false, orderMenuList);
		orderMenuList.add(m1);
		orderMenuList.add(m2);

		
		//Karthik
		purchaseOrderList = new ArrayList<PurchaseOrder>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test // Bernadette
	public void testViewAllMenuItem() {
		// Test if menu item list is null, it should return an error - error
		assertNull("Test if there is a valid Menu Item arraylist to view all menu items", menuItemList);

		// Test if menu item list is NOT null, it should display all the menu items -
		// normal
		assertNotNull("Test if there is a valid Menu Item araylist to view all menu items", menuItemList);
	}

	public void testAddMenuItem() {
		// Test if the menu item list has the item that is NOT available, the new item
		// will be added - normal
		C206_CaseStudy.addMenuItem(menuItemList, m1);
		assertEquals("Test that Menu Item arraylist size is 1", 1, menuItemList.get(0));
		assertSame("Test that Menu Item is added", m1, menuItemList.get(0));

		// Test if the menu item list has the item that is NOT available, another new item
		// will be added - normal
		C206_CaseStudy.addMenuItem(menuItemList, m2);
		assertEquals("Test that Menu Item arraylist size is 2", 2, menuItemList.get(1));
		assertSame("Test that Menu Item is added", m1, menuItemList.get(1));
		
		// Test if the menu item list has the item is already available/existed, it should return an error - error
		
	}

@Test //Kenneth
	public void c206_testViewAllOrder() {
		// Test if Order list is not null but empty - error
		assertNotNull("Test if there is a valid Order arraylist to view all order items", orderList);

		// test if the list of order retrieved from the C206 Case Study is empty -error
		String allOrders = C206_CaseStudy.viewAllOrder(orderList, "Jerry");
		String testOutput = "";
		assertEquals("Check that OrderList is not empty", testOutput, allOrders);

		orderList.add(o1);
		allOrders = C206_CaseStudy.viewAllOrder(orderList, "Jerry");
		assertNotNull("Test if there is valid Order Item to view in ArrayList", allOrders);
		
	}
	
	@Test //Kenneth
	public void c206_testStoreOrder(){
		// Test if the user Order Menu Item list is null and empty - error
		orderList.add(o1);
		C206_CaseStudy.storeOrder(orderList, "Tom", orderMenuList, "Cakes"); //Tom is not a user account
		assertNotEquals("Test if the menu item is not added as username is not valid Order Item arraylist to view all order items", "Cakes", orderList.get(0).getItems());

		// test if the list of order menu items retrieved from the C206 Case Study is empty -error
		C206_CaseStudy.storeOrder(orderList, "Jerry", orderMenuList, "Invalid Item");
//		MenuItem testOutput = null;
		assertEquals("Check that item for orderMenuList was not added to OrderList and is empty", false, orderList.get(0).getItems().isEmpty());

		// test if the list of order menu items retrieved from the C206 Case Study is not empty -normal
		orderList.removeAll(orderList);
		orderList.add(o1);
		C206_CaseStudy.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");
		String testOutput2 = "Cakes";
		assertEquals("Check that the item in orderMenuList was properly added to OrderList and is not empty", testOutput2, orderList.get(0).getItems().get(1).getName());

	}

	@Test //Kenneth
	public void c206_testDeleteOrder(){
		// Test if Order list is not null but empty - error
		orderList.add(o1);
		assertNotNull("Test if there is a valid Order arraylist to view all order items", orderList);

		// test if the invalid item from the C206 Case Study was deleted  -error
		C206_CaseStudy.deleteOrder(orderList, "Jerry");
		assertEquals("Check that invalid item for orderMenuList was not deleted from OrderList and is empty", true, orderList.isEmpty());
		
		// test if the list of order menu items retrieved from the C206 Case Study is not empty -normal
		orderList.add(o1);
		orderMenuList.add(m1);
		orderMenuList.add(m2);
		C206_CaseStudy.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");
		assertEquals("Check that the item was added in OrderList and is not empty", false /*testOutput*/, orderList.isEmpty());
		C206_CaseStudy.deleteOrder(orderList, "Jerry");
//		String testOutput = "Cakes";
		assertEquals("Check that the item was properly deleted in OrderList and is empty", true /*testOutput*/, orderList.isEmpty());

	}
	
	@Test //Karthik
	public void testViewPurchaseOrderList() {
		//Test if purchaseOrderList is null - it returns a error
		assertNull("Test if there is a Purchase Order arraylist to view all Purchase Order items", purchaseOrderList);

		// Test if purchaseOrderList is NOT null, it should display all the purchase order items 
		// normal
		assertNotNull("Test if there is a valid Purchase Order araylist to view all Purchase Order items", purchaseOrderList);
	}
	
	public void testAddPurchaseOrderItem() { 
		// Test if the purchaseOrderList has the item that is NOT available, the new item
		// will be added - normal
		C206_CaseStudy.addPurchaseOrder(purchaseOrderList, po1);
		assertEquals("Test that Purchase Order Item arraylist size is 1", 1, purchaseOrderList.get(0));
		assertSame("Test that Purchase Order Item is added", po1, purchaseOrderList.get(0));

		// Test if the purchaseOrderList has the item that is NOT available, another new item
		// will be added - normal
		C206_CaseStudy.addPurchaseOrder(purchaseOrderList, po2);
		assertEquals("Test that Purchase Order List arraylist size is 2", 2, purchaseOrderList.get(1));
		assertSame("Test that Purchase Order Item is added", po1, purchaseOrderList.get(1));
				
		// Test if the  purchaseOrderList has the item is already available/existed, it should return an error - error
	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
	}
}