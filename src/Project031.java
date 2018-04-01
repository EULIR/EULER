public class Project031
{
	static int[] a = {1, 2, 5, 10, 20, 50, 100, 200};
	static int ans = 0;

	private static void change(int m, int k)
	{
		if (m == 0)
		{
			ans++;
			return;
		}
		if (a[k] > m)
			return;
		for (var i = k; i < a.length; i++)
			change(m - a[i], i);
	}

	public static void main(String[] args)
	{
		change(200, 0);
		System.out.print(ans);
	}
}
//int ans = 0;
//for (int i = 0; i <= 200; i++)
//	for (int j = 0; j <= 100; j++)
//		for (int k = 0; k <= 40; k++)
//			for (int l = 0; l <= 20; l++)
//				for (int m = 0; m <= 10; m++)
//					for (int n = 0; n <= 4; n++)
//						for (int o = 0; o <= 2; o++)
//							for (int p = 0; p <= 1; p++)
//								if (i + j * 2 + k * 5 + l * 10 + m * 20 + n * 50 + o * 100 + p * 200 == 200)
//									ans++;
//System.out.print(ans);
//*
//solution 1 is correct but stupid