import java.util.Scanner;

public class Project082
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int[][] arr = new int[80][80];
		for (int i = 0; i < 80; i++)
			for (int j = 0; j < 80; j++)
				arr[i][j] = s.nextInt();
		int[] dp = new int[80];
		for (int i = 0; i < dp.length; i++)
			dp[i] = arr[i][79];
		for (int i = 78; i >= 0; i--)
		{
			dp[0] += arr[0][i];
			for (int j = 1; j < dp.length; j++)
				dp[j] = Library.min(dp[j] + arr[j][i], dp[j - 1] + arr[j][i]);
			for (int j = 78; j >= 0; j--)
				dp[j] = Library.min(dp[j], dp[j + 1] + arr[j][i]);
		}
		int min = Integer.MAX_VALUE;
		for (int aDp : dp)
			if (aDp < min)
				min = aDp;
		System.out.println(min);
	}
}
