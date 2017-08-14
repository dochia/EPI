package code;


public class MultiplicationMain {

	public static void main(String[] args) {
		try {
			//BigInteger m = new BigInteger("302");
			//m.multiply(new BigInteger("100")).print();
			
			BigInteger test = new BigInteger("542");
			test.multiply(new BigInteger("3")).print();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
