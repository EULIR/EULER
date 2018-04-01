public class Project041
{
	private static boolean judge(int a)
	{
		var boo = new boolean[10];
		var s = String.valueOf(a);
		for (var i = 0; i < s.length(); i++)
			boo[Integer.parseInt(s.substring(i, i + 1))] = true;
		for (var i = 1; i <= s.length(); i++)
			if (!boo[i])
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		var n = 10000000;
		var ans = 0;
		var s = new boolean[n + 2];
		for (var i = 2; i <= n; i++)
		{
			s[i] = true;
		}
		for (var i = 2; i <= n; i++)
			if (s[i])
				for (var j = 2; j <= n / i; j++)
					s[j * i] = false;
		for (var i = 2; i <= n; i++)
			if (s[i])
				if (judge(i))
					ans = i;
		System.out.println(ans);
	}
}
