import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private String o1;
	private String o2;
	
	private ArrayList<String> orderList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		String o1 = "APPLE";
		String o2 = "PEAR";
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void c206_testAddOrder() {
		//fail("Not yet implemented"); 
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Order arraylist to add to", orderList);

		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addOrder(orderList, o1);
		assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
		assertSame("Check that Order is added", o1, orderList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addOrder(orderList, o2 );
		assertEquals("Check that Order arraylist size is 2", 2, orderList.size());
		assertSame("Check that Order is added", o2, orderList.get(1));
		}
	
	@Test
	public void c206_testRemoveOrder() {
		//fail("Not yet implemented"); 
		// Item list is not null, so that can remove an item - boundary
		assertNotNull("Check if there is valid Order arraylist to remove from", orderList);

		C206_CaseStudy.addOrder(orderList, o1);
		C206_CaseStudy.addOrder(orderList, o2);
		
		//Given an empty list, after removing 1 item, the size of the list is 1 - normal
		//The item just removed is the same as the first item of the list
		C206_CaseStudy.removeOrder(orderList, o1);
		assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
		
		//Remove another item. test The size of the list is 0? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.removeOrder(orderList, o2 );
		assertEquals("Check that Order arraylist size is 0", 0, orderList.size());
		}
	
	@Test
	public void retrieveAllOrderTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Order arraylist to retrieve item", orderList);
		
		//test if the list of orders retrieved from the SourceCentre is empty - boundary
		String allOrder= C206_CaseStudy.retrieveAllOrder(orderList);
		String testOutput = "";
		assertEquals("Check that ViewAllOrderlist", testOutput, allOrder);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addOrder(orderList, o1);
		C206_CaseStudy.addOrder(orderList, o2);
		assertEquals("Test that Order arraylist size is 2", 2, orderList.size());
		
		//test if the expected output string same as the list of orders retrieved from the SourceCentre	
		allOrder = C206_CaseStudy.retrieveAllOrder(orderList);
		testOutput = String.format("PINEAPPLE");
		testOutput += String.format("ORANGE");
	
		assertEquals("Test that ViewAllOrderlist", testOutput, allOrder);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
