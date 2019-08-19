public class Project307 {
	public static void main(String args[]) {
		double[] t = new double[10001];
		t[0] = 1.0D;
		double m = 0.0D;
		int i;
		int N = 1000000;
		int n = 2;
		while (n <= 20000) {
			i = 0;
			while (i <= n / 2) {
				double mem2 = t[i];
				t[i] = ((N + i - n + 1) * mem2 + (n - 2 * i + 1) * m) / N;
				m = mem2;
				i++;
			}
			n++;
		}
		double ans = 0.0;
		for (i = 0; i < 10001; i++)
			ans += t[i];
		System.out.println(1 - ans);
	}
}