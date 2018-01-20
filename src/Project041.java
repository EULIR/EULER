public class Project041
{
	private static boolean judge(int a)
	{
		boolean[] boo = new boolean[10];
		String s = String.valueOf(a);
		for (int i = 0; i < s.length(); i++)
			boo[Integer.parseInt(s.substring(i, i + 1))] = true;
		for (int i = 1; i <= s.length(); i++)
			if (!boo[i])
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		int n = 10000000;
		int ans = 0;
		boolean[] s = new boolean[n + 2];
		for (int i = 2; i <= n; i++)
		{
			s[i] = true;
		}
		for (int i = 2; i <= n; i++)
			if (s[i])
				for (int j = 2; j <= n / i; j++)
					s[j * i] = false;
		for (int i = 2; i <= n; i++)
			if (s[i])
				if (judge(i))
					ans = i;
		System.out.println(ans);
	}
}
