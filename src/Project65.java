import java.math.BigInteger;

public class Project65
{
	public static void main(String[] args)
	{
		BigInteger d = new BigInteger("1");
		BigInteger n = new BigInteger("2");
		for (int i = 2; i <= 100; i++)
		{
			long c;
			BigInteger temp = d;
			if (i % 3 == 0)
				c = 2 * (i / 3);
			else c = 1;
			BigInteger BigC = new BigInteger(c + "");
			d = n;
			n = d.multiply(BigC).add(temp);
		}
		String Str = n.toString();
		int result = 0;
		for (int i = 0; i < Str.length(); i++)
			result += Integer.valueOf(Str.charAt(i) + "");
		System.out.println(result);
	}
}
