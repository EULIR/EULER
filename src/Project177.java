import java.util.stream.IntStream;

public class Project177 {
	public static void main(String[] args) {
		int ans = 0;
		double[] sin = new double[180];
		double[] cos = new double[180];
		IntStream.range(0, 180).forEach(i -> {
			sin[i] = Math.sin(Math.toRadians(i));
			cos[i] = Math.cos(Math.toRadians(i));
		});
		for (int i = 2; i <= 90; i++)
			for (int j = 1; j < 180 - i; j++) {
				double s = sin[j] / sin[i + j];
				for (int k = Math.max(i, j + 1); k <= 180 - i; k++)
					for (int l = k == i ? j : 1; l < Math.min(i, 180 - k); l++) {
						double euler = sin[k] / sin[k + l];
						double x = Math.toDegrees(Math.atan2(sin[l] * euler - sin[i] * s, cos[l] * euler - cos[i] * s));
						int y = (int) Math.round(x);
						int p = 180 - i + y, h = 180 - k - y;
						if (h < i) break;
						if (p < k) continue;
						if ((k == p) && (l > i / 2)) continue;
						if ((h == i) && (j > k / 2)) continue;
						if (Math.abs(x - y) < 0.0000000001) ans++;
					}
			}
		System.out.print(ans);
	}
}
