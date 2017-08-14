package code;

public class SCencoding {
	
	public int convert(String s) {
		int result = 0;
		int power = 1;
		int value = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			value = (int)s.charAt(i);
			if (value >= 65 && value <= 90) {
				result += power * ((int)s.charAt(i) - 64);
				power *= 26;
			}
		}
		return result;
	}
}
