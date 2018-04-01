public class Project061
{
	private static boolean judge(int i)
	{
		return Library.isHeptagonal(i) || Library.isHexagonal(i) || Library.isOctagonal(i) || Library.isPentagonal(i) || Library.isSquare(i) || Library.isTriangle(i);
	}

	private static void judge(int t1, int t2, int t3, int t4, int t5, int t6)
	{
		var boo = new boolean[6];
		int[] arr = {t1, t2, t3, t4, t5, t6};
		for (var t : arr)
			if (Library.isOctagonal(t))
				boo[0] = true;
			else if (Library.isHeptagonal(t))
				boo[1] = true;
			else if (Library.isHexagonal(t))
				boo[2] = true;
			else if (Library.isPentagonal(t))
				boo[3] = true;
			else if (Library.isSquare(t))
				boo[4] = true;
			else if (Library.isTriangle(t))
				boo[5] = true;
		for (var aboo : boo)
			if (!aboo)
				return;
		System.out.println(t1 + t2 + t3 + t4 + t5 + t6);
		System.exit(0);
	}

	public static void main(String[] args)
	{
		for (var i = 10; i < 100; i++)
			for (var j = 10; j < 100; j++)
			{
				var t1 = 100 * i + j;
				if (judge(t1))
					for (var k = 10; k < 100; k++)
					{
						var t2 = 100 * j + k;
						if (judge(t2))
							for (var l = 10; l < 100; l++)
							{
								var t3 = 100 * k + l;
								if (judge(t3))
									for (var m = 10; m < 100; m++)
									{
										var t4 = 100 * l + m;
										if (judge(t4))
											for (var n = 10; n < 100; n++)
											{
												var t5 = 100 * m + n;
												if (judge(t5))
												{
													var t6 = 100 * n + i;
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
