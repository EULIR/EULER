import java.math.BigInteger;

public class Project110
{
	public static void main(String[] args)
	{

		var t = new BigInteger("30030");
		var n = new BigInteger("30030");
		while (true)
		{
			var n2 = n.pow(2);
			var count = BigInteger.ZERO;
			for (var i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.valueOf(1)))
				if (n2.mod(i).equals(BigInteger.ZERO))
					count = count.add(BigInteger.valueOf(1));
			if (count.compareTo(new BigInteger("4000000")) >= 0)
			{
				System.out.println(n);
				break;
			}
			n = n.add(t);
		}
	}
}
