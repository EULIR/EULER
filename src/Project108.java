public class Project108
{
	public static void main(String[] args)
	{
		long t;
		long n = t = 2 * 3 * 5 * 7;
		while (true)
		{
			long n2 = n * n;
			int count = 0;
			for (int i = 1; i <= n; i++)
				if (n2 % i == 0)
					count++;
			if (count > 1000)
			{
				System.out.println(n);
				break;
			}
			n += t;
		}
	}
}
