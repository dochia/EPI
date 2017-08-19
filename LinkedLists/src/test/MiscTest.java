package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import linked.LinkedList;
import linked.MiscProb;

public class MiscTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testFindMedianCircularList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRemoveKthToLast() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testReverseListNode() {
		LinkedList list = new LinkedList();
		for (int i = 0; i <= 10; i++) {
			list.add(i);
		}
		list.setHead(new MiscProb().reverseList(list.get(0)));
		assertEquals(list.printAll(), "The list contains the following values: 10->9->8->7->6->5->4->3->2->1->0.");
	}

	@Test
	public final void testReverseListLinkedList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIsPalindrome() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testEvenOddMerge() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testZippList() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testFindMiddleOdd() {
		LinkedList list = new LinkedList();
		for (int i = 0; i <= 10; i++) {
			list.add(i);
		}
		LinkedList.Node middle = new MiscProb().findMiddle(list);
		assertEquals(middle.printData(), "The node contains 5.");
	}
	@Test
	public final void testFindMiddleEven() {
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		LinkedList.Node middle = new MiscProb().findMiddle(list);
		assertEquals(middle.printData(), "The node contains 5.");
	}

}
