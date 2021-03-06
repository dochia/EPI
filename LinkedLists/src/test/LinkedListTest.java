package test;

import static org.junit.Assert.*;

import org.junit.Test;

import linked.LinkedList;

public class LinkedListTest {

	private LinkedList setNoCycles() {
		LinkedList test = new LinkedList();
		test.add(10);
		test.add(12);
		test.add(20);
		test.add(22);
		return test;
	}

	private LinkedList setWithCycles() {
		LinkedList test = new LinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		LinkedList.Node cycleStarts = test.getLast();
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		LinkedList.Node cycleEnds = test.getLast();
		cycleEnds.setNext(cycleStarts);
		return test;

	}

	@Test
	public final void testAddAlreadyExistingList() {
		LinkedList test = setNoCycles();
		assertTrue(test.size() == 4);
		test.add(15);
		assertTrue(test.size() == 5);
		assertEquals(test.printAll(), "The list contains the following values: 10->12->20->22->15.");
		assertEquals(test.getLast().printData(), "The node contains 15.");

	}
	
	@Test 
	public final void testAddNewList() {
		LinkedList list = new LinkedList();
		list.add(12);
		assertEquals(list.getLast().printData(), "The node contains 12.");
		assertEquals(list.size(), 1);
		assertEquals(list.getFirst().printData(), "The node contains 12.");
	}

	@Test
	public final void testAddFirstEmptyList() {
		LinkedList test = new LinkedList();
		assertTrue(test.size() == 0);
		test.addFirst(5);
		assertEquals(test.printAll(), "The list contains the following values: 5.");
		test.add(12);
		assertEquals(test.printAll(), "The list contains the following values: 5->12.");
		test.addFirst(29);
		assertEquals(test.printAll(), "The list contains the following values: 29->5->12.");

	}
	@Test
	public final void testAddFirstAlreadyExistingList() {
		LinkedList list = setNoCycles();
		assertEquals(list.getFirst().printData(), "The node contains 10.");
		list.addFirst(100);
		assertEquals(list.getFirst().printData(), "The node contains 100.");
	}

	@Test
	public final void testPrintAll() {
		LinkedList test = setNoCycles();
		assertEquals(test.printAll(), "The list contains the following values: 10->12->20->22.");
	}

	@Test
	public final void testGetFirst() {
		LinkedList test = setNoCycles();
		assertEquals(test.getFirst().printData(), "The node contains 10.");
		test.removeFirst();
		assertEquals(test.getFirst().printData(), "The node contains 12.");
	}
	
	@Test
	public final void testGetFirstEmptyList() {
		LinkedList list = new LinkedList();
		assertEquals(list.getFirst(), null);
	}
	

	@Test
	public final void testGet() {
		LinkedList test = setNoCycles();
		LinkedList.Node node = test.get(2);
		assertEquals(node.printData(), "The node contains 20.");
		node = test.get(3);
		assertEquals(node.printData(), "The node contains 22.");
		node = test.get(10);
		assertEquals(node, null);
	}

	@Test
	public final void testGetLast() {
		LinkedList test = setNoCycles();
		LinkedList.Node node = test.getLast();
		assertEquals(node.printData(), "The node contains 22.");
		assertEquals(node.getNext(), null);
	}

	@Test
	public final void testRemoveFirst() {
		LinkedList test = setNoCycles();
		LinkedList.Node first = test.removeFirst();
		assertEquals(first.printData(), "The node contains 10.");
		assertEquals(test.size(), 3);
		assertEquals(test.getFirst().printData(), "The node contains 12.");
	}

	@Test
	public final void testIsCyclic() {
		LinkedList list = setWithCycles();
		assertTrue(list.isCyclic());
		list = setNoCycles();
		assertFalse(list.isCyclic());
	}

	@Test
	public final void testFindCycle() {
		LinkedList test = new LinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		LinkedList.Node cycleStarts = test.getLast();
		cycleStarts.printData();
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		LinkedList.Node cycleEnds = test.getLast();
		test.printAll();
		cycleEnds.printData();
		cycleEnds.setNext(cycleStarts);
		cycleEnds.getNext().printData();

		LinkedList.Node aux = test.findCycle();
		aux.printData();
		assertEquals(cycleStarts, aux);
		assertNotEquals(cycleEnds, aux);
	}

	@Test
	public final void testSize() {
		LinkedList test = new LinkedList();
		int limit = 10;
		for (int i = 0; i < limit; i++) {
			test.add(i);
		}
		assertEquals(test.size(), 10);
	}

	@Test
	public final void testAreOverlappingNoCycles() {
		LinkedList listA = new LinkedList();
		LinkedList listB = new LinkedList();

		for (int i = 1; i < 6; i++) {
			if (i < 4) {
				listB.add(10 + i);
			}
			listA.add(20 + i);
		}
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		listA.add(5);
		LinkedList.Node overlappingStarts = listA.get(5);

		listB.getLast().setNext(overlappingStarts);
		LinkedList.Node node = listA.areOverlappingNoCycles(listB);

		assertTrue(node != null);
		assertTrue(listB.areOverlappingNoCycles(listA) != null);
		assertEquals(listA.areOverlappingNoCycles(listB), overlappingStarts);
		assertEquals(listB.areOverlappingNoCycles(listA), overlappingStarts);
	}

	@Test
	public final void testAreOverlapping() {
		LinkedList listA = new LinkedList();
		LinkedList listB = new LinkedList();

		for (int i = 1; i < 6; i++) {
			if (i < 4) {
				listB.add(10 + i);
			}
			listA.add(20 + i);
		}
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		listA.add(5);
		LinkedList.Node cycleAStarts = listA.get(5);
		listA.getLast().setNext(cycleAStarts);

		LinkedList.Node cycleBStarts = listA.get(8);
		listB.getLast().setNext(cycleBStarts);

		assertTrue(listA.areOverlapping(listB) != null);
		assertTrue(listB.areOverlapping(listA) != null);
	}

	@Test
	public final void testRemove() {
		LinkedList test = setNoCycles();
		assertEquals(test.size(), 4);
		test.add(100);
		LinkedList.Node aux = test.getLast();
		assertEquals(aux.printData(), "The node contains 100.");
		test.add(120);
		test.remove(aux);
		assertEquals(test.size(), 5);
		assertEquals(test.getLast().printData(), "The node contains 120.");
	}

}
