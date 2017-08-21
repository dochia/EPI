package stacks;

public class StacksMain {
	
	public static void testMax() {
		MaxStack myStack = new MaxStack();
		
		myStack.push(12);
		myStack.push(15);
		System.out.println(myStack.max());
		myStack.push(30);
		myStack.push(17);
		System.out.println(myStack.max());
		System.out.println(myStack.pop());
		System.out.println(myStack.max());
		System.out.println(myStack.pop());
		System.out.println(myStack.max());
		
	}
	
	public static void testRPN() {
		RPN myRPN = new RPN("15,7,1,1,+,-,/,3,*,2,1,1,+,+,-");
		System.out.println(myRPN.compute());
	}
	
	public static void main(String[] args) {
		//testMax();
		testRPN();
	}

}
