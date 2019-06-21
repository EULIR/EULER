import java.util.stream.IntStream;

public class Project387 {
	public static long sum = 0;

	public static void main(String[] args) {
		boolean[] barr = new boolean[10000001];
		final long MAX = 100000000000000L;
		barr[0] = barr[1] = true;
		IntStream.range(0, barr.length).filter(i -> !barr[i]).flatMap(i -> IntStream.iterate(2 * i, j -> j < barr.length, j -> j + i)).forEach(j -> barr[j] = true);
		IntStream.range(1, 10).forEach(i -> harshadNumber(i, i, MAX));
		System.out.println(sum);
	}

	static void harshadNumber(long num, int digit, long max) {
		if (num > max) return;
		if (num % digit != 0) return;
		if (Library.isPrime(num / digit)) {
			for (int i = 1; i < 10; i += 2) {
				long n = num * 10 + i;
				if (n > max) return;
				if (Library.isPrime(n)) sum += n;
			}
		}
		IntStream.range(0, 10).forEach(i -> harshadNumber(num * 10 + i, digit + i, max));
	}
}
