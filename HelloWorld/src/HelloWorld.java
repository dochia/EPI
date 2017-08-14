import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

	private static final Map<Character, Integer> digits;
	private static final Map<Integer, Character> letters;
	static {
		digits = new HashMap<Character, Integer>();
		letters = new HashMap<Integer, Character>();
		for (int i = 0; i < 10; i++) {
			digits.put((char)(48 + i), i);
			letters.put(i, (char)(i + 48));
		}
		digits.put('A', 10);
		digits.put('B', 11);
		digits.put('C', 12);
		digits.put('D', 13);
		digits.put('E', 14);
		digits.put('F', 15);
		
		letters.put(10, 'A');
		letters.put(11, 'B');
		letters.put(12, 'C');
		letters.put(13, 'D');
		letters.put(14, 'E');
		letters.put(15, 'F');
	}
	
	static String convertIntegerToBase10(String s, int base) {
		int power = 1, value = 0;
		char dig ;
		for (int i = s.length() - 1; i >= 0; i--) {
			dig = s.charAt(i);
			value += power * digits.get(dig);
			power *= base;
		}
		return Integer.toString(value);
	}
	
	static String convertIntegerFromBase10(String s, int base)
	{
		String result = "";
		int value = Integer.parseInt(s);
		while (value > 0) {
			result = letters.get(value % base) + result;
			value /= base;
		}
		return result;
	}
	static String convertIntegerToBase(String s, int base, int target) {
		String result = "";
		result = convertIntegerToBase10(s, base);
		if (target == 10) {
			return result;
		}
		else {
			
			result = convertIntegerFromBase10(result, target);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(convertIntegerToBase("2342123123", 8, 12));
		System.out.println(convertIntegerFromBase10("158", 8));
		System.out.println("Hello world!");
	}
}
