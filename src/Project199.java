public class Project199 {
	public static void main(String[] args) {
		int size = 10;
		double k1 = 1;
		double k0 = k1 * (3 - 2 * Math.sqrt(3));
		double a0 = 1 / (k0 * k0);
		double a1 = 3 / (k1 * k1);
		a1 += 3 * getArea(k0, k1, k1, size);
		a1 += getArea(k1, k1, k1, size);
		System.out.println((a0 - a1) / a0);
	}

	public static double getArea(double k1, double k2, double k3, int depth) {
		if (depth == 0)
			return 0.0;
		double k4 = k1 + k2 + k3 + 2 * Math.sqrt(k1 * k2 + k2 * k3 + k3 * k1);
		double a = 1 / (k4 * k4);
		a += getArea(k1, k2, k4, depth - 1);
		a += getArea(k2, k3, k4, depth - 1);
		a += getArea(k3, k1, k4, depth - 1);
		return a;
	}
}