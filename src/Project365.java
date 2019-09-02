import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Project365 {
	private static long binmod(long top, long bottom, long p) {
		if (top < bottom) return 0;
		int topLength = 1 + (int) Math.round(Math.floor(Math.log(top) / Math.log(p)));
		int bottomLength = 1 + (int) Math.round(Math.floor(Math.log(bottom) / Math.log(p)));
		int length = Math.max(topLength, bottomLength);
		long[] topArr = new long[length];
		long[] bottomArr = new long[length];
		Arrays.fill(topArr, 0);
		Arrays.fill(bottomArr, 0);
		for (int pos = 0; pos < length && top > 0; ++pos) {
			topArr[pos] = top % p;
			top /= p;
		}
		for (int pos = 0; pos < length && bottom > 0; ++pos) {
			bottomArr[pos] = bottom % p;
			bottom /= p;
		}
		for (int i = 0; i < length; ++i)
			if (topArr[i] < bottomArr[i]) return 0;
		long res = 1;
		for (int i = 0; i < length; ++i) {
			if (bottomArr[i] == 0) continue;
			for (long j = bottomArr[i] + 1; j <= topArr[i]; ++j) {
				res *= j;
				res %= p;
			}
			for (long j = 1; j <= topArr[i] - bottomArr[i]; ++j) {
				res *= remove(j, p);
				res %= p;
			}
		}
		return res;
	}

	private static long remove(long n, long p) {
		long res = 1;
		long pow = p - 2;
		long cmod = n;
		if (pow != 0) {
			do {
				if (pow % 2 == 1) {
					res *= cmod;
					res %= p;
				}
				pow /= 2;
				cmod *= cmod;
				cmod %= p;
			} while (pow != 0);
		}
		return res % p;
	}

	public static void main(String[] args) {
		long pow10_9 = 1000000000;
		long pow10_18 = pow10_9 * pow10_9;
		long res = 0;
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 1001; i < 5000; ++i) {
			boolean prime = true;
			for (int j = 2; j * j <= i && prime; ++j)
				if (i % j == 0) prime = false;
			if (prime) primes.add(i);
		}
		int plen = primes.size();
		long[] prime = IntStream.range(0, plen).mapToLong(primes::get).toArray();
		long[] mods = IntStream.range(0, plen).mapToLong(i -> binmod(pow10_18, pow10_9, prime[i])).toArray();
		long[][] revs = new long[plen][plen];
		for (int i = 0; i < plen; ++i)
			for (int j = i + 1; j < plen; ++j) revs[i][j] = remove(prime[i] % prime[j], prime[j]);
		for (int i = 0; i < plen; ++i)
			for (int j = i + 1; j < plen; ++j)
				for (int k = j + 1; k < plen; ++k) {
					long r12 = revs[i][j];
					long r13 = revs[i][k];
					long r23 = revs[j][k];
					long x1 = mods[i];
					if (x1 < 0) x1 += prime[i];
					long x2 = ((mods[j] - x1) * r12) % prime[j];
					if (x2 < 0) x2 += prime[j];
					long x3 = ((mods[k] - x1) * r13 - x2) * r23 % prime[k];
					if (x3 < 0) x3 += prime[k];
					res += x1 + x2 * prime[i] + x3 * prime[i] * prime[j];
				}
		System.out.println(res);
	}
}
