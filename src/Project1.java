public class Project1
{
	public static void main(String... args)
	{
		boolean[] booleans = new boolean[1000];
		for (int i = 1; i < 1000; i++)
			booleans[i] = false;
		int ans = 0;
		for (int i = 0; i < 1000; i += 3)
			booleans[i] = true;
		for (int j = 0; j < 1000; j += 5)
			booleans[j] = true;
		for (int i = 1; i < 1000; i++)
			if (booleans[i])
				ans += i;
		System.out.println(ans);
	}
}