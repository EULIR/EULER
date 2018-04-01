public class Project108
{
	public static void main(String[] args)
	{
		long t;
		var n = t = 2 * 3 * 5 * 7 * 11 * 13;
		while (true)
		{
			var n2 = n * n;
			var count = 0;
			for (var i = 1; i <= n; i++)
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
