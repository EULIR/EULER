public class Project15
{
	public static void main(String[] args)
	{
		int n = 20;
		long[][] a = new long[n + 1][n + 1];
		for (int i = 0;i <= n;i++)
		{
			a[0][i] = 1;
			a[i][0] = 1;
		}
		for (int i = 1;i <= n;i++)
			for (int j = 1;j <= n;j++)
				a[i][j] = a[i - 1][j] + a[i][j - 1];
		System.out.println(a[n][n]);
	}
}