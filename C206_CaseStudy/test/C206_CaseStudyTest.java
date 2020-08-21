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

				
		// Bernadette
		menuItemList = new ArrayList<MenuItem>();

		// Kenneth
		orderList = new ArrayList<Order>();
		orderMenuList = new ArrayList<MenuItem>();
		orderMenuList.add(m1);
		orderMenuList.add(m2);
		o1 = new Order("Jerry", "pending", false, orderMenuList);
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

	@Test // Kenneth
	public void testViewAllOrder() {
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

	@Test // Kenneth
	public void testStoreOrder() {
		// Test if the user Order Menu Item list is null and empty - error
		C206_CaseStudy.storeOrder(orderList, "Tom", orderMenuList, "Cakes"); // Tom is not a user account
		assertNotEquals(
				"Test if the menu item is not added as username is not valid Order Item arraylist to view all order items",
				"Cakes", orderList.get(0).getItems().get(0));

		// test if the list of order menu items retrieved from the C206 Case Study is
		// empty -error
		C206_CaseStudy.storeOrder(orderList, "Jerry", orderMenuList, "Invalid Item");
		String testOutput = "";
		assertEquals("Check that item for orderMenuList was not added to OrderList and is empty", testOutput,
				orderList.get(0).getItems());

		// test if the list of order menu items retrieved from the C206 Case Study is
		// not empty -normal
		C206_CaseStudy.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");
		testOutput = "Cakes";
		assertEquals("Check that the item in orderMenuList was properly added to OrderList and is not empty",
				testOutput, orderList.get(0).getItems());

	}

	@Test // Kenneth
	public void testDeleteOrder() {
		// Test if Order list is not null but empty - error
		assertNotNull("Test if there is a valid Order arraylist to view all order items", orderList);

		// test if the list of order items retrieved from the C206 Case Study is empty
		// -error
		C206_CaseStudy.deleteOrder(orderList, "Jerry", "Invalid Item");
		String testOutput = "";
		assertEquals("Check that item for orderMenuList was not added to OrderList and is empty", testOutput,
				orderList.get(0).getItems());

		// test if the list of order menu items retrieved from the C206 Case Study is
		// not empty -normal
		C206_CaseStudy.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");
		C206_CaseStudy.deleteOrder(orderList, "Jerry", "Cakes");
		testOutput = "Cakes";
		assertNotEquals("Check that the item was properly deleted in OrderList and is empty", testOutput,
				orderList.get(0).getItems());

	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
	}
}
