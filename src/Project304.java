import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Project304 {
	public static void main(String args[]) {
		int n = 100000;
		long off = 100000000000000L;
		boolean c[] = new boolean[(int) (10 * n * Math.log(n) + 1)];
		int L = (int) Math.ceil(Math.sqrt(off + c.length));
		boolean c2[] = new boolean[L];
		IntStream.iterate(2, i -> i * i < L, i -> i + 1).filter(i -> !c2[i]).forEach(i -> IntStream.iterate(i * i, j -> j < L, j -> j + i).forEach(j -> c2[j] = true));
		IntStream.range(2, L).filter(i -> !c2[i]).forEach(i -> LongStream.iterate(off / i * i, j -> j < off + c.length, j -> j + i).filter(j -> j >= off).forEach(j -> c[(int) (j - off)] = true));
		BigInteger v[][] = exp(new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}}, off - 1);
		long f0 = v[0][1].longValue();
		long f1 = v[0][0].longValue();
		long sum = 0;
		int i = 1, j = 0;
		while (i <= n) {
			long f2 = (f0 + f1) % 1234567891011L;
			f0 = f1;
			f1 = f2;
			j++;
			while (c[j]) {
				f2 = (f0 + f1) % 1234567891011L;
				f0 = f1;
				f1 = f2;
				j++;
			}
			sum += f1;
			sum %= 1234567891011L;
			i++;
		}
		System.out.println(sum);
	}

	static BigInteger[][] exp(BigInteger b[][], long e) {
		if (e == 0) return new BigInteger[][]{{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
		if (e == 1) return b;
		if ((e & 1) == 0) return exp(mul(b, b), e >> 1);
		return mul(b, exp(b, e - 1));
	}

	static BigInteger[][] mul(BigInteger a[][], BigInteger b[][]) {
		return new BigInteger[][]{{
				a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])).remainder(BigInteger.valueOf(1234567891011L)),
				a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1])).remainder(BigInteger.valueOf(1234567891011L)),
		}, {
				a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])).remainder(BigInteger.valueOf(1234567891011L)),
				a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1])).remainder(BigInteger.valueOf(1234567891011L)),
		}};
	}
}