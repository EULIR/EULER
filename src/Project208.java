import java.util.stream.IntStream;

public class Project208 {
	public static void main(String[] args) {
		int[][] arr = new int[15][15];
		arr[0][0] = 1;
		IntStream.range(1, 15).forEach(i -> arr[i][0] = 1);
		IntStream.range(1, 15).forEach(i -> arr[i][i] = 1);
		for (int i = 1; i < 15; i++)
			for (int j = 1; j < i; j++)
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
		int max = 14;
		long ans = 0;
		for (int n = 0; n < max; n++) {
			ans += Library.power(arr[max - 1][n], 5);
			if (n > 0) {
				ans += Library.power(arr[max - 1][n], 4) * Library.power(arr[max - 1][n - 1], 1);
				ans += Library.power(arr[max - 1][n], 3) * Library.power(arr[max - 1][n - 1], 2);
				ans += Library.power(arr[max - 1][n], 2) * Library.power(arr[max - 1][n - 1], 3);
				ans += Library.power(arr[max - 1][n], 1) * Library.power(arr[max - 1][n - 1], 4);
			}
		}
		System.out.println(ans * 2);
	}
}
