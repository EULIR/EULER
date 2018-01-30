public class Project073
{
	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 5; i <= 12000; i++)
		{
			int a = i / 3;
			int b = i / 2;
			for (int j = a + 1; j <= b; j++)
				if (Library.gcd(i, j) == 1)
					ans++;
		}
		System.out.println(ans);
	}
}
