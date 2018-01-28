public class Project069
{
	private static boolean relativelyPrime(int a, int b)
	{
		return Library.gcd(a, b) == 1;
	}

	public static void main(String[] args)
	{
		double max = 0.00D;
		int maxIndex = 0;
		for (int i = 2; i <= 1000000; i++)
		{
			if (i % 1001 != 0)
				continue;
			int number = 0;
			for (int j = 1; j <= i; j++)
				if (relativelyPrime(i, j))
					number++;
			double d = (double) i / number;
			//System.out.println(number + " " + i);
			if (d > max)
			{
				max = d;
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);
	}
}
