import java.util.stream.IntStream;

public class Project435 {
	public static void main(String[] args) {
		final long NUM = 1000000000000000L;
		long[][] arr = {
				{2048, 0},
				{729, 0},
				{125, 0},
				{49, 0},
				{11, 0},
				{13, 0}
		};
		for (int i = 0; i < arr.length; i++) {
			long m = arr[i][0];
			long a = 0;
			long b = 1;
			long p;
			p = 1;
			while (true) {
				b += a;
				a = (b - a);
				b %= m;
				a %= m;
				if (a == 0 && b == 1)
					break;
				p++;
			}
			for (long j = 0; j <= 100; j++) {
				long l = 1;
				long fibonaci = 0;
				long xp = power(j, p, m);
				long q = NUM / p;
				long sk = geo(xp, q, m);
				long xk = 1;
				long k = 0;
				while (k < p && k <= NUM) {
					if ((NUM - k) / p != q) {
						q = (NUM - k) / p;
						sk = geo(xp, q, m);
					}
					arr[i][1] += (sk * xk * fibonaci) % m;
					arr[i][1] %= m;
					fibonaci += l;
					l = (fibonaci - l);
					fibonaci %= m;
					l %= m;
					xk *= j;
					xk %= m;
					k++;
				}
			}
		}
		System.out.println(c(arr));

	}

	static long geo(long x, long r, long mod) {
		if (r < 0) return 0;
		long xp = x, pow = 1, sum = 1;
		while (xp != 1) {
			sum += xp;
			sum %= mod;
			if (pow == r)
				return sum;
			xp *= x;
			xp %= mod;
			pow++;
			if (xp == 0)
				return sum;
		}
		long ret = (sum * (((r + 1) / pow) % mod)) % mod;
		long t = r % pow, s = 1;
		for (int i = 0; i <= t; i++) {
			ret += s;
			ret %= mod;
			s *= x;
			s %= mod;
		}
		return ret;

	}

	static long c(long[][] arr) {
		int l = arr.length;
		long n;
		long x = 0;
		n = IntStream.range(0, l).mapToLong(i -> arr[i][0]).reduce(1, (a, b) -> a * b);
		int i = 0;
		while (i < l) {
			long n1 = arr[i][0];
			long[] temp = createArr(new long[]{n1, n / n1});
			x += (arr[i][1] * temp[1] * n / n1) % n;
			x %= n;
			if (x < 0)
				x += n;
			i++;
		}
		return x;
	}

	static long[] createArr(long[] arr) {
		if (arr[1] == 0)
			return new long[]{1, 0};
		else {
			long[] st = createArr(new long[]{arr[1], arr[0] % arr[1]});
			return new long[]{st[1], st[0] - (arr[0] / arr[1]) * st[1]};
		}
	}

	static long power(long x, long y, long m) {
		long ans = 1;
		while (y > 0) {
			if ((y & 1) > 0)
				ans *= x;
			ans %= m;
			if ((y >>= 1) > 0)
				x *= x;
			x %= m;
		}
		return ans;
	}
}
