import java.math.BigInteger;

public class Project097
{
	public static void main(String[] args)
	{
		BigInteger ans = new BigInteger("2").pow(7830457).multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE);
		String str = ans.toString();
		System.out.println(str.substring(str.length() - 10));
	}
}
