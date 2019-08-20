import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Project343 {
	static long[] factor(long[] input) {
		long[] output = new long[input.length];
		IntStream.range(1, input.length).forEach(i -> {
			long p = input[i];
			if (p > 1) LongStream.iterate(i, j -> j < input.length, j -> j + p).mapToInt(j -> (int) j).forEach(j2 -> {
				output[j2] = Math.max(output[j2], p);
				input[j2] /= p;
				while (input[j2] % p == 0) input[j2] /= p;
			});
		});
		return output;
	}

	public static void main(String[] args) {
		final int MAX = 2000000;
		long[] linear = new long[MAX + 1];
		long[] quadr = new long[MAX + 1];
		for (int i = 1; i <= MAX; i++) {
			linear[i] = i + 1;
			quadr[i] = i * (long) i - i + 1;
		}
		linear = factor(linear);
		quadr = factor(quadr);
		long s = 0;
		for (int i = 1; i <= MAX; i++) {
			long p = Library.max(linear[i], quadr[i]);
			s += p - 1;
		}
		System.out.println(s);
	}
}