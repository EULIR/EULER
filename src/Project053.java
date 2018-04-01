import java.math.BigInteger;

public class Project053
{
	private static BigInteger fal(BigInteger n)
	{
		var ans = BigInteger.ONE;
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		for (var i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))
			ans = ans.multiply(i);
		return ans;
	}

	private static BigInteger C(BigInteger n, BigInteger r)
	{
		var t1 = fal(n);
		var t2 = fal(r);
		var t3 = fal(n.subtract(r));
		return t1.divide(t2).divide(t3);
	}

	public static void main(String[] args)
	{
		var ans = 0;
		for (var i = 1; i <= 100; i++)
			for (var j = 1; j <= i; j++)
			{
				var n = new BigInteger(String.valueOf(i));
				var r = new BigInteger(String.valueOf(j));
				var t = C(n, r);
				var co = new BigInteger("1000000");
				if (t.compareTo(co) > 0)
					ans++;
			}
		System.out.println(ans);
	}
}
