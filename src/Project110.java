import java.math.BigInteger;

public class Project110
{
	public static void main(String[] args)
	{
		BigInteger t = new BigInteger("30030");
		BigInteger n = new BigInteger("30030");
		while (true)
		{
			BigInteger n2 = n.pow(2);
			BigInteger count = BigInteger.ZERO;
			for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.valueOf(1)))
			{
				if (n2.mod(i).equals(BigInteger.ZERO))
					count = count.add(BigInteger.valueOf(1));
			}
			if (count.compareTo(new BigInteger("4000000")) >= 0)
			{
				System.out.println(n);
				break;
			}
			n = n.add(t);
			System.out.println(n);
		}
	}
}
