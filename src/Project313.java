import java.util.ArrayList;

public class Project313 {
	public static void main(String[] args) {
		final int MAX = 1000000;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		long ans = primeList.stream().mapToLong(integer -> ((integer * integer + 13) / 2 - 2) / 6).sum();
		System.out.println(ans);
	}
}
