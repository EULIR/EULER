public class Project006
{
	public static void main(String[] args)
	{
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i <= 100; i++)
		{
			sum1 += i * i;
			sum2 += i;
		}
		sum2 = sum2 * sum2;
		int ans = sum2 - sum1;
		System.out.println(ans);
	}
}