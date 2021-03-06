package linked;

public class LinkedListsMain {

	public static void something() {

		LinkedList list = new LinkedList();
		System.out.println(list.size());
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.printAll();
		LinkedList.Node a = list.get(5);
		LinkedList.Node last = list.getLast();
		System.out.println(list.size());
		last.next = a;
		System.out.println("Here: " + list.size());
		
		System.out.println(list.isCyclic());
		list.printAll();
		
		LinkedList second = new LinkedList();
		second.add(10);
		second.add(11);
		second.add(12);
		LinkedList.Node b = second.getLast();
		b.next = last;
		
		LinkedList.Node aux = list.areOverlapping(second);
		System.out.println(aux == null ? "nothing" : aux.printData());
		
	}
	
	public static void testMedian() {
		LinkedList list = new LinkedList();
		list.add(6);
		list.add(17);
		list.add(2);
		list.add(2);
		list.add(3);
		LinkedList.Node first = list.getFirst();
		LinkedList.Node last = list.getLast();
		last.next = first;
		
		LinkedList.Node start = list.get(3);
		MiscProb test = new MiscProb();
		
		System.out.println(test.findMedianCircularList(start));
		
	}
	
	public static void testRemoveKth() {
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		MiscProb test = new MiscProb();
		list.printAll();
		test.removeKthToLast(list, 3);
		list.printAll();
	}
	
	public static void testReverse() {
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.printAll();
		MiscProb test = new MiscProb();
		test.reverseList(list);
		list.printAll();
	}
	
	public static void testPalindrome() {
		MiscProb test = new MiscProb();
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(test.isPalindrome(list));	
	}
	
	public static void testEvenOddMerge() {
		MiscProb test = new MiscProb();
		LinkedList list = new LinkedList();
		for (int i = 0; i < 11; i ++) {
			list.add(i);
		}
		list.printAll();
		test.evenOddMerge(list).printAll();
	}
	
	public static void testZippingList() {
		MiscProb test = new MiscProb();
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10 ; i++) {
			list.add(i);
		}
		list.printAll();
		test.zippList(list).printAll();
		
	}

	public static void testPostingsList() {
		PostingsList list = new PostingsList();
		PostingsList.Node a = list.add(5);
		PostingsList.Node b = list.add(12);
		PostingsList.Node c = list.add(25);
		PostingsList.Node d = list.add(30);
		PostingsList.Node e = list.add(100);
		PostingsList.Node f = list.add(37);
		
		list.printAll();
		
		a.setJump(c);
		b.setJump(d);
		c.setJump(e);
		d.setJump(f);
		e.setJump(a);
		f.setJump(b);
		
		list.printAll();
		PostingsList copy = list.copy();
		copy.printAll();
	}
	
	public static void main(String[] args) {
		//something();
		//testMedian();
		//testRemoveKth();
		//testReverse();
		//testPalindrome();
		//testEvenOddMerge();
		//testZippingList();
		testPostingsList();
	}

}
