import java.util.stream.IntStream;

public class Project231 {
	public static void main(String[] args) {
		int n = 20000000;
		int r = 15000000;
		long sum = IntStream.range(1, 20000000).filter(Library::isPrime).mapToLong(i -> i * (fact(n, i) - fact(r, i) - fact(n - r, i))).sum();
		System.out.println(sum);
	}

	public static int fact(long n, int p) {
		int tot = 0;
		long c = p;
		while (n / c >= 1) {
			tot += n / c;
			c *= p;
		}
		return tot;
	}
}
