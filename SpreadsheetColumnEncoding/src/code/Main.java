package code;

public class Main {

	public static void main(String[] args) {
		SCencoding enc = new SCencoding();
		System.out.println(enc.convert("B"));
		System.out.println(enc.convert("A{Z"));
		System.out.println(enc.convert("AAA"));
		
	}

}
