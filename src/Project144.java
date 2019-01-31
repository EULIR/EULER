public class Project144 {
	public static void main(String[] args) {
		int ans = 0;
		double x1 = 0.0;
		double y1 = 10.1;
		double x2 = 1.4;
		double y2 = -9.6;
		while (x2 > 0.01 || x2 < -0.01 || y2 < 0) {
			double s1 = (y2 - y1) / (x2 - x1);
			double s2 = -4 * x2 / y2;
			double tan1 = (s1 - s2) / (1 + s1 * s2);
			double s3 = (s2 - tan1) / (1 + tan1 * s2);
			double i2 = y2 - s3 * x2;
			double a = 4 + s3 * s3;
			double b = 2 * s3 * i2;
			double c = i2 * i2 - 100;
			double ans1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			double ans2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			x1 = x2;
			y1 = y2;
			x2 = (Math.abs(ans1 - x2) > Math.abs(ans2 - x2)) ? ans1 : ans2;
			y2 = s3 * x2 + i2;
			ans++;
		}
		System.out.println(ans);
	}
}
