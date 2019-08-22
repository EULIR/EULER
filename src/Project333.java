import java.util.ArrayList;
import java.util.stream.IntStream;

public class Project333 {
	static int size = 1000000;
	static short[] count = new short[size];
	static int[][] powers = new int[21][14];

	public static void main(String[] args) {
		for (int e2 = 0, p2 = 1; e2 < powers.length; e2++, p2 *= 2)
			for (int e3 = 0, p3 = 1; e3 < powers[e2].length; e3++, p3 *= 3)
				powers[e2][e3] = p2 * p3;
		IntStream.range(0, powers[0].length).forEach(e3 -> search(0, e3, powers[0][e3]));
		boolean[] prime = new boolean[size + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < size; i++)
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i; j < size; j += i)
					prime[j] = true;
			}
		long sum = primeList.stream().filter(aPrimeList -> aPrimeList < size).filter(aPrimeList -> count[aPrimeList] == 1).mapToLong(aPrimeList -> aPrimeList).sum();
		System.out.println(sum);
	}

	static void search(int e2, int e3, int value) {
		if (value >= size || value < 0) return;
		count[value]++;
		for (int i = 0; i < e3; i++)
			for (int j = e2 + 1; value + powers[j][i] < size; j++)
				search(j, i, value + powers[j][i]);
	}
}
