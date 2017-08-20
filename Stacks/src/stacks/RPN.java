package stacks;

import java.util.Stack;


public class RPN {
	
	private String expression;
	
	public RPN(String s) {
		expression = s;
	}

	
	
	
	public int compute() {
		Stack<Integer> result = new Stack<Integer>();
		int carry = 0;
		boolean addedOperation = false;
		boolean isNegative = false;
		char c;
		for (int i = 0; i < expression.length(); i++) {
			c = expression.charAt(i);
			if (c >= 48 && c <= 57){
				carry *= 10;
				carry += (int)c - 48;
				addedOperation = false;
				continue;
			}
			if (c == ',' && !addedOperation) {
				result.push(isNegative? 0 - carry : carry);
				carry = 0;
				continue;
			}
			
			
			if (c == '+' || c == '*' || c == '/')
			{
				int right  = result.pop();
				int left = result.pop();
				switch (c) {
					case '+': { carry = left + right; break; }
					case '*': { carry = left * right; break; }
					case '/': { carry = left / right; break; }
				}
				result.push(carry);
				carry = 0;
				addedOperation = true;
				continue;
			}
			if (c == '-') {
				if ((i == expression.length() - 1) || (expression.charAt(i+1) == ',' )){
					int right = result.pop();
					int left = result.pop();
					carry = left - right; 
					result.push(carry);
					carry = 0;
					addedOperation = true;
					isNegative = false;
				}
				else {
					isNegative = true;
				}
			}
		}
		return result.pop();
	}
}
