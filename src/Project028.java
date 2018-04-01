public class Project028
{
	public static void main(String[] args)
	{
		var sum = 1;
		for (var n = 3; n <= 1001; n += 2)
		{
			sum += 4 * Math.pow(n, 2) - 6 * n + 6;
		}
		System.out.println(sum);
	}
}
