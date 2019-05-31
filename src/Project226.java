public class Project226 {
	public static void main(String[] args) {
		double x1 = 0;
		double y1 = 0;
		double x2 = 0.5;
		double y2 = 0.5;
		double w = 0.5;
		double ans = 0.25;
		while (w > 0.0000000001) {
			double xc = (x1 + x2) / 2;
			double yc = (y1 + y2 + w) / 2;
			if (2 * xc + 4 * yc - 4 * xc * xc - 4 * yc * yc > 1) {
				w /= 2;
				x2 = xc;
				y2 = yc;
			} else {
				w /= 2;
				ans -= w * (y1 + yc + w) / 2;
				x1 = xc;
				y1 = yc;
			}
		}
		ans -= (0.5 - x1) * 0.5;
		x1 = 0.25 - x1;
		y1 = 0.5 - y1;
		ans += Math.atan2(y1, -x1) / 32 + x1 * y1 / 2;
		System.out.println(ans);
	}
}