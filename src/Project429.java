import java.math.BigInteger;

public class Project429 {
	public static void main(String[] args) {
		final int MAX = 100000000;
		boolean[] prime = new boolean[MAX + 5];
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		BigInteger ans = BigInteger.ONE;
		for (int i = 2; i <= MAX; i++) {
			if (!prime[i]) {
				long power = i;
				long exponent = 0;
				while (power <= MAX) {
					exponent += MAX / power;
					power *= i;
				}
				BigInteger temp = new BigInteger(String.valueOf(i));
				temp = temp.modPow(BigInteger.valueOf(2 * exponent), BigInteger.valueOf(1000000009));
				ans = ans.multiply(temp.add(BigInteger.ONE));
				ans = ans.mod(BigInteger.valueOf(1000000009));
			}
		}
		System.out.println(ans);
	}
}
