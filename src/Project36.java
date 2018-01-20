public class Project36
{
	private static boolean judge(String s)
	{
		for (int i = 0; i < s.length() / 2; i++)
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		return true;
	}
	private static String change(int a)
	{
		StringBuilder s = new StringBuilder();
		while (a != 0)
		{
			int b = a % 2;
			s.insert(0, b);
			a /= 2;
		}
		return s.toString();
	}
	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 1; i < 1000000; i++)
		{
			String s = String.valueOf(i);
			if (judge(s))
				if (judge(change(i)))
					ans += i;
		}
		System.out.print(ans);
	}
}
