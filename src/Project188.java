import java.math.BigInteger;

public class Project188 {
	public static void main(String[] args) {
		int a = 1777;
		int b = 1855;
		BigInteger ans = BigInteger.ONE;
		final BigInteger tenEighth = BigInteger.valueOf((long) Math.pow(10, 8));
		for (int i = 0; i < b; i++)
			ans = BigInteger.valueOf(a).modPow(ans, tenEighth);
		System.out.println(ans.toString());
	}
}
