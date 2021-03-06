package linked;

public class LinkedList {
	
	Node head = null;
	
	public class Node{
		int data;
		Node next = null;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
		
		public String printData() {
			String s = "The node contains " + this.data + ".";
			 System.out.println(s);
			 return s;
			}
		
		public void deleteNode() {
			this.next = null;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}
	}
	
	public boolean add(int value) {
		Node n = new Node(value);
		if (this.head ==  null) {
			this.head = n;
		}
		else {
			Node p = head;
			while (p.next != null) {
				p = p.next;
			}
			p.next = n;
		}
		return true;
	}
	
	public boolean addFirst(int value) {
		Node p = new Node(value);
		p.next = this.head;
		this.head = p;
		return true;
	}
	
	public String printAll() {
		Node cycleStarts = this.findCycle();
		boolean hasCycle = (cycleStarts != null);
		int passes = 0;
		Node p = this.head;
		String s = "The list contains the following values: ";
		while (p != null) {
			s += p.data;
			p = p.next;
			if (hasCycle && p == cycleStarts) {
				passes++;
			}
			if (passes == 2) {
				s += ".";
				break;
			}
			
			if (p != null){
				s += "->";
			}
			else {
				s += ".";
			}			
		}
		System.out.println(s);
		return s;
	}
	
	public Node getFirst() {
		return this.head;
	}
	
	public Node get(int index) {
		Node p = this.head;
		while (p!= null && index > 0) {
			p = p.next;
			index--;
		}
		return (index > 0) ? null : p;
	}
	public Node getLast() {
		Node p = this.head;
		while (p != null && p.next != null) {
			p = p.next;
		}
		return p;
	}
	
	public Node removeFirst() {
		Node p = this.head;
		if (p != null)
			this.head = p.next;
		return p;
	}
	
	public boolean isCyclic() {
		return this.findCycle() != null;
	}
	
	public Node findCycle() {
		if (this.head == null)
			return null;
		Node p = this.head;
		if (p.next != null) {
			Node q = p;
			while (p  != null && q != null && q.next != null) {
				p = p.next;
				q = q.next.next;
				if (p == q && q != null)
					break;
			}
			if (p == q && q != null) {
				p = head;
				while (p != q) {
					p = p.next;
					q = q.next;
				}
				return p;
			}
			return null;
		}
		return null;
	}
	
	public int size() {
		Node cycleStarts = this.findCycle();
		boolean hasCycles = cycleStarts != null;
		int passes = 0;
		Node p = this.head;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
			if (hasCycles && p == cycleStarts) {
				passes++;
			}
			if (passes == 2) {
				break;
			}
		}
		return len;
	}
	
	public Node areOverlappingNoCycles(LinkedList list) {
		int len = this.size();
		int listLen = list.size();
		Node p = this.head;
		Node q = list.head;
		int diff = 0;
		if (len > listLen) {
			diff = len - listLen;
		}
		if (listLen > len) {
			p = list.head;
			q = this.head;
			diff = listLen - len;
		}
		
		while (diff > 0) {
			p = p.next;
			diff--;
		}
		while (p != null && p != q ) {
			p = p.next;
			q = q.next;
		}
		return (p != q) ? null : p;
	}
	
	public Node areOverlapping(LinkedList list) {
		Node headCycle1 = this.findCycle();
		Node headCycle2 = list.findCycle();
		
		boolean hasCycle1 = headCycle1 != null;
		boolean hasCycle2 = headCycle2 != null;
		
		if (hasCycle1 != hasCycle2)
			return null;
		if (hasCycle1 == false)
			return this.areOverlappingNoCycles(list);
		Node p = headCycle1.next;

		while (p != headCycle2 && p!= headCycle1) {
			p = p.next;
		}
		return (p != headCycle2) ? null : p;
	}
	public boolean remove(Node node) {
		if (node.next == null)
			return false;
		node.data = node.next.data;
		node.next = node.next.next;
		node.deleteNode();
		return true;
	}
	//
	public void addListFirst(Node newHead) {
		if (this.head == null) {
			this.head = newHead;
			}
		Node p = this.head;
		Node q = newHead;
		while (q != null && q.next != null) {
			q = q.next;
		}
		q.next = p;
		this.head = newHead;
	}
	
	public void setHead(Node newHead) {
		this.head = newHead;
	}
	public LinkedList copy() {
		LinkedList copy = new LinkedList();
		Node p = this.getFirst();
		while (p != null) {
			copy.add(p.data);
			p = p.next;
		}
		return copy;
	}
	
}
