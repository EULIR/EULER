public class Project317 {
	static int v = 20;
	static double g = 9.81;

	public static void main(String[] args) {
		double h1 = 100D;
		double h0 = -(v * v) / (2 * g);
		System.out.println(Math.PI * (s(h1) - s(h0)));
	}

	static double s(double h) {
		return (v * v / g) * h * h + (v * v * v * v / (g * g)) * h;
	}
}
