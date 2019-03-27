import java.math.BigInteger;

public class Project321 {
	public static void main(String[] args) {
		long k = 1;
		long ans = 0;
		int index = 0;
		for (long i = 1; index < 40; i++) {
			BigInteger n2 = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i + 2));
			while (BigInteger.valueOf(k).multiply(BigInteger.valueOf(k + 1)).divide(BigInteger.valueOf(2)).compareTo(n2) < 0)
				k++;
			if (BigInteger.valueOf(k).multiply(BigInteger.valueOf(k + 1)).divide(BigInteger.valueOf(2)).compareTo(n2) == 0) {
				ans += i;
				if (index % 2 == 1) {
					i = (long) (2.78361162 * i);
					k = (long) (2.78361162 * k);
				} else {
					i = (long) (2.09383632 * i);
					k = (long) (2.09383632 * k);
				}
				index++;
			}
		}
		System.out.println(ans);
	}
}
