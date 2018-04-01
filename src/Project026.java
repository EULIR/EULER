import java.math.BigInteger;

public class Project026
{
	public static void main(String[] args)
	{
		int ans = 0, max = 0;
		for (var i = 2; i < 1000; i++)
		{
			var a = i;
			while (a % 2 == 0)
				a /= 2;
			while (a % 5 == 0)
				a /= 5;
			var big = new BigInteger("9");
			var big1 = new BigInteger(String.valueOf(a));
			while (!BigInteger.ZERO.equals(big.mod(big1)))
			{
				big = big.multiply(new BigInteger("10"));
				big = big.add(new BigInteger("9"));
			}
			var s1 = big.toString();
			var n = s1.length();
			if (n > max)
			{
				max = n;
				ans = i;
			}
		}
		System.out.println(ans);
	}
}
