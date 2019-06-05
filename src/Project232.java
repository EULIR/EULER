import java.util.stream.IntStream;

public class Project232 {
	public static void main(String[] args) {
		int MAX = 100;
		double[][] arr1 = new double[MAX + 1][MAX + 1];
		IntStream.range(0, MAX).forEach(i -> arr1[MAX][i] = 1.0);
		double[][] arr2 = new double[MAX + 1][MAX + 1];
		for (int i = MAX - 1; i >= 0; i--)
			for (int j = MAX - 1; j >= 0; j--) {
				double np2 = arr1[i + 1][j];
				double base = 2;
				double a = 2;
				for (int t = 1, pt = 2; ; t++, pt *= 2) {
					int j2 = j + (pt / 2);
					if (j2 > MAX)
						j2 = MAX;
					double np1 = arr2[i][j2];
					double cp1 = (np1 + pt * np2) / (1 + pt);
					double cp2 = 2 * (np1 - np2) / (1 + pt) + np2;
					if (cp2 < base) {
						base = cp2;
						a = cp1;
					}
					if (j2 == MAX) break;
				}
				arr2[i][j] = a;
				arr1[i][j] = base;
			}

		System.out.println(1 - arr2[0][0]);
	}
}