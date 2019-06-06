import java.util.ArrayList;
import java.util.HashMap;

public class Project233 {
	public static long totalFactors = 1;
	public static HashMap<Long, Long> harmlessFactors = new HashMap<>();
	public static ArrayList<Long> primes = new ArrayList<>();

	public static void sieve(int x) {
		long[] sieve = new long[x];
		long[] factors = new long[x];
		for (int i = 1; i < x; i++) {
			sieve[i] = (long) i;
			factors[i] = (long) i;
		}
		harmlessFactors.put(0L, 0L);
		harmlessFactors.put(1L, 1L);
		for (int i = 2; i < x; i++) {
			if (i == sieve[i]) {
				if (i % 4 == 1) {
					primes.add((long) i);
					for (int j = i; j < x; j = j + i) {
						factors[j] = factors[j] / i;
					}
				}
				for (int j = 2 * i; j < x; j = j + i) {
					sieve[j] = sieve[j] / i;
				}

			}
			if (factors[i] == i) {
				totalFactors = totalFactors + i;
				harmlessFactors.put((long) i, totalFactors);
			}
		}
		System.out.println(totalFactors);
	}

	public static void Permutuations(long x) {
		long limit = (long) Math.pow(10, 11);
		for (int i = 0; i < x; i++) {
			long pi = primes.get(i);
			if (Math.pow(pi, 6) > limit) {
				break;
			}
			for (int j = i + 1; j < x; j++) {
				long pj = primes.get(j);
				if ((Math.pow(pi, 3) * Math.pow(pj, 3)) > limit) {
					break;
				}
				for (int k = j + 1; k < x; k++) {
					long pk = primes.get(k);
					if ((Math.pow(pi, 3) * Math.pow(pj, 2) * pk) > limit) {
						break;
					}
					findSum(pi, pj, pk);
				}
			}
		}
	}

	public static void Permutuations2(long x) {
		long limit = (long) Math.pow(10, 11);
		for (int i = 0; i < x; i++) {
			long pi = primes.get(i);
			if (Math.pow(pi, 10) > limit) {
				break;
			}
			for (int j = i + 1; j < x; j++) {
				long pj = primes.get(j);
				if (Math.pow(pi, 7) * Math.pow(pj, 3) > limit) {
					break;
				}
				findsubsum((long) (Math.pow(pi, 7) * Math.pow(pj, 3)));
				findsubsum((long) (Math.pow(pj, 7) * Math.pow(pi, 3)));
			}
		}
	}

	public static void Permutuations3(long x) {
		long limit = (long) Math.pow(10, 11);
		for (int i = 0; i < x; i++) {
			long pi = primes.get(i);
			if (Math.pow(pi, 12) > limit) {
				break;
			}
			for (int j = i + 1; j < x; j++) {
				long pj = primes.get(j);
				if (Math.pow(pi, 10) * Math.pow(pj, 2) > limit) {
					break;
				}
				findsubsum((long) (Math.pow(pi, 10) * Math.pow(pj, 2)));
				findsubsum((long) (Math.pow(pj, 10) * Math.pow(pi, 2)));
			}
		}
	}


	public static void findSum(long i, long j, long k) {
		findsubsum(i * i * i * j * j * k);
		findsubsum(i * i * i * k * k * j);
		findsubsum(j * j * j * i * i * k);
		findsubsum(j * j * j * k * k * i);
		findsubsum(k * k * k * j * j * i);
		findsubsum(k * k * k * i * i * j);
	}

	public static long ans = 0;

	public static void findsubsum(long x) {
		long lim = (long) (Math.pow(10, 11) / x);
		for (long i = lim; i > 0; i--) {
			if (harmlessFactors.containsKey(i)) {

				ans = ans + (x * harmlessFactors.get(i));

				break;
			}
		}

	}

	public static void main(String[] args) {
		sieve(4800001);
		Permutuations(primes.size());
		Permutuations2(primes.size());
		Permutuations3(primes.size());
		System.out.println(ans);
	}
}