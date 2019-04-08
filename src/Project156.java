import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Project156 {
	public static void main(String[] args) {
		long total = IntStream.rangeClosed(1, 9).mapToLong(Project156::getTotal).sum();
		System.out.println(total);
	}

	public static int count(int num, int digit) {
		int count = 0;
		while (num > 0) {
			int d = num % 10;
			num = num / 10;
			if (d == digit)
				count++;
		}
		return count;
	}

	public static long getTotal(int dig) {
		final int NUM = 10000;
		final int DIGIT = 7;
		final int MAX = 10000000;
		int[] f = new int[MAX];
		Map<Integer, Set<Integer>>[] g = new Map[DIGIT + 1];
		IntStream.range(1, MAX).forEach(i -> f[i] = f[i - 1] + count(i, dig));
		for (int i = 0; i <= DIGIT; i++) {
			g[i] = new HashMap();
			for (int j = 0; j < NUM; j++) {
				Integer value = (j + 1) * i + f[j] - j;
				Set<Integer> set = g[i].get(value);
				if (set == null) set = new HashSet();
				set.add(j);
				g[i].put(value, set);
			}
		}
		long total = IntStream.range(0, NUM).filter(i -> f[i] == i).asLongStream().sum();
		for (int i = 1; i < MAX; i++) {
			long gValue = (long) NUM * (long) i - (long) NUM * (long) f[i - 1] - (long) i * (long) f[NUM - 1];
			int x = f[i] - f[i - 1];
			if (Math.abs(gValue) < 10 * NUM) {
				Set<Integer> set = g[x].get((int) gValue);
				if (set != null)
					for (Integer b : set) {
						long num = (long) NUM * (long) i + (long) b;
						total += num;
					}
			}
		}
		return total;
	}
}
