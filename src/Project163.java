import java.util.stream.IntStream;

public class Project163 {

	public static void main(String[] args) {
		long ans = 0;
		int n = 36;
		for (int i = 1; i < n; i++)
			for (int j = 1; j <= i; j++)
				ans += count(i, j, n);
		ans *= 2;
		ans += IntStream.rangeClosed(1, n).mapToLong(i -> count(n, i, n)).sum();
		ans /= 2;
		ans += IntStream.rangeClosed(1, n).mapToLong(i -> sum(n + 1 - i)).sum();
		ans += IntStream.rangeClosed(1, n / 2).mapToLong(i -> sum(n - (2 * i - 1))).sum();
		System.out.println(ans);
	}

	private static long count(int x, int y, int n) {
		int r = Math.max(0, 2 * n - x - y);
		int l = Math.max(0, x - y);
		if ((x + y) % 2 == 0)
			return up(y, r) + up(y, l);
		else
			return down(y, r) + down(y, l);
	}

	private static long down(int y, int x) {
		long sum = 0;
		sum += 3 * Math.min((y + 1) / 2, (x + 3) / 4);
		sum += 6 * Math.min((3 * y + 1) / 2, (x + 1) / 2);
		sum += 6 * Math.min((y + 1) / 2, (x + 1) / 2);
		sum += 2 * Math.min((3 * y - 1) / 2, (x + 1) * 3 / 2 - 1);
		return sum;
	}

	private static long up(int y, int x) {
		long sum = 0;
		sum += 6 * y;
		sum += 6 * (3 * y / 2);
		sum += 3 * y;
		sum += 6 * (y / 2);
		sum += 3 * Math.min(y / 2, x / 4);
		sum += 3 * Math.min(y / 2, (x + 2) / 4);
		sum += 6 * Math.min(3 * y / 2, x / 2);
		sum += 6 * Math.min(y / 2, x / 2);
		sum += 2 * Math.min(y * 3 / 2, x * 3 / 2);
		sum += 2 * Math.min(y * 3 / 2 - 1, x * 3 / 2 + 1);
		return sum;
	}

	public static long sum(long n) {
		if (n <= 0) return 0;
		return n * (n + 1) / 2;
	}
}
