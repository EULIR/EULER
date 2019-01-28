import java.math.BigInteger;

public class Project118 {
	static int[] arr = new int[9];
	static int[] primeList = new int[512];
	static int[] result = new int[512];

	public static void main(String[] args) {
		for (int i = 1; i < 511; i++) {
			int n = 0;
			for (int j = 1; j <= 9; j++) {
				if (((i >> (j - 1)) & 1) != 0)
					arr[n++] = j;
			}
			countPrime(n, 0, i, 0);
		}
		result[0] = 1;
		for (int i = 0; i < 512; i++) {
			for (int j = 0; j < Integer.highestOneBit(i); j++) {
				if ((j & ~i) == 0) {
					result[i] += result[j] * primeList[i & ~j];
				}
			}
		}
		System.out.println(result[511]);
	}

	public static void countPrime(int n, int i, int k, int num) {
		if (i == n) {
			if (BigInteger.valueOf(num).isProbablePrime(10))
				++primeList[k];
			return;
		}
		int t;
		for (int j = i; j < n; ++j) {
			t = arr[j];
			arr[j] = arr[i];
			arr[i] = t;
			countPrime(n, i + 1, k, 10 * num + t);
			t = arr[j];
			arr[j] = arr[i];
			arr[i] = t;
		}
	}
}