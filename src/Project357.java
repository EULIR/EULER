import java.util.ArrayList;
import java.util.stream.IntStream;

public class Project357 {
	public static void main(String[] args) {
		final int MAX = 100000000;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		long sum = primeList.stream().filter(aPrimeList -> aPrimeList % 4 != 1).filter(aPrimeList -> isValid(aPrimeList - 1)).mapToLong(aPrimeList -> aPrimeList - 1).sum();
		System.out.println(sum);
	}

	private static boolean isValid(int i) {
		return IntStream.rangeClosed(1, (int) Math.sqrt(i)).noneMatch(j -> i % j == 0 && !Library.isPrime(j + i / j));
	}
}
