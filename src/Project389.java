public class Project389 {
	public static void main(String[] args) {
		double[] arr = {4, 6, 8, 12, 20};
		double a;
		double b;
		double c = 1;
		double d = 0;
		for (double dice : arr) {
			a = (dice + 1) / 2;
			b = (dice * dice - 1) / 3;
			d = d * a + c * c * b;
			c *= a;
		}
		System.out.println(d + c - c * c);
	}
}
