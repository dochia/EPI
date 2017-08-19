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
	
	public LinkedList.Node reverseList(LinkedList.Node head) {
		LinkedList.Node newHead =  head;
		LinkedList.Node current = (newHead != null) ? newHead.next : null;
		LinkedList.Node p = null;
		
		while (current != null) {
			p = current.next;
			current.next = newHead;
			newHead = current;
			current = p;
		}
		head.next = null;
		return newHead;
	}
	
	public void reverseList(LinkedList list) {
		list.setHead(this.reverseList(list.head));
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
	
	public LinkedList evenOddMerge(LinkedList list) {
		LinkedList.Node end = list.head;
		LinkedList.Node  p = list.head, prev = list.head;
		// find last element of list
		while (end != null && end.next != null) {
			end = end.next;
		}
		LinkedList.Node oldEnd = end;
		int i = 0;
		while (p != null && p != oldEnd) {
			if (i % 2 == 0) {
				prev = p;
			}
			else {
				if (p != end)
					{
						prev.next = p.next;
					}
				end.next = p;
				p.next = null;
				p = prev;
				end = end.next;
			}
			i++;
			p = p.next;
		}
		return list;
	}
	
	public LinkedList.Node findMiddle(LinkedList list){
		LinkedList.Node slow = list.head;
		LinkedList.Node fast = list.head;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}
	
	public LinkedList zippList(LinkedList list) {
		// find the half of the list, memorize it in slow
		LinkedList.Node slow = list.head;
		LinkedList.Node fast = list.head;
		LinkedList.Node prev = null;
		while (fast != null && fast.next != null) {
			fast = fast.next;
				fast = fast.next;
				prev = slow;
				slow = slow.next;
		}
		// reverse second half
		slow = this.reverseList(slow);
		prev.next = null;
		
		// zipp the modified list
		LinkedList.Node currentFirst = list.head, currentSecond = slow, nextFirst = null, nextSecond;
		while (currentSecond != null) {
 			nextSecond = currentSecond.next;
			if (currentFirst != null) {
				nextFirst = currentFirst.next;
				currentFirst.next = currentSecond;
			}
			currentSecond.next = nextFirst != null ? nextFirst : nextSecond;
			currentFirst = nextFirst;
			currentSecond = nextSecond;
			}
		return list;
	}

}
