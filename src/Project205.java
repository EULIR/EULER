public class Project205 {
	public static void main(String[] args) {
		long num = 0;
		for (int i = 1; i <= 4; i++)
			for (int j = 1; j <= 4; j++)
				for (int k = 1; k <= 4; k++)
					for (int l = 1; l <= 4; l++)
						for (int m = 1; m <= 4; m++)
							for (int n = 1; n <= 4; n++)
								for (int o = 1; o <= 4; o++)
									for (int p = 1; p <= 4; p++)
										for (int q = 1; q <= 4; q++)
											for (int r = 1; r <= 6; r++)
												for (int s = 1; s <= 6; s++)
													for (int t = 1; t <= 6; t++)
														for (int u = 1; u <= 6; u++)
															for (int v = 1; v <= 6; v++)
																for (int w = 1; w <= 6; w++)
																	if (i + j + k + l + m + n + o + p + q > r + s + t + u + v + w)
																		num++;
		System.out.println((double) num / 12230590464L);
	}
}
