package stacks;

import java.util.Stack;

public class MaxStack {
	Stack<Integer> values;
	Stack<Integer> maxSt;
	
	public MaxStack() {
		values = new Stack<Integer>();
		maxSt =  new Stack<Integer>();
	}
	
	public void push(int value) {
		if (values.isEmpty()) {
			values.push(value);
			maxSt.push(value);
		}
		else {
			values.push(value);
			if (maxSt.peek() < value) {
				maxSt.push(value);
			}
		}
	}
	
	public int pop() {
		int result = values.peek();
		values.pop();
		if (result == maxSt.peek()) {
			maxSt.pop();
		}
		return result;
	}

	public int max() {
		return maxSt.peek();
	}
}
