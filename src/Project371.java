import java.util.Arrays;

public class Project371 {
	public static void main(String[] args) {
		int n = 1000;
		double[] odd = new double[n];
		double[] arr = new double[n];
		double[] arr2 = new double[n];
		double[] c = new double[n];
		double e = 0;
		odd[0] = 1;
		for (int i = 1; i < 250; i++) {
			for (int j = 0; j + j <= n; j++) {
				e += odd[j] * i * j / n;
				arr2[j] += (odd[j] * (j + 1)) / n;
				c[j + 1] += (odd[j] * 1) / n;
				arr2[j + 1] += (odd[j] * (n - j - j - 2)) / n;
				e += (arr[j] * i * j) / n;
				c[j] += (arr[j] * j) / n;
				c[j + 1] += (arr[j] * (n - j - j)) / n;
			}
			double[] temp = odd;
			odd = arr2;
			arr2 = temp;
			Arrays.fill(arr2, 0);
			temp = arr;
			arr = c;
			c = temp;
			Arrays.fill(c, 0);
		}
		System.out.println(e);
	}
}
