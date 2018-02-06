import java.math.BigInteger;

public class Project080
{
	private static int ans = 0;

	private static void sqrt(BigInteger a)
	{
		int i = 0;
		while (new BigInteger("10").pow(i * 2).compareTo(a) <= 0)
			i++;
		BigInteger b = BigInteger.ZERO;
		while (i >= 0)
		{
			int j;
			BigInteger sam2 = null;
			for (j = 9; j >= 0; j--)
			{
				BigInteger sam1 = new BigInteger(String.valueOf(j)).multiply(new BigInteger("10").pow(i));
				sam2 = b.shiftLeft(1).add(sam1).multiply(sam1);
				if (sam2.compareTo(a) <= 0)
					break;
			}
			a = a.subtract(sam2);
			b = b.add(BigInteger.valueOf(j).multiply(BigInteger.TEN.pow(i)));
			i--;
		}
		String s = b.toString().substring(0, 100);
		for (int j = 0; j < s.length(); j++)
			ans += Integer.parseInt(s.substring(j, j + 1));
	}

	public static void main(String[] args)
	{
		for (int i = 1; i < 100; i++)
			if (!Library.isSquare(i))
			{
				BigInteger a = new BigInteger(String.valueOf(i)).multiply(new BigInteger("10").pow(200));
				sqrt(a);
			}
		System.out.println(ans);
	}
}
