import java.util.Arrays;
import java.util.stream.IntStream;

public class Project378 {
	public static void main(String[] args) {
		final int N = 60000000;
		int[] factors = new int[N + 2];
		int[] divisors = new int[N + 2];
		Arrays.fill(divisors, 1);
		Arrays.fill(factors, 1);
		for (int i = 2; i * i < divisors.length; ++i)
			if (divisors[i] == 1) {
				int pow = 1;
				for (long j = i; j < divisors.length; j *= i, ++pow)
					for (int k = (int) j; k < divisors.length; k += j) {
						divisors[k] = divisors[k] * (pow + 1) / pow;
						factors[k] *= i;
					}
			}
		IntStream.range(1, factors.length).filter(n -> factors[n] != n).forEach(n -> divisors[n] *= 2);
		boolean[] anydT = new boolean[23040 + 1];
		short[] dT = new short[N + 1];
		IntStream.iterate(1, n -> n <= N, n -> n + 2).forEach(n -> anydT[dT[n] = (short) (divisors[n] * divisors[(n + 1) / 2])] = true);
		IntStream.iterate(2, n -> n <= N, n -> n + 2).forEach(n -> anydT[dT[n] = (short) (divisors[n / 2] * divisors[n + 1])] = true);
		short[] index = new short[23040 + 1];
		int ndT = 0;
		for (int dTn = 0; dTn < anydT.length; ++dTn)
			if (anydT[dTn]) index[dTn] = (short) ndT++;
		IntStream.rangeClosed(1, N).forEach(n -> dT[n] = index[dT[n]]);
		int[] ndTleft = new int[ndT];
		int[] ndTright = new int[ndT];
		IntStream.rangeClosed(1, N).forEach(n -> ++ndTright[dT[n]]);
		int[] ndTleft16 = new int[(ndT + 15) / 16];
		int[] ndTright16 = new int[(ndT + 15) / 16];
		IntStream.range(0, ndT).forEach(dTk -> ndTright16[dTk / 16] += ndTright[dTk]);
		long Tr = 0;
		for (int j = 1; j <= N; ++j) {
			int limitLeft = ndT - dT[j] - 1;
			int limitLeft16 = limitLeft >> 4;
			int limitRight = dT[j];
			int limitRight16 = limitRight >> 4;
			ndTright[limitRight]--;
			ndTright16[limitRight16]--;
			long countLeft;
			long countRight;
			countLeft = Arrays.stream(ndTleft16, 0, limitLeft16).sum();
			countLeft += Arrays.stream(ndTleft, limitLeft16 << 4, limitLeft).sum();
			countRight = Arrays.stream(ndTright16, 0, limitRight16).sum();
			countRight += Arrays.stream(ndTright, limitRight16 << 4, limitRight).sum();
			Tr = (Tr + countLeft * countRight) % 1000000000000000000L;
			ndTleft[limitLeft]++;
			ndTleft16[limitLeft16]++;
		}
		System.out.println(Tr);
	}
}
