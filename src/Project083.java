import java.util.Scanner;

public class Project083
{
	private static int[][] dp = new int[80][80];

	private static int path(int x, int y)
	{
		if (x < 0 || y < 0 || x >= 80 || y >= 80)
			return Integer.MAX_VALUE;
		return dp[y][x];
	}

	public static void main(String[] args)
	{
		var s = new Scanner(System.in);
		var arr = new int[80][80];
		for (var i = 0; i < 80; i++)
			for (var j = 0; j < 80; j++)
			{
				arr[i][j] = s.nextInt();
				dp[i][j] = Integer.MAX_VALUE / 2;
			}
		dp[0][0] = arr[0][0];
		for (var i = 0; i < 80 * 80; i++)
			for (var j = 0; j < 80; j++)
				for (var k = 0; k < 80; k++)
				{
					var t = Library.min(path(k - 1, j), Library.min(path(k + 1, j), Library.min(path(k, j + 1), path(k, j - 1))));
					dp[j][k] = Library.min(arr[j][k] + t, dp[j][k]);
				}
		System.out.println(dp[79][79]);
	}
}
