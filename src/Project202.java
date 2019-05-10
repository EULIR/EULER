public class Project202 {
	public static void main(String[] args) {
		final long n = 6008819575L;
		long ans = 1001469929L;
		int[] f = {5, 11, 17, 23, 29, 41, 47};
		int[] s = new int[128];
		long[] r = new long[128];
		r[0] = 1;
		s[0] = 1;
		int t = 1;
		for (int i = 0, k = 1; i < 7; i++, k *= 2)
			for (int j = 0; j < k; j++) {
				r[t] = f[i] * r[j];
				s[t] = -s[j];
				ans += ((n + 3 * r[t]) / 6 / r[t]) * s[t];
				t++;
			}
		System.out.println(2 * ans);
	}
}
