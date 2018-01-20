public class Project023
{
	private static boolean take(int a)
	{
		int ans = 0;
		for (int i = 1; i < a / 2 + 1; i++)
			if (a % i == 0)
				ans += i;
		return (a < ans);
	}

	public static void main(String... args)
	{
		int k = 0;
		int[] a = new int[28123];
		for (int i = 1; i <= 28123; i++)
			if (take(i))
			{
				k++;
				a[k] = i;
			}
		boolean[] arr = new boolean[28123];
		for (int i = 0; i < arr.length; i++)
			arr[i] = false;
		for (int i = 1; i <= k - 1; i++)
			for (int j = i; j <= k; j++)
				if (a[i] + a[j] < 28123)
					arr[a[i] + a[j]] = true;
		int ans = 0;
		for (int i = 1; i < 28123; i++)
			if (!arr[i])
				ans += i;
		System.out.println(ans);
	}
}
