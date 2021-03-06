package code;

import java.lang.IllegalArgumentException;
import java.util.Vector;

public class BigInteger {
	private int sign = 1;
	Vector<Character> digits;
	boolean isEmpty = true;
	
	
	public BigInteger(String s) throws IllegalArgumentException  {
		digits = new Vector<Character>();
		if (s != "") {
			isEmpty =false;
			int start = 0;
			if (s.charAt(0) == '-') {
				sign = -1;
				start = 1;
			}
			
			for (int i = start; i < s.length(); i++) {
				Character c = s.charAt(i);
				if (c >= 48 && c <= 57) {
					digits.add(s.charAt(i));
				}
				else
					throw new IllegalArgumentException("The string contains illegal characters - different than digits");
			}
		}
		
	}
	
	public void print() {
		String result = "Big Integer is ";
		result += (sign == 1) ? "+" : "-";
		for (int i = 0; i < digits.size(); i++) {
			result += digits.get(i);
		}
		System.out.println(result);
	}
	
	public BigInteger multiplyByInt(int a) {
		BigInteger result = new BigInteger("");
		int carry = 0;
		int i = this.digits.size() - 1;
		while (i >= 0) {
			carry += (int)(digits.get(i) - 48) * a;
			result.digits.add(0, (char) (carry % 10 + 48));
			carry = carry / 10;
			i--;
		}
		while (carry != 0) {
			result.digits.add(0, (char)((carry % 10) + 48));
			carry = carry / 10;
		}
		return result;
	}
	
	public BigInteger multiply(BigInteger a) {
		BigInteger result = new BigInteger("");
		Vector<BigInteger> vResult = new Vector<BigInteger>();
		int power = 1;
		int aux;
		for (int i = a.digits.size() - 1; i >= 0; i--)
		{
			BigInteger helper = new BigInteger("");
			aux = (int)(a.digits.get(i) - 48);
			if (aux != 0){
					helper = this.multiplyByInt(aux);
				}
			for (int j = 1; j < power; j++) {
				helper.digits.addElement('0');
			}
			power++;
			vResult.add(helper);
		}
		for (int i = 0; i < vResult.size(); i++ ) {
			result = result.add(vResult.get(i));
		}
		return result;
	}
	
	public BigInteger add(BigInteger a) {
		BigInteger result = new BigInteger("");
		int carry = 0;
		int i = a.digits.size()-1;
		int j = this.digits.size()-1;
		int aux;
		while (i >= 0 || j >= 0) {
			aux = carry;
			if (i >= 0) {
				aux += a.digits.get(i) - 48;
				i--;
			}
			if (j >= 0) {
				aux += this.digits.get(j) - 48;
				j--;
			}
			if (aux > 10) {
				carry = aux / 10;
				aux = aux % 10;
			}
			result.digits.insertElementAt((char)(aux + 48), 0);
		}
		if (carry > 0)
			result.digits.insertElementAt((char)(carry + 48), 0);
		
		return result;
	}
	
}
