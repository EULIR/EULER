import java.math.BigInteger;

public class Project48
{
	public static void main(String[] args)
	{
		BigInteger ans = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++)
		{
			BigInteger big = new BigInteger(String.valueOf(i));
			big = big.pow(i).mod(BigInteger.valueOf(10000000000L));
			ans = ans.add(big).mod(BigInteger.valueOf(10000000000L));
		}
		System.out.println(ans);
	}
}
