import java.util.stream.IntStream;

public class Project485 {
	static int[] divisors;

	public static void main(String[] args) {
		int a = 100000000;
		int b = 100000;
		divisors = new int[a + 1];
		IntStream.range(1, divisors.length).forEach(i -> IntStream.iterate(i, j -> j < divisors.length, j -> j + i).forEach(j -> divisors[j]++));
		long val = s(a, b);
		System.out.println(val);
	}

	static int[] m(int n, int k, int maxx, int maxplace) {
		int max = 0;
		int end = n + k - 1;
		if (maxplace > n)
			return divisors[end] >= maxx ? new int[]{divisors[end], end} : new int[]{maxx, maxplace};
		int mxplace = 0;
		int j = n;
		while (j <= end) {
			int d = divisors[j];
			if (d > max) {
				mxplace = j;
				max = d;
			}
			j++;
		}
		return new int[]{max, mxplace};
	}

	static long s(int u, int k) {
		long sum = 0;
		int max = 0;
		int maxplace = 0;
		int n = 1;
		while (n <= u - k + 1) {
			int[] m = m(n, k, max, maxplace);
			max = m[0];
			sum += max;
			maxplace = m[1];
			n++;
		}
		return sum;
	}
}