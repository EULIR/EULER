import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Project248 {
	public static void main(String[] args) {
		final long N = 6227020800L;
		ArrayList<Long> divisors = divisors(N);
		HashMap<Long, ArrayList<Long>> numbers = new HashMap<>();
		numbers.put(1L, new ArrayList<>());
		numbers.get(1L).add(1L);
		for (Long d : divisors)
			if (Library.isPrime(d + 1)) {
				HashMap<Long, ArrayList<Long>> temp = new HashMap<>();
				long a = 1;
				do {
					for (Long n : numbers.keySet())
						if ((N / n) % (a * d) == 0) {
							if (!temp.containsKey(a * d * n))
								temp.put(a * d * n, new ArrayList<>());
							ArrayList<Long> pointer = temp.get(a * d * n);
							for (Long m : numbers.get(n))
								pointer.add(a * (d + 1) * m);
						}
					a *= d + 1;
				} while (N % a * d == 0);
				temp.keySet().forEach(k -> {
					if (!numbers.containsKey(k)) numbers.put(k, new ArrayList<>());
					numbers.get(k).addAll(temp.get(k));
				});
			}
		ArrayList<Long> list = numbers.get(N);
		Collections.sort(list);
		System.out.println(list.get(150000 - 1));
	}

	public static ArrayList<Long> divisors(long n) {
		ArrayList<Long> result = new ArrayList<>();
		result.add(1L);
		for (long i = 2; n != 1; i++) {
			if (i * i > n) i = n;
			if (n % i == 0) {
				ArrayList<Long> temp = new ArrayList<>();
				long q = i;
				do {
					for (Long d : result) temp.add(q * d);
					n /= i;
					q *= i;
				} while (n % i == 0);
				result.addAll(temp);
			}
		}
		Collections.sort(result);
		Collections.reverse(result);
		return result;
	}
}
