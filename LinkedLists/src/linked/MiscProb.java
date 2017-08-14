package linked;

public class MiscProb {
	
	public int findMedianCircularList(LinkedList.Node start){
		LinkedList.Node p = start.next;
		int length = 1;
		while (p != start) {
			length++;
			p = p.next;
		}
		while (p.data < p.next.data) {
			p = p.next;
		}
		p = p.next;
		// p contains the head of the list at this point. 
		int i = 0;
		while (i < Math.round(length / 2)) {
			i++;
			p = p.next;
		}
		if (length % 2 == 1)
			return p.data;
		else
			return (p.data + p.next.data)/2;
	}
	
	private LinkedList.Node move(LinkedList.Node node, int k){
		
		while (node != null && k > 0) {
			node = node.next;
			k--;
		}
		return node;
	}
	
	public void removeKthToLast(LinkedList list, int k) {
		LinkedList.Node slow = list.getFirst();
		LinkedList.Node fast = move(slow, k);
		LinkedList.Node before = null;
		
		while (fast != null) {
			before = slow;
			slow = slow.next;
			fast = fast.next;
		}
		before.next = slow.next;
	}
	
	public void reverseList(LinkedList list) {
		LinkedList.Node newHead = list.getFirst();
		LinkedList.Node oldHead = list.get(1);
		LinkedList.Node current = null;
		
		while (oldHead != null) {
			current = oldHead.next;
			oldHead.next = newHead;
			newHead = oldHead;
			oldHead = current;
		}
		list.setHead(newHead);
	}
	
	public boolean isPalindrome(LinkedList list) {
		LinkedList reverse = list.copy();
		this.reverseList(reverse);
		
		LinkedList.Node p = list.getFirst();
		LinkedList.Node q = reverse.getFirst();
		while (p != null && q != null && p.data == q.data) {
			p = p.next;
			q = q.next;
		}
		return p == null;
	}

}
