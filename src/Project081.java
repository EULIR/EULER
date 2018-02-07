import java.util.Scanner;

public class Project081
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int[][] arr = new int[80][80];
		for (int i = 0; i < 80; i++)
			for (int j = 0; j < 80; j++)
				arr[i][j] = s.nextInt();
		int[][] dp = new int[80][80];
		dp[0][0] = arr[0][0];
		for (int i = 1; i < 80; i++)
			dp[0][i] = dp[0][i - 1] + arr[0][i];
		for (int i = 1; i < 80; i++)
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		for (int i = 1; i < 80; i++)
			for (int j = 1; j < 80; j++)
				dp[i][j] = arr[i][j] + Library.min(dp[i - 1][j], dp[i][j - 1]);
		System.out.println(dp[79][79]);
	}
}
