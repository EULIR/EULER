public class Project035
{
	private static boolean isPrime(int n)
	{
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		String[] a = new String[6];
		int ans = 1;
		for (int i = 3; i < 1000000; i++)
		{
			String s1 = String.valueOf(i);
			for (int j = 0; j < s1.length(); j++)
				a[j] = s1.substring(j, j + 1);
			boolean boo = true;
			for (int j = 0; j < s1.length(); j++)
			{
				StringBuilder s = new StringBuilder();
				for (int k = j; k < s1.length() + j; k++)
					s.append(a[k % s1.length()]);
				if (!isPrime(Integer.parseInt(s.toString())))
				{
					boo = false;
					break;
				}
			}
			if (boo)
			{
				ans++;
				//System.out.print(i + " ");
			}
		}
		System.out.print(ans);
	}
}