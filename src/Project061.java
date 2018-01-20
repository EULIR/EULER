public class Project061
{
	private static boolean isOctagonal(int a)
	{
		int t = 3 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 3 == 2;
	}

	private static boolean isHeptagonal(int a)
	{
		int t = 40 * a + 9;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 10 == 7;
	}

	private static boolean isPentagonal(int a)
	{
		int t = 24 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 6 == 5;
	}

	private static boolean isHexagonal(int a)
	{
		int t = 8 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 4 == 3;
	}

	private static boolean isTriangle(int a)
	{
		int t = a * 2;
		return Math.floor(Math.sqrt(t)) * (Math.floor(Math.sqrt(t)) + 1) / 2 == a;
	}

	private static boolean isSquare(int a)
	{
		int b = (int) Math.sqrt(a);
		return b * b == a;
	}

	private static boolean judge(int i)
	{
		return isHeptagonal(i) || isHexagonal(i) || isOctagonal(i) || isPentagonal(i) || isSquare(i) || isTriangle(i);
	}

	private static void judge(int t1, int t2, int t3, int t4, int t5, int t6)
	{
		boolean[] boo = new boolean[6];
		int[] arr = {t1, t2, t3, t4, t5, t6};
		for (int t : arr)
			if (isOctagonal(t))
				boo[0] = true;
			else if (isHeptagonal(t))
				boo[1] = true;
			else if (isHexagonal(t))
				boo[2] = true;
			else if (isPentagonal(t))
				boo[3] = true;
			else if (isSquare(t))
				boo[4] = true;
			else if (isTriangle(t))
				boo[5] = true;
		for (boolean aboo : boo)
			if (!aboo)
				return;
		System.out.println(t1 + t2 + t3 + t4 + t5 + t6);
		System.exit(0);
	}

	public static void main(String[] args)
	{
		for (int i = 10; i < 100; i++)
			for (int j = 10; j < 100; j++)
			{
				int t1 = 100 * i + j;
				if (judge(t1))
					for (int k = 10; k < 100; k++)
					{
						int t2 = 100 * j + k;
						if (judge(t2))
							for (int l = 10; l < 100; l++)
							{
								int t3 = 100 * k + l;
								if (judge(t3))
									for (int m = 10; m < 100; m++)
									{
										int t4 = 100 * l + m;
										if (judge(t4))
											for (int n = 10; n < 100; n++)
											{
												int t5 = 100 * m + n;
												if (judge(t5))
												{
													int t6 = 100 * n + i;
													if (judge(t6))
														judge(t1, t2, t3, t4, t5, t6);
												}
											}
									}
							}
					}

			}
	}
}
