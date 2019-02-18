import java.math.BigInteger;

public class Project162 {
	public static void main(String[] args) {
		BigInteger ans = BigInteger.ZERO;
		for (int i = 3; i < 17; i++) {
			ans = ans.add((((BigInteger.valueOf(15).multiply(BigInteger.valueOf(16).pow(i - 1)))
							.add(BigInteger.valueOf(41).multiply(BigInteger.valueOf(14).pow(i - 1))))
							.subtract(BigInteger.valueOf(43).multiply(BigInteger.valueOf(15).pow(i - 1))))
							.subtract(BigInteger.valueOf(13).pow(i))
			);
		}
		System.out.println(ans);
	}
}
