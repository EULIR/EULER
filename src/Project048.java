import java.math.BigInteger;

public class Project048
{
	public static void main(String[] args)
	{
		var ans = BigInteger.ZERO;
		for (var i = 1; i <= 1000; i++)
		{
			var big = new BigInteger(String.valueOf(i));
			big = big.pow(i).mod(BigInteger.valueOf(10000000000L));
			ans = ans.add(big).mod(BigInteger.valueOf(10000000000L));
		}
		System.out.println(ans);
	}
}
