public class Project072
{
	private static long euler(long n)
	{
		long res = n, a = n;
		for (long i = 2; i * i <= a; i++)
			if (a % i == 0)
			{
				res = res / i * (i - 1);
				while (a % i == 0)
					a /= i;
			}
		if (a > 1)
			res = res / a * (a - 1);
		return res;
	}

	public static void main(String[] args)
	{
		long ans = 0;
		for (var i = 2; i <= 1000000; i++)
			ans += euler(i);
		System.out.println(ans);
	}
}
