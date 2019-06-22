public class Project297 {
	static long n = 100000000000000000L;
	static long ans = 0;

	public static void main(String[] args) {
		dfs(1, 1, 0, 0);
		System.out.println(ans);
	}

	static void dfs(long a, long b, long c, long d) {
		if (b > n)
			return;
		dfs(b, a + b, d, c + d + a);
		if (b > n)
			return;
		n -= b;
		ans += d + n;
	}
}
