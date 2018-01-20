public class Project010
{
	public static void main(String[] args)
	{
		boolean[] s = new boolean[2000001];
		long ans = 0;
		int q = 2000000;
		for (int i = 2; i <= q; i++)
			s[i] = true;
		for (int i = 2; i <= q; i++)
			if (s[i])
			{
				ans += i;
				for (int j = 2; j <= (q / i); j++)
					s[j * i] = false;
			}
		System.out.println(ans);
	}
}