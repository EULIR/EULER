public class Project034
{
	public static void main(String[] args)
	{
		int[] a = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		int ans = 0;
		for (int i = 10; i < 100000; i++)
		{
			String s = String.valueOf(i);
			int sum = 0;
			for (int j = 0; j < s.length(); j++)
			{
				String s1 = s.substring(j, j + 1);
				sum += a[Integer.parseInt(s1)];
			}
			if (i == sum)
				ans += i;
		}
		System.out.println(ans);
	}
}
