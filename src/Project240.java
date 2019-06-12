public class Project240 {
	static int MAX = 70;
	static int D = 12;
	static int n = 10;
	static int m = 20;
	static long ans = 0;
	static int[] cast = new int[n];
	static int[] groups = new int[n];

	static long fac(long k) {
		long r = 1;
		while (k > 1) r *= k--;
		return r;
	}

	static long binom(long n, long k) {
		return fac(n) / fac(k) / fac(n - k);
	}

	static void acc(int prev, int groupsize, int numgroups) {
		long dist = 1;
		for (int i = 0; i < numgroups; ++i) dist *= fac(groups[i]);
		long run = 0;
		long p = 1;
		for (int r = 0; r <= m - n; ++r) {
			run += binom(m, r) * fac(m - r) / dist / fac(groupsize + m - n - r) * p;
			p *= prev - 1;
		}
		ans += run;
	}

	static void go(int have, int ps, int prev, int groupsize, int numgroups) {
		if (ps > MAX) return;
		if (have == n) {
			acc(prev, groupsize, numgroups);
			return;
		}
		cast[have] = prev;
		go(have + 1, ps + prev, prev, groupsize + 1, numgroups);
		if (groupsize > 0) groups[numgroups++] = groupsize;
		for (int d = prev - 1; d >= 1; --d) {
			if ((n - have) * d < MAX - ps) break;
			cast[have] = d;
			go(have + 1, ps + d, d, 1, numgroups);
		}
	}

	public static void main(String[] args) {
		go(0, 0, D, 0, 0);
		System.out.println(ans);
	}
}
