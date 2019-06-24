import java.util.Arrays;
import java.util.stream.IntStream;

public class Project258 {
	public static void main(String args[]) {
		long k = Library.power(10, 18);
		final int n = 2000;
		final long mod = 20092010;
		long b[] = new long[n];
		long c[] = new long[(n * 2)];
		long p[] = new long[n + 1];
		long q[] = new long[n + 1];
		Arrays.fill(b, 1);
		p[0] = 1;
		p[1999] = p[2000] = -1;
		for (int m = n * 2; k >= n; k /= 2) {
			System.arraycopy(b, 0, c, 0, n);
			for (int i = n; i < m; i++) {
				c[i] = 0;
				for (int j = 1; j <= n; j++) {
					if (p[j] == 0) continue;
					c[i] -= p[j] * c[i - j];
				}
				c[i] %= mod;
			}
			for (int i = 0, j = (int) (k & 1); i < n; i++, j += 2)
				b[i] = c[j];
			for (int i = 0; i <= n; i++) {
				q[i] = p[i] * p[i];
				int lim = Library.min(n - i, i);
				for (int j = 1, a = -2; j <= lim; j++, a = -a)
					q[i] += p[i + j] * p[i - j] * a;
				if ((i & 1) != (n & 1))
					q[i] *= -1;
			}
			IntStream.rangeClosed(1, n).forEach(i -> p[i] = q[i] % mod);
		}
		long ans = b[(int) k] % mod;
		ans = (ans + mod) % mod;
		System.out.println(ans);
	}
}
