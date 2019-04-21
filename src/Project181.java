import java.util.stream.IntStream;

public class Project181 {
	public static void main(String[] args) {
		int x = 60;
		int y = 40;
		long arr1[][][] = new long[x + 1][y + 1][x + y + 1];
		long arr2[][][] = new long[x + 1][y + 1][x + y + 1];
		for (int i = 1; i <= y + x; i++) {
			arr1[0][0][i]++;
			for (int j = 0; j <= i; j++)
				for (int k = 0; k <= x - j; k++)
					for (int l = 0; l <= y - (i - j); l++)
						arr1[k + j][l + i - j][i] += arr1[k][l][i];
		}
		arr2[0][0][0] = 1;
		for (int i = 0; i <= y + x; i++) {
			for (int j = 0; j <= x; j++)
				for (int k = 0; k <= y; k++)
					if (j + k >= i)
						for (int l = i + 1; l <= x + y; l++)
							for (int m = l; j + k + m <= x + y; m += l)
								for (int n = Math.max(0, k + m - y); n <= m && j + n <= x; n++) {
									int dw = m - n;
									arr2[j + n][k + dw][l] += arr2[j][k][i] * arr1[n][dw][l];
								}
		}
		long ans = IntStream.rangeClosed(0, x + y).mapToLong(i -> arr2[x][y][i]).sum();
		System.out.println(ans);
	}
}
