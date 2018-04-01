public class Project004
{
	public static void main(String[] args)
	{
		int t;
		var ans = 0;
		for (var i = 100; i <= 999; i++)
			for (var j = i; j <= 999; j++)
			{
				t = i * j;
				if (Library.isReverse(t))
				{
					if (t > ans)
						ans = t;
				}
			}
		System.out.println(ans);
	}
}