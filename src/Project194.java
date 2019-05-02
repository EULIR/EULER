public class Project194 {
	public static void main(String[] args) {
		int n = 100000000;
		int a = 25;
		int b = 75;
		int[] primeList = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
		long c = 1984;
		long c1 = c - 1;
		long c2 = c1 - 1;
		long c3 = c2 - 1;
		long o = c2 * c2;
		long p = c2 * o;
		long q = c2 * p;
		long t = c3 * c3;
		long asum = (2 * o * c3 + p + 4 * o * t + c1 * o + q + c2 * t * t) % n;
		long bsum = (p + 2 * c1 * o + 3 * p * c3 + q + c1 * c2 * (c3 + t) + o * t * c3) % n;
		long z = 1;
		int num = a + b;
		int i = 0;
		int x = 2;
		while (x <= num) {
			int y = 0;
			int j = a;
			int m = num;
			while (j > 0) {
				int r1 = j;
				int m1 = m;
				while (r1 % x == 0) {
					y--;
					r1 /= x;
				}
				while (m1 % x == 0) {
					y++;
					m1 /= x;
				}
				j--;
				m--;
			}
			while (y > 0) {
				z = (z * x) % n;
				y--;
			}
			i++;
			x = primeList[i];
		}
		z = (z * c * c1) % n;
		for (int j = 0; j < a; j++) z = (z * asum) % n;
		for (int j = 0; j < b; j++) z = (z * bsum) % n;
		System.out.println(z);
	}
}