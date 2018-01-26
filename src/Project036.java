public class Project036
{
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
			if (Library.isReverse(s))
				if (Library.isReverse(change(i)))
					ans += i;
		}
		System.out.print(ans);
	}
}
