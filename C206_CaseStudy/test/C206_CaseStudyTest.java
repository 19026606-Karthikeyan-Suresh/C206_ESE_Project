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
	private ArrayList<Account> accountList;

	// Karthik
	private ArrayList<PurchaseOrder> purchaseOrderList;

	// Bernadette
	private ArrayList<MenuItem> menuItemList;

	// Kenneth
	private ArrayList<Order> orderList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// Bernadette
		m1 = new MenuItem("Snacks", "Biscuits", 3.70);
		m2 = new MenuItem("Desserts", "Cakes", 3.00);

		
		// Bernadette
		menuItemList = new ArrayList<MenuItem>();

		// Kenneth
		orderList = new ArrayList<Order>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test // Bernadette
	public void c206_testAddMenuItem() {
		// Menu Item list is not null, so that can add a new menu item - boundary
		assertNotNull("Check if there is valid Menu Item arraylist to add to", menuItemList);

		// Given an empty list, after adding 1 menu item, the size of the list is 1 - normal
		C206_CaseStudy.addMenuItem(menuItemList, m1);
		assertEquals("Check that Menu Item arraylist size is 1", 1, menuItemList.size());
		assertSame("Check that Menu Item is added", m1, menuItemList.get(0));

		// Add another menu item. test The size of the list is 2 - normal
		C206_CaseStudy.addMenuItem(menuItemList, m2);
		assertEquals("Check that Menu Item arraylist size is 2", 2, menuItemList.size());
		assertSame("Check that Menu Item is added", m2, menuItemList.get(1));

	}

	@Test // Bernadette
	public void c206_retrieveAllMenuItemTest() {
		// Test if Menu Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Menu Item arraylist to retrieve menu items", menuItemList);

		// test if the list of menu items retrieved from the C206 Case Study is empty - boundary
		String allMenuItems = C206_CaseStudy.retrieveAllMenuItems(menuItemList);
		String testOutput = "";
		assertEquals("Check that ViewAllMenuItemlist", testOutput, allMenuItems);

		// Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addMenuItem(menuItemList, m1);
		C206_CaseStudy.addMenuItem(menuItemList, m2);
		assertEquals("Test that Menu Item arraylist size is 2", 2, menuItemList.size());

		// test if the expected output string same as the list of menu items retrieved
		// from the C206 Case Study
		allMenuItems = C206_CaseStudy.retrieveAllMenuItems(menuItemList);
		testOutput = String.format("%-10s %-30s %-10s\n", "Snacks", "Biscuits", 3.70);
		testOutput += String.format("%-10s %-30s %-10s\n", "Desserts", "Cakes", 3.00);
		assertEquals("Test that ViewAllMenuItemlist", testOutput, allMenuItems);
	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
	}
}
