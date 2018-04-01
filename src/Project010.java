public class Project010
{
	public static void main(String[] args)
	{
		var s = new boolean[2000001];
		long ans = 0;
		var q = 2000000;
		for (var i = 2; i <= q; i++)
			s[i] = true;
		for (var i = 2; i <= q; i++)
			if (s[i])
			{
				ans += i;
				for (var j = 2; j <= (q / i); j++)
					s[j * i] = false;
			}
		System.out.println(ans);
	}
}