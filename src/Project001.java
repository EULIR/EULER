public class Project001
{
	public static void main(String... args)
	{
		var ans = 0;
		for (var i = 1; i < 1000; i++)
			if (i % 3 == 0 || i % 5 == 0)
				ans += i;
		System.out.println(ans);
	}
}