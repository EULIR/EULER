public class Project103
{
	public static void main(String args[])
	{
		int n[] = {22, 33, 39, 42, 44, 45, 46};
		for (var m = 271; m >= 200; m--)
			for (n[6] = 60; n[6] >= 7; n[6]--)
				for (n[5] = n[6] - 1; n[5] >= 6; n[5]--)
					for (n[4] = n[5] - 1; n[4] >= 5; n[4]--)
						for (n[3] = n[4] - 1; n[3] >= 4; n[3]--)
							for (n[2] = n[3] - 1; n[2] >= 3; n[2]--)
							{
								if (n[2] + n[3] + n[4] + n[5] + n[6] > m - 3)
									continue;
								for (n[1] = n[2] - 1; n[1] >= 2; n[1]--)
								{
									if (n[1] + n[2] + n[3] + n[4] + n[5] + n[6] > m - 1)
										continue;
									n[0] = m - (n[1] + n[2] + n[3] + n[4] + n[5] + n[6]);
									if (n[0] > n[1] || n[0] <= 0)
										continue;
									var valid = false;
									if ((n[0] + n[1] + n[2] + n[3] > n[4] + n[5] + n[6]) && (n[0] + n[1] + n[2] > n[5] + n[6]) && (n[0] + n[1] > n[6]))
									{
										valid = true;
										for (var i = 1; i <= 127; i++)
											for (var j = 1; j <= 127; j++)
											{
												if ((i & j) > 0)
													continue;
												var sum1 = 0;
												var sum2 = 0;
												var k1 = 0;
												var l1 = 0;
												for (var k = 1; k <= 64; k = k * 2)
												{
													if ((i & k) > 0)
														sum1 = sum1 + n[k1];
													k1++;
												}
												for (var l = 1; l <= 64; l = l * 2)
												{
													if ((j & l) > 0)
														sum2 = sum2 + n[l1];
													l1++;
												}
												if (sum1 == sum2)
												{
													valid = false;
													break;
												}
											}
									}
									if (valid)
									{
										System.out.println(n[0] + "" + n[1] + "" + n[2] + "" + n[3] + "" + n[4] + "" + n[5] + "" + n[6]);
									}
								}
							}
	}
}