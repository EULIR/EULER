public class Project613 {
	public static void main(String[] args) {
		long ITT = (long) 500000000;
		double area = 0.0;
		double pro = 0.0;
		for (long i = 0; i < ITT - 1; i++) {
			double i_old = (double) i / ITT;
			double i_new = (double) (i + 1) / ITT;
			double a_old = Math.PI / 2.0 + (Math.PI / 2.0) * i_old;
			double a_new = Math.PI / 2.0 + (Math.PI / 2.0) * i_new;
			double A = area(a_old) - area(a_new);
			double prob = 0.5 * (a_old + a_new) / (2.0 * Math.PI);
			area += A;
			pro += prob * A;
		}
		System.out.println(pro / area);
	}

	static double area(double theta) {
		double r = rad(theta);
		double a = 2.0 * (Math.PI - theta);
		double base_area = 0.5 * r * r * (a - Math.sin(a));
		double other_area = 0.0;
		double[] info = arc_info(r);
		if (info[0] != 0.0) {
			double d = info[0];
			double b = 2.0 * Math.asin((0.5 * d) / r);
			other_area += 0.5 * r * r * (b - Math.sin(b));
		}
		if (info[1] != 0.0) {
			double d = info[1];
			double b = 2.0 * Math.asin((0.5 * d) / r);
			other_area += 0.5 * r * r * (b - Math.sin(b));
		}
		return base_area - other_area;
	}

	static double[] arc_info(double R) {
		double t1 = 24.0 * Math.sqrt(R * R - 625.0);
		double x1 = (450.0 - t1) / 25.0;
		double x2 = (450.0 + t1) / 25.0;
		if (x1 < 0.0) x1 = 0.0;
		if (x2 > 50.0) x2 = 50.0;
		double y1 = (4.0 / 3.0) * x1;
		double y2 = -(3.0 / 4.0) * (x2 - 50.0);
		double[] ret = new double[2];
		ret[0] = distance(0.0, x1, y1);
		ret[1] = distance(50.0, x2, y2);
		return ret;
	}

	static double distance(double x1, double x2, double y2) {
		return Math.sqrt(((x1 - x2) * (x1 - x2) + (0.0 - y2) * (0.0 - y2)));
	}

	static double rad(double theta) {
		return 25.0 / (Math.sin(Math.PI - theta));
	}
}