public class Project12
{
	public static void main(String[] args)
	{
		boolean k = true;
		int t = 0;
		while(k)
		{
			int ans = 0;
			t++;
			int m = t * (t + 1) / 2;
			for (int i = 1;i <= m;i++)
				if (m % i == 0)
					ans++;
			if (ans > 500)
			{
				System.out.println(m);
				k = false;
			}
		}
	}
}