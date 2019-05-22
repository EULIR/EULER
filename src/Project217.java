import java.util.stream.IntStream;

public class Project217 {
	public static void main(String[] args) {
		int mod = IntStream.range(0, 15).map(i -> 3).reduce(1, (a, b) -> a * b);
		int MAX = 50;
		int[][] sum = new int[MAX][10 * MAX];
		int[][] count = new int[MAX][10 * MAX];
		int mid = 5 * MAX;
		int ans = 0;
		for (int n = 1; n <= 47; n++) {
			for (int i = 0; i <= n; i++)
				for (int j = -mid + 10; j < mid - 10; j++)
					if (i == 0) {
						sum[i][j + mid] = 0;
						count[i][j + mid] = (j == 0) ? 1 : 0;
					} else {
						int w = 0;
						if (n % 2 == 0 && i > n / 2) w = 1;
						if (n % 2 == 0 && i <= n / 2) w = -1;
						if (n % 2 == 1 && i > n / 2 + 1) w = 1;
						if (n % 2 == 1 && i <= n / 2) w = -1;
						sum[i][j + mid] = 0;
						count[i][j + mid] = 0;
						for (int k = 0; k <= 9; k++) {
							if (k == 0 && i == 1) continue;
							int ct = count[i - 1][j - w * k + mid];
							count[i][j + mid] = (count[i][j + mid] + ct) % mod;
							sum[i][j + mid] = (sum[i][j + mid] + 10 * sum[i - 1][j - w * k + mid] + ct * k) % mod;
						}
					}
			ans = (ans + sum[n][mid]) % mod;
		}
		System.out.println(ans);
	}
}