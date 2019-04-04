import java.util.Arrays;
import java.util.stream.IntStream;

public class Project461 {
	public static void main(String[] args) {
		int n = 14211;
		int m = 10000;
		double[] arr1 = new double[80000000];
		double[] arr2 = new double[n + 1];
		IntStream.rangeClosed(0, n).forEach(i -> arr2[i] = Math.expm1((double) i / m));
		int p = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = i; j <= n; j++)
				if (arr2[i] + arr2[j] <= Math.PI)
					arr1[p++] = arr2[i] + arr2[j];
				else break;
		}
		Arrays.sort(arr1, 0, p);
		double min = 9;
		double minu = 0;
		double minv = 0;
		int q = p - 1;
		for (int i = 0; i < p; i++) {
			while (q >= 0 && arr1[i] + arr1[q] > Math.PI)
				q--;
			if (Math.PI - (arr1[i] + arr1[q]) < min) {
				min = Math.PI - (arr1[i] + arr1[q]);
				minu = arr1[i];
				minv = arr1[q];
			}
			if (q + 1 < p) {
				if ((arr1[i] + arr1[q + 1]) - Math.PI < min) {
					min = (arr1[i] + arr1[q + 1]) - Math.PI;
					minu = arr1[i];
					minv = arr1[q + 1];
				}
			}
			if (i > q) break;
		}
		int ans = 0;
		for (int i = 0; i <= n; i++)
			for (int j = i; j <= n; j++)
				if (arr2[i] + arr2[j] <= Math.PI) {
					if (arr2[i] + arr2[j] == minu)
						ans += i * i + j * j;
					if (arr2[i] + arr2[j] == minv)
						ans += i * i + j * j;
				} else break;
		System.out.println(ans);
	}
}
