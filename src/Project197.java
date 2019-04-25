public class Project197 {
	public static void main(String[] args) {
		double d1 = -1D;
		double d2 = 0D;
		while (true) {
			double t1 = Math.floor(Math.pow(2, 30.403243784 - d1 * d1)) * 0.000000001;
			double t2 = Math.floor(Math.pow(2, 30.403243784 - t1 * t1)) * 0.000000001;
			if (t1 == d2 && t2 == d1) {
				System.out.println(d1 + d2);
				break;
			} else {
				d1 = t2;
				d2 = t1;
			}
		}
	}
}
