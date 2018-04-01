public class Project006
{
	public static void main(String[] args)
	{
		var sum1 = 0;
		var sum2 = 0;
		for (var i = 1; i <= 100; i++)
		{
			sum1 += i * i;
			sum2 += i;
		}
		sum2 = sum2 * sum2;
		var ans = sum2 - sum1;
		System.out.println(ans);
	}
}