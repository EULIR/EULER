import java.math.BigInteger;

public class Project066
{
	public static BigInteger sqrt(BigInteger x)
	{
		if (x.signum() == -1)
			throw new IllegalArgumentException("Square root of negative number");
		BigInteger y = BigInteger.ZERO;
		for (int i = (x.bitLength() - 1) / 2; i >= 0; i--)
		{
			y = y.setBit(i);
			if (y.multiply(y).compareTo(x) > 0)
				y = y.clearBit(i);
		}
		return y;
	}

	private static boolean isSquare(BigInteger a)
	{
		BigInteger b = sqrt(a);
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
		return sqrt(x1);
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
