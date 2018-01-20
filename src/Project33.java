public class Project33
{
	private static int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		else return gcd(b, a % b);
	}
	public static void main(String[] args)
	{
		int num = 1;
		int den = 1;
		for (int i = 10; i < 100; i++)
			for (int j = i + 1; j < 100; j++)
			{
				if (i % 11 == 0 && j % 11 == 0)
					continue;
				int a1 = i / 10;
				int a2 = i % 10;
				int b1 = j / 10;
				int b2 = j % 10;
				if (a2 == b1)
				{
					double k = (double) a1 / b2;
					double t = (double) i / j;
					if (k == t)
					{
						num *= i;
						den *= j;
						//System.out.print(i + " " + j + " ");
					}
				}
			}
		int g = gcd(num,den);
		//System.out.print(num + " " + den);
		System.out.print(den / g);
	}
}
