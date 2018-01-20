public class Project005
{
	public static void main(String[] args)
	{
		boolean boo = false;
		int ans = 0;
		while (!boo)
		{
			ans++;
			boolean k = true;
			for (int i = 1; i <= 20; i++)
				if (!(ans % i == 0))
				{
					k = false;
					break;
				}
			if (k)
				boo = true;
		}
		System.out.println(ans);
	}
}