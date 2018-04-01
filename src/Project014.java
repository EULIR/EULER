public class Project014
{
	private static int make(int n, int k)
	{
		if (n == 1)
			return k + 1;
		else
		{
			if ((n % 2) != 0)
				return make(3 * n + 1, k + 1);
			else
				return make(n / 2, k + 1);
		}
	}

	public static void main(String[] args)
	{
		var max = 0;
		var ans = 0;
		for (var i = 2; i <= 1000000; i++)
		{
			var n = make(i, 0);
			if (n > max)
			{
				max = n;
				ans = i;
			}
		}
		System.out.println(ans);
	}
}