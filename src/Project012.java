public class Project012
{
	public static void main(String[] args)
	{
		var k = true;
		var t = 0;
		while (k)
		{
			var ans = 0;
			t++;
			var m = t * (t + 1) / 2;
			for (var i = 1; i <= m; i++)
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