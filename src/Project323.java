public class Project323 {
	public static void main(String[] args) {
		double[][] arr = new double[51][51];
		arr[0][0] = 1.0D;
		//arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]
		for (int i = 1; i <= 50; i++) {
			arr[i][0] = 1;
			for (int j = 1; j <= i; j++)
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
		}
		double[] p = new double[51];
		double[][] arr2 = new double[51][51];
		p[0] = 1;
		for (int i = 1; i <= 50; i++) {
			p[i] = p[i - 1] * 2;
			for (int j = 0; j <= i; j++)
				arr2[i][j] = arr[i][j] / p[i];
		}
		double[] dp = new double[51];
		for (int i = 1; i <= 32; i++) {
			dp[i] = 1.0D;
			for (int j = 1; j <= i; j++)
				dp[i] += arr2[i][j] * dp[i - j];
			dp[i] = dp[i] / (1.0D - arr2[i][0]);
		}
		System.out.println(dp[32]);
	}
}
