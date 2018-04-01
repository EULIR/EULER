public class Project005
{
	public static void main(String[] args)
	{
		var boo = false;
		var ans = 0;
		while (!boo)
		{
			ans++;
			var k = true;
			for (var i = 1; i <= 20; i++)
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