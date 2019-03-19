import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Project500 {
	public static void main(String[] args) {
		final int MAX = 10000000;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		int len = primeList.size();
		double[] nd = Arrays.stream(IntStream.range(0, len).mapToDouble(i -> Math.log(primeList.get(i))).toArray(), 0, len).toArray();
		int[] primes = new int[len];
		int number[] = new int[10];
		int num = 0;
		while (num < 500500) {
			double d = 10000D;
			int p = 0;
			for (int i = 0; i < len; i++) {
				if (nd[i] < d) {
					d = nd[i];
					p = i;
				}
				if (primes[i] == 0)
					break;
				else i = number[primes[i]];
			}
			if (p > number[++primes[p]])
				number[primes[p]] = p;
			nd[p] *= 2;
			num++;
		}
		long ans = 1;
		for (int i = 0; i < len; i++) {
			if (primes[i] > 0) {
				long t1 = (long) primeList.get(i);
				long t2 = 1;
				for (int j = 0; j < primes[i]; j++) {
					t2 *= t1;
					t2 %= 500500507L;
					t1 *= t1;
					t1 %= 500500507L;
				}
				ans *= t2;
				ans %= 500500507L;
			} else break;
		}
		System.out.println(ans);
	}
}
