public class Project073
{
	public static void main(String[] args)
	{
		var ans = 0;
		for (var i = 5; i <= 12000; i++)
		{
			var a = i / 3;
			var b = i / 2;
			for (var j = a + 1; j <= b; j++)
				if (Library.gcd(i, j) == 1)
					ans++;
		}
		System.out.println(ans);
	}
}
