public class Project058
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

	public static void main(String[] args)
	{
		int primeNumber = 0;
		int i = 1;
		while (true)
		{
			i++;
			int a = (2 * i - 1) * (2 * i - 1) - 6 * (i - 1);
			int b = (2 * i - 1) * (2 * i - 1) - 4 * (i - 1);
			int c = (2 * i - 1) * (2 * i - 1) - 2 * (i - 1);
			int num = 4 * i - 3;
			if (isPrime(a))
				primeNumber++;
			if (isPrime(b))
				primeNumber++;
			if (isPrime(c))
				primeNumber++;
			if ((float) primeNumber / num < 0.1)
			{
				System.out.println(2 * i - 1);
				break;
			}
		}
	}
}
