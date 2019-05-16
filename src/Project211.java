import java.util.Arrays;
import java.util.stream.IntStream;

public class Project211 {
	public static void main(String[] args) {
		int n = 64000000;
		long[] sum = new long[n];
		Arrays.fill(sum, 1);
		sum[0] = 0;
		for (int i = 2; i < n; i++)
			if (sum[i] == 1) {
				long p2 = (long) i * i;
				for (int j = i; j < n; j += i) {
					long s = 1;
					long powp = i;
					long pow = p2;
					while (j % powp == 0) {
						s += pow;
						powp *= i;
						pow *= p2;
					}
					sum[j] *= s;
				}
			}
		long s = IntStream.range(1, n).filter(i -> Library.isSquare(sum[i])).asLongStream().sum();
		System.out.println(s);
	}
}
