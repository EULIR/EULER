import java.math.BigInteger;
import java.util.ArrayList;

public class Project123 {
	public static void main(String[] args) {
		final int MAX = 300000;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		//System.out.println(primeList.size());
		for (int i = 0; i < primeList.size(); i++) {
			int n = i + 1;
			BigInteger pn = new BigInteger(String.valueOf(primeList.get(i)));
			BigInteger times = pn.multiply(pn);
			BigInteger a = pn.subtract(BigInteger.ONE).pow(n).mod(times);
			BigInteger b = pn.add(BigInteger.ONE).pow(n).mod(times);
			BigInteger r = a.add(b).mod(times);
			if (r.compareTo(BigInteger.valueOf(10000000000L)) > 0) {
				System.out.println(n);
				System.exit(0);
			}
		}
	}
}
