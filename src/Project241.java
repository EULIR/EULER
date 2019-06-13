import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Project241 {
	static HashSet<Long> set = new HashSet<>();
	static long sum;
	static double EPS = 0.0000000001;

	public static void main(String args[]) {
		IntStream.rangeClosed(1, 7).forEach(k -> func(Math.log(2), Math.log(2 * k + 1), 2, 2 * k + 1, 1, new HashSet<>(), 0, Math.log(1000000000000000000L)));
		System.out.println(sum);
	}

	public static void func(double logA, double logB, long a, long b, long x, HashSet<Long> set, double logx, double logL) {
		if (a == b) {
			if (!set.contains(x)) {
				set.add(x);
				sum += x;
			}
		} else if (logA < logB) {
			long g = Library.gcd(a, b);
			a /= g;
			b /= g;
			for (Long p : set)
				if (a % p == 0)
					return;
			long p = minp(a);
			if (p > 1) {
				long pow = 1;
				long spw = 1;
				int e = ord(p, a);
				for (int i = 0; i < e; i++) {
					pow *= p;
					spw += pow;
				}
				set.add(p);
				double logp = Math.log(p);
				while (logA + Math.log(spw) <= logB + e * logp + EPS && logx + e * logp <= logL) {
					func(logA + Math.log(spw), logB + e * logp, a * spw, b * pow, x * pow, set, logx + e * logp, logL);
					e++;
					pow *= p;
					spw += pow;
				}
				set.remove(p);
			}
		}
	}

	public static int ord(long p, long n) {
		return n % p == 0 ? ord(p, n / p) + 1 : 0;
	}

	public static long minp(long n) {
		return LongStream.iterate(2, i -> i * i <= n, p -> p + 1).filter(p -> n % p == 0).findFirst().orElse(n);
	}
}
