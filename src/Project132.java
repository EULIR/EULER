public class Project132 {
	public static int powerMod(int x, int y, int n) {
		int z = 1;
		for (; y != 0; y >>>= 1) {
			if ((y & 1) != 0)
				z = (int) ((long) z * x % n);
			x = (int) ((long) x * x % n);
		}
		return z;
	}

	public static void main(String[] args) {
		int sum = 0;
		int num = 0;
		for (int i = 2; num < 40; i++) {
			int n = (powerMod(10, 1000000000, 9 * i) - 1) / 9;
			if (Library.isPrime(i) && n == 1) {
				sum += i;
				num++;
			}
		}
		System.out.println(sum);
	}
}
