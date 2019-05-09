import java.util.stream.IntStream;

public class Project201 {
	public static void main(String[] args) {
		final int n = 100;
		final int value = 50;
		int[] arr = new int[n];
		IntStream.rangeClosed(1, n).forEach(i -> arr[i - 1] = i * i);
		int maxsum = 0;
		int minsum = 0;
		for (int i = 0; i < value; i++) {
			minsum += arr[i];
			maxsum += arr[n - i - 1];
		}
		int[][] x = new int[value + 1][maxsum + 1];
		int[][] y = new int[value + 1][maxsum + 1];
		y[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			x[0][0] = 1;
			for (int j = 1; j <= value; j++) {
				int e = arr[i - 1];
				if (e >= 0) System.arraycopy(y[j], 0, x[j], 0, e);
				for (int k = 0; k <= maxsum - e; k++) {
					x[j][k + e] = y[j - 1][k] + y[j][k + e];
				}
			}
			int[][] t = x;
			x = y;
			y = t;
		}
		int ans = 0;
		for (int s = minsum; s <= maxsum; s++)
			if (y[value][s] == 1)
				ans += s;
		System.out.println(ans);
	}

}