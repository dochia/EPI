package linked;

public class PostingsList {
	class Node {
		private int data;
		private Node next, jump;
		
		public Node(int value) {
			data = value;
			next = null;
			jump = null;
		}
		public void setNext(Node newNext) {
			next = newNext;
		}
		public void setJump(Node newJump) {
			jump = newJump;
		}
		public void setData(int value) {
			data = value;
		}
	}
	
	Node head = null;
	
	public void setHead (Node newHead) {
		head = newHead;
	}
	
	public Node add(int value, Node jumpTo) {
		Node n = add(value);
		n.jump = jumpTo;
		return n;
	}
	
	public Node getLast() {
		Node p = this.head;
		while (p != null && p.next != null) {
			p = p.next;
		}
		return p;
	}
	
	public Node add(int value) {
		Node n = new Node(value);
		if (this.head == null) {
			this.head = n;
		}
		else {
			Node p = this.head;
			while (p != null && p.next != null) {
				p = p.next; 
			}
			p.next = n;
		}
		return n;
	}
	
	public Node get(int index) {
		Node p = this.head;
		while (index > 0 && p != null) {
			index--;
			p = p.next;
		}
		return p;
	}
	
	public String printAll() {
		Node p = this.head;
		String result = "The postings list contains the following items: \n";
		while (p != null) {
			result += p.data + "(jump to " + (p.jump != null ? p.jump.data : "null") + ") -> " + (p.next != null ? p.next.data : "null") + "\n" ;
			p = p.next;
		}
		System.out.println(result);
		return result;
	}
	
	public PostingsList copy() {
		PostingsList result = new PostingsList();
		Node p = this.head;
		Node aux;
		while (p != null) {
			aux = new Node(p.data);
			aux.next = p.next;
			p.next = aux;
			p = aux.next;
		}
		p = this.head;
		while (p != null) {
			aux = p.jump;
			p.next.jump = aux.next;
			p = p.next.next;
		}
		
		p = this.head;
		result.setHead(p.next);
		while (p != null && p.next != null) {
			aux = p.next;
		
			p.next = aux.next;
			aux.next = (p.next != null ? p.next.next : null);
			p = p.next;
		}

		return result;
	}
}
