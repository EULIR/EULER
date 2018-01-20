public class Project39
{
	public static void main(String[] args)
	{
		int maxx = 0;
		int ans = 0;
		for (int i = 3; i <= 1000; i++)
		{
			int max = 0;
			for (int j = 1; j <= i - 2; j++)
			{
				for (int k = j; k <= i - 2; k++)
				{
					int t = i - j - k;
					if (t >= k)
						if (j * j + k * k == t * t)
							max++;
				}
			}
			if (max > maxx)
			{
				maxx = max;
				ans = i;
			}
		}
		System.out.print(ans);
	}
}
