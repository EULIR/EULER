import java.util.ArrayList;
import java.util.stream.LongStream;

public class Project234 {
	public static void main(String[] args) {
		long max = 999966663333L;
		final int MAX = 1000003;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				primes.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		long ans = 0;
		for (int i = 0; i < primes.size() - 1; i++) {
			long primeA = primes.get(i);
			long primeB = primes.get(i + 1);
			long squaredA = primeA * primeA;
			long squaredB = primeB * primeB;
			if (squaredB <= max) {
				long firstA = primeA * (squaredA / primeA) + primeA;
				long numAs = (squaredB - firstA - 1) / primeA + 1;
				long firstB = primeB * (squaredA / primeB) + primeB;
				long numBs = (squaredB - firstB - 1) / primeB + 1;
				long firstAB = (primeA * primeB) * (squaredA / (primeA * primeB)) + primeA * primeB;
				long numABs = (squaredB - firstAB - 1) / (primeA * primeB) + 1;
				long aSum = (firstA + firstA + primeA * (numAs - 1)) * numAs / 2;
				long bSum = (firstB + firstB + primeB * (numBs - 1)) * numBs / 2;
				long abSum = (firstAB + firstAB + primeA * primeB * (numABs - 1)) * numABs / 2;
				ans += aSum + bSum - 2 * abSum;
			} else {
				ans += LongStream
						.iterate(squaredA + 1, j -> j < squaredB && j <= max, j -> j + 1)
						.filter(j -> j % primeA == 0 && j % primeB != 0 || j % primeA != 0 && j % primeB == 0)
						.sum();
				break;
			}
		}
		System.out.println(ans);
	}
}
