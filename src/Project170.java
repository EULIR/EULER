import java.util.Arrays;
import java.util.stream.Collectors;

public class Project170 {
	public static void main(final String[] args) {
		for (long i = 9876543210L; i >= 9786105234L; i--)
			if (formsPanDigital(i)) {
				long j = 0, p = 1;
				while (j < 10) {
					long a = i % p;
					long b = i / p;
					for (int k = 1; k < Math.min(a, b) / 2; k++)
						if ((a % k == 0) && (b % k == 0) && (formsPanDigital(a / k, b / k, k))) {
							System.out.println(i);
							System.exit(0);
						}
					j++;
					p = (long) Math.pow(10, j);
				}
			}
	}

	private static boolean formsPanDigital(final long... numbers) {
		String s = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining());
		final char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return Arrays.equals(arr, "0123456789".toCharArray());
	}
}
