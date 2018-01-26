import java.util.Scanner;

public class Project018
{
	public static void main(String[] args)
	{
		int n = 15;
		Scanner s = new Scanner(System.in);
		int[][] arr = new int[n + 1][n + 1];
		int[][] a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				arr[i][j] = s.nextInt();
		for (int i = 1; i <= n; i++)
			a[n][i] = arr[n][i];
		for (int i = n - 1; i >= 1; i--)
			for (int j = 1; j <= i; j++)
				a[i][j] = arr[i][j] + Library.max(a[i + 1][j], a[i + 1][j + 1]);
		System.out.println(a[1][1]);
	}
}