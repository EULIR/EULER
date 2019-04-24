import java.util.stream.IntStream;

public class Project196 {
	public static void main(String[] args) {
		long s = sumTriple(5678027) + sumTriple(7208785);
		System.out.println(s);
	}

	private static PrimeRange pr;

	public static long sumTriple(int row) {
		long first = 1 + (long) row * (row - 1) / 2;
		pr = new PrimeRange(first - row * 2 + 3, first + row * 3 + 3);
		return IntStream.range(0, row).filter(x -> isTriple(first + x, x, row)).mapToLong(x -> first + x).sum();
	}

	public static boolean isTriple(long n, int x, int y) {
		return countNeighbors(n, x, y, -1, 0) >= 3;
	}

	public static int countNeighbors(long n, int x, int y, int from, int cnt) {
		if (x < 0 || x > y || !pr.isPrime(n)) return cnt;
		cnt++;
		for (int d = 0; d < 6 && cnt < 3; d++) {
			if (d != from) {
				int x2 = x, y2 = y;
				long n2 = n;
				if (d <= 2) {
					n2 += d - 1 - (y - 1);
					y2--;
					x2 += d - 1;
				} else {
					n2 += d - 4 + y;
					y2++;
					x2 += d - 4;
				}
				cnt = countNeighbors(n2, x2, y2, 5 - d, cnt);
			}
		}
		return cnt;
	}
}

class PrimeRange {
	private long first;
	private long last;
	private boolean[] sieve;

	public PrimeRange(long minp, long maxp) {
		int maxrt = (int) Math.sqrt(maxp);
		int size1 = (maxrt - 1) / 2;
		boolean[] sieve1 = new boolean[size1];
		for (int i = 0; i < size1; i++) sieve1[i] = true;
		int p = 3;
		do {
			for (int q = (p * 3 - 3) / 2; q < size1; q += p) {
				sieve1[q] = false;
			}
			p += 2;
			while (!sieve1[(p - 3) / 2]) p += 2;
		} while (p * p <= size1 + size1 + 1);
		first = minp | 1;
		last = (maxp - 1) | 1;
		int size = (int) (maxp - first) / 2 + 1;
		sieve = new boolean[size];
		IntStream.range(0, size).forEach(i -> sieve[i] = true);
		p = 3;
		do {
			long q1 = (first - 1) / p * p + p;
			if ((q1 & 1) == 0) q1 += p;
			if (q1 == p) q1 += p + p;
			for (int q = (int) (q1 - first) / 2; q < size; q += p) {
				sieve[q] = false;
			}
			p += 2;
			while (p <= size1 + size1 + 1 && !sieve1[(p - 3) / 2]) p += 2;
		} while (p <= size1 + size1 + 1);
	}

	public boolean isPrime(long p) {
		assert p >= first - 1 && p <= last + 1;
		if ((p & 1) == 0) return false;
		int ix = (int) (p - first) / 2;
		return sieve[ix];
	}
}
