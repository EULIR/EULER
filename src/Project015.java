public class Project015
{
	public static void main(String[] args)
	{
		var n = 20;
		var a = new long[n + 1][n + 1];
		for (var i = 0; i <= n; i++)
		{
			a[0][i] = 1;
			a[i][0] = 1;
		}
		for (var i = 1; i <= n; i++)
			for (var j = 1; j <= n; j++)
				a[i][j] = a[i - 1][j] + a[i][j - 1];
		System.out.println(a[n][n]);
	}
}