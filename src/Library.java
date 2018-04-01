import java.math.BigInteger;

public class Library
{
	public static boolean isPrime(int a)
	{
		if (a <= 1)
			return false;
		for (var i = 2; i * i <= a; i++)
			if (a % i == 0)
				return false;
		return true;
	}

	public static boolean isPrime(long a)
	{
		if (a <= 1)
			return false;
		for (long i = 2; i * i <= a; i++)
			if (a % i == 0)
				return false;
		return true;
	}

	public static boolean isPrime(BigInteger a)
	{
		if (a.compareTo(BigInteger.ONE) <= 0)
			return false;
		for (var i = new BigInteger("2"); i.multiply(i).compareTo(a) <= 0; i = i.add(BigInteger.ONE))
			if (a.mod(i).equals(BigInteger.ZERO))
				return false;
		return true;
	}

	public static int max(int a, int b)
	{
		if (a > b)
			return a;
		return b;
	}

	public static long max(long a, long b)
	{
		if (a > b)
			return a;
		return b;
	}

	public static int min(int a, int b)
	{
		if (a < b)
			return a;
		return b;
	}

	public static long min(long a, long b)
	{
		if (a < b)
			return a;
		return b;
	}

	public static String reverse(String str)
	{
		return new StringBuilder(str).reverse().toString();
	}

	public static boolean isReverse(String str)
	{
		return reverse(str).equals(str);
	}

	public static boolean isReverse(int a)
	{
		var str = String.valueOf(a);
		return reverse(str).equals(str);
	}

	public static int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		else return gcd(b, a % b);
	}

	public static boolean isPentagonal(long a)
	{
		var t = 24 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 6 == 5;
	}

	public static boolean isHexagonal(long a)
	{
		var t = 8 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 4 == 3;
	}

	public static boolean isTriangle(long a)
	{
		var t = a * 2;
		return Math.floor(Math.sqrt(t)) * (Math.floor(Math.sqrt(t)) + 1) / 2 == a;
	}

	public static boolean isOctagonal(long a)
	{
		var t = 3 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 3 == 2;
	}

	public static boolean isHeptagonal(long a)
	{
		var t = 40 * a + 9;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 10 == 7;
	}

	public static boolean isSquare(int a)
	{
		var b = (int) Math.sqrt(a);
		return b * b == a;
	}

	public static boolean isSquare(long a)
	{
		var b = (long) Math.sqrt(a);
		return b * b == a;
	}

	public static double log(double base, double value)
	{
		var lnb = Math.log(base);
		var lnv = Math.log(value);
		return lnv / lnb;
	}

	public static int power(int x, int y)
	{
		var k = x;
		var ans = 1;
		while (y > 0)
		{
			if (y % 2 == 1)
				ans *= k;
			k *= k;
			y /= 2;
		}
		return ans;
	}

	public static long power(long x, long y)
	{
		var k = x;
		long ans = 1;
		while (y > 0)
		{
			if (y % 2 == 1)
				ans *= k;
			k *= k;
			y /= 2;
		}
		return ans;
	}
}
