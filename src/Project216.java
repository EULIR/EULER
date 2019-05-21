import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Project216 {
	public static void main(String[] args) {
		final int maxN = 50000000;
		List<Long> candidates = LongStream.rangeClosed(0, maxN).mapToObj(i -> 2L * i * i - 1L).collect(Collectors.toList());
		for (int i = 2, size = candidates.size(); i < size; i++) {
			long p = candidates.get(i);
			if (p < 2L || p > size * 2) continue;
			int j = i + (int) p;
			func(candidates, size, p, j);
			j = (int) p - i;
			func(candidates, size, p, j);
		}
		int ans = 0;
		for (int i = 2, size = candidates.size(); i < size; i++)
			if (candidates.get(i) == 2L * i * i - 1L)
				ans += 1;
		System.out.println(ans);
	}

	private static void func(List<Long> candidates, int size, long p, int j) {
		while (j < size) {
			long candidate = candidates.get(j);
			while (candidate % p == 0)
				candidate /= p;
			candidates.set(j, candidate);
			j += (int) p;
		}
	}
}