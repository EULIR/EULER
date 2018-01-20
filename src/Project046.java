public class Project046
{
	private static boolean isPrime(int n)
	{
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	private static boolean isSquare(int a)
	{
		int b = (int) Math.sqrt(a);
		return b * b == a;
	}

	private static boolean isTure(int a)
	{
		for (int i = 2; i < a; i++)
			if (isPrime(i))
			{
				int t = a - i;
				t /= 2;
				if (isSquare(t))
					return false;
			}
		return true;
	}

	public static void main(String[] args)
	{
		int n = 1;
		while (true)
		{
			n += 2;
			if (isPrime(n))
				continue;
			if (isTure(n))
			{
				System.out.println(n);
				break;
			}
		}
	}
}
