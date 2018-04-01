public class Project023
{
	private static boolean take(int a)
	{
		var ans = 0;
		for (var i = 1; i < a / 2 + 1; i++)
			if (a % i == 0)
				ans += i;
		return (a < ans);
	}

	public static void main(String... args)
	{
		var k = 0;
		var a = new int[28123];
		for (var i = 1; i <= 28123; i++)
			if (take(i))
			{
				k++;
				a[k] = i;
			}
		var arr = new boolean[28123];
		for (var i = 0; i < arr.length; i++)
			arr[i] = false;
		for (var i = 1; i <= k - 1; i++)
			for (var j = i; j <= k; j++)
				if (a[i] + a[j] < 28123)
					arr[a[i] + a[j]] = true;
		var ans = 0;
		for (var i = 1; i < 28123; i++)
			if (!arr[i])
				ans += i;
		System.out.println(ans);
	}
}
