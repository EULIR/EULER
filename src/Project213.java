public class Project213 {
	public static void main(String[] args) {
		double[][][][] arr = new double[900][2][30][30];
		for (int i = 0; i < 900; i++) {
			arr[i][0][i % 30][i / 30] = 1;
			for (int j = 1; j <= 50; j++) {
				int cur = j % 2;
				int prev = 1 - cur;
				arr[i][cur] = new double[30][30];
				for (int k = 0; k < 30; k++)
					for (int l = 0; l < 30; l++) {
						int sum = 4;
						if (k == 0 || k == 29)
							sum--;
						if (l == 0 || l == 29)
							sum--;
						int[] dx = {-1, 1, 0, 0};
						int[] dy = {0, 0, 1, -1};
						for (int m = 0; m < 4; m++) {
							int nx = k + dx[m];
							int ny = l + dy[m];
							if (nx < 0 || ny < 0 || nx >= 30 || ny >= 30)
								continue;
							arr[i][cur][nx][ny] += arr[i][prev][k][l] / sum;
						}
					}
			}
		}
		double ans = 0;
		for (int i = 0; i < 30; i++)
			for (int j = 0; j < 30; j++) {
				double p = 1;
				for (int k = 0; k < 900; k++)
					p *= 1 - arr[k][0][i][j];
				ans += p;
			}
		System.out.println(ans);
	}
}
