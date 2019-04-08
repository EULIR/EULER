import java.util.stream.IntStream;

public class Project157 {
	public static void main(String[] args) {
		final int LIMIT = 10;
		int ans = 0;
		int[] arr1 = new int[LIMIT];
		arr1[0] = 1;
		IntStream.range(1, LIMIT).forEach(n -> arr1[n] = arr1[n - 1] * 2);
		int[] arr2 = new int[LIMIT];
		arr2[0] = 1;
		IntStream.range(1, LIMIT).forEach(n -> arr2[n] = arr2[n - 1] * 5);
		for (int i = 1; i < LIMIT; i++) {
			int a = 1;
			int b = 10;
			int e = i;
			while (e > 0) {
				if ((e & 1) == 1)
					a = a * b;
				e /= 2;
				b *= b;
			}
			for (int j = 0; j <= i; j++) {
				for (int k = 0; k <= i; k++) {
					ans += func(arr1[j], arr2[k], a);
				}
			}
			for (int j = 1; j <= i; j++) {
				for (int k = 1; k <= i; k++) {
					ans += func(1, arr1[j] * arr2[k], a);
				}
			}
		}
		System.out.println(ans);
	}

	public static int func(int a, int b, int c) {
		long z = (long) c * (a + b);
		if (z % b != 0 || z % a != 0) return 0;
		int e = (int) (z / (a * b));
		int result = 1;
		for (int k = 2; k * k <= e; k++) {
			int count = 1;
			while (e % k == 0) {
				e = e / k;
				count++;
			}
			result = result * count;
		}
		if (e != 1) result = result << 1;
		return result;
	}
}
