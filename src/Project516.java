import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Project516 {
	static long ans = 0L;

	static void dfs(long pos, int index, ArrayList<Long> prime) {
		ans += pos;
		ans &= 4294967295L;
		for (int i = index; i < prime.size(); i++) {
			if ((double) pos * prime.get(i) > 10000000000000L || pos * prime.get(i) > 1000000000000L)
				break;
			if (i <= 2)
				dfs(pos * prime.get(i), i, prime);
			else dfs(pos * prime.get(i), i + 1, prime);
		}
	}

	public static void main(String[] args) {
		long multip = 1;
		ArrayList<Long> prime = new ArrayList<>();
		for (int i = 0; i <= 40; i++) {
			long a = multip;
			multip *= 2;
			while (a <= 1000000000000L) {
				long b = a;
				a *= 3;
				while (b <= 1000000000000L) {
					if (BigInteger.valueOf(b + 1).isProbablePrime(30))
						prime.add(b + 1);
					b *= 5;
				}
			}
		}
		Collections.sort(prime);
		dfs(1L, 0, prime);
		System.out.println(ans);
	}
}