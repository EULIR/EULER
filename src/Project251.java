import java.util.Vector;
import java.util.stream.IntStream;

public class Project251 {
	private static int[] leastFactor = null;

	public static void main(String[] args) {
		final int MAX = 110000000;
		final int max = (MAX * 4 / 9);
		initializeFactors();
		int ans = 1;
		ans += IntStream.iterate(5, a -> a <= max, a -> a + 3).map(a -> triplets((a + 1) / 3, (8 * a - 1) / 3, MAX - a)).sum();
		System.out.println(ans);
	}

	private static void initializeFactors() {
		leastFactor = new int[130370368];
		leastFactor[1] = Integer.MAX_VALUE;
		int i = 2;
		for (; i * i < leastFactor.length; i++)
			if (leastFactor[i] == 0) {
				leastFactor[i] = i;
				for (int j = i * i; j < leastFactor.length; j += i)
					if (leastFactor[j] == 0)
						leastFactor[j] = i;
			}
		for (; i < leastFactor.length; i++)
			if (leastFactor[i] == 0)
				leastFactor[i] = i;
	}

	public static int triplets(int b, int c, int sum) {
		int count = 0;
		int bMultiplicand = 1;
		int cRemainder = 1;
		while (c != 1) {
			int cf = leastFactor[c];
			if (cf == leastFactor[c / cf]) {
				bMultiplicand *= cf;
				c /= (cf * cf);
			} else {
				cRemainder *= cf;
				c /= cf;
			}
		}
		final long[] bDivisors = getDivisors(b, bMultiplicand);
		for (long bDivisor : bDivisors) {
			long cMultiplicand = bDivisors[0] / bDivisor;
			if ((sum - bDivisor >= 0) && (sum - bDivisor) / cMultiplicand / cMultiplicand / cRemainder > 0)
				count++;
		}
		return count;
	}

	private static long[] getDivisors(int i, int j) {
		Vector<Integer> bases = new Vector<>();
		Vector<Integer> powers = new Vector<>();
		int combinations = 1;
		if (leastFactor[i] < leastFactor[j]) {
			bases.add(leastFactor[i]);
			i /= leastFactor[i];
		} else {
			bases.add(leastFactor[j]);
			j /= leastFactor[j];
		}
		int count = 1;
		while (i != 1 || j != 1) {
			int t = leastFactor[i] < leastFactor[j] ? i : j;
			if (leastFactor[t] != bases.lastElement()) {
				combinations *= (count + 1);
				powers.add(count);
				bases.add(leastFactor[t]);
				count = 0;
			}
			if (leastFactor[i] < leastFactor[j])
				i /= leastFactor[t];
			else j /= leastFactor[t];
			count++;
		}
		combinations *= (count + 1);
		powers.add(count);
		long[] divisors = new long[combinations];
		for (int k = 0; k < combinations; k++) {
			long divisor = 1;
			int m = combinations - k - 1;
			for (int n = bases.size() - 1; n >= 0; n--) {
				int base = bases.get(n);
				int power = m % (powers.get(n) + 1);
				m /= (powers.get(n) + 1);
				divisor *= IntStream.range(0, power).mapToLong(p -> base).reduce(1, (a, b) -> a * b);
			}
			divisors[k] = divisor;
		}
		return divisors;
	}
}
