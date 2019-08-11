import java.util.stream.IntStream;

public class Project290 {
	static int digit(long n) {
		return IntStream.range(0, String.valueOf(n).length()).map(i -> String.valueOf(n).charAt(i) - '0').sum();
	}

	public static void main(String[] args) {
		final int maxD = 162;
		final int maxC = 999;
		long[][][][] arr = new long[2][maxD + 1][maxD + 1][maxC + 1];
		arr[0][0][0][0] = 1;
		for (int i = 0; i < 18; ++i) {
//			for (int j = 0; j <= maxD; ++j) {
//				for (int k = 0; k <= maxD; ++k) {
//					Arrays.fill(arr[(i + 1) & 1][j][k], 0);
//				}
//			}
			for (int j = 0; j <= maxD; ++j) {
				for (int k = 0; k <= maxD; ++k) {
					for (int m = 0; m <= maxC; ++m) {
						if (arr[i & 1][j][k][m] > 0) {
							for (int l = 0; l <= 9; ++l) {
								int t = m + 137 * l;
								int newcarry = t / 10;
								int newd1 = j + l;
								int newd2 = k + t % 10;
								arr[(i + 1) & 1][newd1][newd2][newcarry] += arr[i & 1][j][k][m];
							}
						}
					}
				}
			}
		}
		long ans = 0;
		for (int i = 0; i <= maxD; ++i)
			for (int j = 0; j <= i; ++j)
				for (int k = 0; k <= maxC; ++k)
					if (i == j + digit(k)) ans += arr[18 & 1][i][j][k];
		System.out.println(ans);
	}
}