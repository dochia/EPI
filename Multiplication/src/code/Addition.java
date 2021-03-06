package code;

public class Addition {

	BigInteger a, b;
	
	public Addition(String bigA, String bigB) {
		a = new BigInteger(bigA);
		b = new BigInteger(bigB);
	}
	
	public BigInteger compute() {
		BigInteger result = new BigInteger("0");
		result.digits.remove(0);
		int carry = 0;
		int i = a.digits.size()-1;
		int j = b.digits.size()-1;
		int aux;
		while (i >= 0 || j >= 0) {
			aux = carry;
			if (i >= 0) {
				aux += a.digits.get(i) - 48;
				i--;
			}
			if (j >= 0) {
				aux += b.digits.get(j) - 48;
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
