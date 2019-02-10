public class Project151 {
	public static void main(String[] args) {
		System.out.println(calculate(1D, 1D, 1D, 1D));
	}

	public static double calculate(double a, double b, double c, double d) {
		if (a == 0 && b == 0 && c == 0 && d == 1)
			return 0;
		if (a == 0 && b == 0 && c == 1 && d == 0)
			return 1 + calculate(0, 0, 0, 1);
		if (a == 0 && b == 1 && c == 0 && d == 0)
			return 1 + calculate(0, 0, 1, 1);
		if (a == 1 && b == 0 && c == 0 && d == 0)
			return 1 + calculate(0, 1, 1, 1);
		var e = a > 0 ? a * calculate(a - 1, b + 1, c + 1, d + 1) : 0;
		var f = b > 0 ? b * calculate(a, b - 1, c + 1, d + 1) : 0;
		var g = c > 0 ? c * calculate(a, b, c - 1, d + 1) : 0;
		var h = d > 0 ? d * calculate(a, b, c, d - 1) : 0;
		return (e + f + g + h) / (a + b + c + d);
	}
}