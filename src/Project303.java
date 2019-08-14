import java.util.Arrays;

public class Project303 {
	public static void main(String[] args) {
		long[] a = new long[10000];
		long[] b = new long[10000];
		long ans = 0L;
		int i = 1;
		while (i <= 10000) {
			Arrays.fill(a, Integer.MAX_VALUE);
			a[0] = 0;
			long B = Integer.MAX_VALUE;
			long t = 1;
			while (B == Integer.MAX_VALUE) {
				Arrays.fill(b, Integer.MAX_VALUE);
				for (int add = 0; add < 10000; ++add)
					if (a[add] != Integer.MAX_VALUE) {
						for (int m = 0; m < 10; ++m) {
							int g = i * m + add;
							int d = g % 10;
							if (d > 2) {
								i++;
								t *= 10;
								continue;
							}
							g /= 10;
							long h = t * m + a[add];
							if (g < 3 && h > 0 && h < B) B = h;
							if (h < b[g]) b[g] = h;
						}
					}
				long[] c = a;
				a = b;
				b = c;
				t *= 10;
			}
			ans += B;
			i++;
		}
		System.out.println(ans);
	}
}