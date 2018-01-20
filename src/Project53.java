import java.math.BigInteger;

public class Project53
{
	private static BigInteger fal(BigInteger n)
	{
		BigInteger ans = BigInteger.ONE;
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))
			ans = ans.multiply(i);
		return ans;
	}

	private static BigInteger C(BigInteger n, BigInteger r)
	{
		BigInteger t1 = fal(n);
		BigInteger t2 = fal(r);
		BigInteger t3 = fal(n.subtract(r));
		return t1.divide(t2).divide(t3);
	}

	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 1; i <= 100; i++)
			for (int j = 1; j <= i; j++)
			{
				BigInteger n = new BigInteger(String.valueOf(i));
				BigInteger r = new BigInteger(String.valueOf(j));
				BigInteger t = C(n, r);
				BigInteger co = new BigInteger("1000000");
				if (t.compareTo(co) > 0)
					ans++;
			}
		System.out.println(ans);
	}
}
