public class Project021
{
	private static int make(int a)
	{
		var ans = 0;
		for (var i = 1; i <= a / 2 + 1; i++)
			if (a % i == 0)
				ans += i;
		return ans;
	}

	public static void main(String[] args)
	{
		int a[] = new int[10001];
		for (var i = 1; i <= 10000; i++)
			a[i] = make(i);
		var ans = 0;
		for (var i = 1; i <= 10000; i++)
			if (a[i] != i)
				if (a[i] <= 10000)
					if (a[a[i]] == i)
						ans += i;
		System.out.print(ans);
	}
}