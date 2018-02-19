public class Project094
{
	private static boolean validTriangle(int a, int b, int c)
	{
		double p = (double) (a + b + c) / 2;
		return Library.isSquare((int) (p * (p - a) * (p - b) * (p - c)));
	}

	public static void main(String[] args)
	{
		System.out.println(validTriangle(2, 2, 3));
		long ans = 0;
		for (int i = 2; i <= (1000000000 + 1) / 3; i++)
		{
			int sideThree = i + 1;
			if (validTriangle(i, i, sideThree))
			{
				ans += 3 * i + 1;
				System.out.println(i);
			}
			sideThree = i - 1;
			if (validTriangle(i, i, sideThree))
			{
				ans += 3 * i - 1;
				System.out.println(i);
			}
		}
		System.out.println(ans);
	}
}
