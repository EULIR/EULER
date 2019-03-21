import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.IntStream;

public class Project315 {
	public static void main(String[] args) {
		int[] arr = {125, 80, 55, 87, 90, 79, 111, 89, 127, 95, 0};
		int[][] d = new int[11][11];
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 11; j++)
				d[i][j] = Integer.bitCount(arr[i] ^ arr[j]);
		int a = 10000000;
		int B = 20000000;
		int[] primes = sieveEratosthenes(B);
		long sample = 0L;
		long max = 0L;
		for (int prime : primes) {
			int cnt = prime;
			if (cnt < a)
				continue;
			max += IntStream.iterate(cnt, i -> i > 0, i -> i / 10).mapToLong(i -> d[10][i % 10]).sum();
			while (cnt >= 10) {
				sample += IntStream.iterate(cnt, i -> i > 0, i -> i / 10).mapToLong(i -> 2 * d[10][i % 10]).sum();
				int sum = IntStream.iterate(cnt, i -> i > 0, i -> i / 10).map(i -> i % 10).sum();
				int i = cnt, j = sum;
				while (i > 0) {
					max += j == 0 ? d[10][i % 10] : d[j % 10][i % 10];
					i /= 10;
					j /= 10;
				}
				cnt = sum;
			}
			for (int i = cnt; i > 0; i /= 10) {
				max += d[10][i % 10];
				sample += 2 * d[10][i % 10];
			}
		}
		System.out.println(sample - max);
	}

	/*
	 * implementation of the Sieve of Eratosthenes
	 * credit to @uwi
	 * */
	public static int[] sieveEratosthenes(int n) {
		int[] ret = new int[(int) (n / Math.log(n)) + (int) (n / (Math.log(n) * Math.log(n)) * 1.5)];
		ret[0] = 2;
		int pos = 1;
		BitSet bs = new BitSet(n / 2 + 1);
		int sup = (n - 3) / 2;
		for (int i = bs.nextClearBit(0); i <= sup; i = bs.nextClearBit(i + 1)) {
			int p = 2 * i + 3;
			ret[pos++] = p;
			for (int j = i + p; j <= sup; j += p) {
				bs.set(j);
			}
		}
		return Arrays.copyOf(ret, pos);
	}
}