public class Project587 {
	public static void main(String[] args) {
		double y = (2240 + 1 - Math.sqrt(2 * 2240)) / (2240 * 2240 + 1);
		double x = 2240 * y;
		double L = 1 - Math.PI / 4;
		double alpha = Math.asin(1 - x);
		double s = (1 - x) * y - 0.5 * (alpha - (1 - x) * (1 - y)) + 0.5 * x * y;
		double ans = s / L;
		System.out.println(ans);
	}
}
