import java.util.ArrayList;

public class Project134 {
	public static long concat(int primeOne, int primeTwo) {
		long base = smallestTenK(primeOne);
		long result = base + primeOne;
		while (result % primeTwo != 0)
			result += base;
		return result;
	}

	public static long smallestTenK(long a) {
		long base = 1;
		while (base < a)
			base *= 10;
		return base;
	}

	//too time-consuming
	public static void main(String[] args) {
		final int MAX = 1010000;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		long sum = 0;
		for (int i = 0; i < primeList.size(); i++) {
			int primeOne = primeList.get(i);
			if (primeOne >= 5 && primeOne <= 1000000) {
				int primeTwo = primeList.get(i + 1);
				sum += concat(primeOne, primeTwo);
			}
		}
		System.out.println(sum);
	}
}
