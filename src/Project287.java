public class Project287 {
	public static void main(String[] args) {
		int N = 24;
		int ans = 0;
		int x = (1 << (N - 1)) - 1;
		int y = 2;
		int r = 3 - (2 * x);
		while (true) {
			if (x < y) ans <<= 1;
			int a = x | (y - 1);
			while ((a & 1) == 0) {
				++ans;
				a >>>= 1;
			}
			a = (x + 1) | (y - 1);
			while ((a & 1) == 0) {
				++ans;
				a >>>= 1;
			}
			a = x | y;
			while ((a & 1) == 0) {
				++ans;
				a >>>= 1;
			}
			a = (x + 1) | y;
			while ((a & 1) == 0) {
				++ans;
				a >>>= 1;
			}
			if (x < y) break;
			if (r > 0) {
				r -= x;
				--x;
				r -= x;
			} else {
				r += y;
				++y;
				r += y;
			}
		}
		ans = (7 * ((1 << (N + 2)) - (4 * N) - ans)) - 19;
		System.out.println(ans);
	}
}