import java.math.BigInteger;

public class Project066
{
	private static String sqrt(String num)
	{
		String sqrt = "0";
		String pre = "0";
		BigInteger trynum;
		BigInteger flag;
		BigInteger _20 = new BigInteger("20");
		BigInteger dividend;
		BigInteger A;
		BigInteger B;
		BigInteger BB;
		if (num.length() % 2 == 1)
			num = "0" + num;
		for (int i = 0; i < num.length() / 2; ++i)
		{
			dividend = new BigInteger(pre + num.substring(2 * i, 2 * i + 2));
			A = new BigInteger(sqrt);
			for (int j = 0; j <= 9; ++j)
			{
				B = new BigInteger(j + "");
				BB = new BigInteger((j + 1) + "");
				trynum = _20.multiply(A).multiply(B).add(B.pow(2));
				flag = _20.multiply(A).multiply(BB).add(BB.pow(2));
				if (trynum.subtract(dividend).compareTo(BigInteger.ZERO) <= 0 && flag.subtract(dividend).compareTo(BigInteger.ZERO) > 0)
				{
					sqrt += j;
					pre = dividend.subtract(trynum).toString();
					break;
				}
			}
		}
		return sqrt.substring(1);
	}
	private static boolean isSquare(BigInteger a)
	{
		BigInteger b = new BigInteger(sqrt(String.valueOf(a)));
		return b.pow(2).equals(a);
	}

	private static BigInteger findTheMaxX(int D)
	{
		BigInteger y = BigInteger.ONE;
		BigInteger x1 = y.multiply(y).multiply(BigInteger.valueOf(D));
		x1 = x1.add(BigInteger.ONE);
		while (!isSquare(x1))
		{
			y = y.add(BigInteger.ONE);
			x1 = y.multiply(y).multiply(BigInteger.valueOf(D));
			x1 = x1.add(BigInteger.ONE);
		}
		return new BigInteger(sqrt(String.valueOf(x1)));
	}

	private static boolean isSquare(int a)
	{
		int b = (int) Math.sqrt(a);
		return b * b == a;
	}

	public static void main(String[] args)
	{
		///*
		int index = 0;
		BigInteger max = BigInteger.ZERO;
		for (int D = 2; D <= 1000; D++)
		{
			if (isSquare(D))
				continue;
			BigInteger x = findTheMaxX(D);
			//System.out.print(judge(x,D));
			System.out.println(x + " " + D);
			if (x.compareTo(max) > 0)
			{
				max = x;
			    index = D;
			}
		}//*/
		//System.out.println(findTheMaxX(5));
		System.out.println(index);
		//System.out.println(findTheMaxX(661));
	}
}
