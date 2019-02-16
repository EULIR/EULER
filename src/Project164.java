import java.util.stream.IntStream;

public class Project164 {
	public static void main(String[] args) {
		long[][][] arr = new long[20][10][10];
		IntStream.range(1, 10).forEach(i -> arr[0][0][i] = 1);
		for (int i = 1; i < 20; i++)
			for (int j = 0; j < 10; j++)
				for (int k = 0; k < 10; k++)
					for (int l = 0; j + k + l < 10; l++)
						arr[i][k][l] += arr[i - 1][j][k];
		long ans = 0;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				ans += arr[19][i][j];
		System.out.println(ans);
	}
}
