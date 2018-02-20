public class Project094
{
	private static boolean validTriangle(long a, long c)
	{
		return c * c % 4 == 0 && Library.isSquare(a * a - c * c / 4) && c * (long) Math.sqrt(a * a - c * c / 4) % 2 == 0;
	}

	public static void main(String[] args)
	{
		long ans = 0;
		for (long i = 2; i <= 333333333; i++)
		{
			long sideThree = i + 1;
			if (validTriangle(i, sideThree))
				ans += 3 * i + 1;
			sideThree = i - 1;
			if (validTriangle(i, sideThree))
				ans += 3 * i - 1;
		}
		System.out.println(ans);
	}
}
