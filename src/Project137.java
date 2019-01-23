public class Project137 {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(fibonacci(2 * n) * fibonacci(2 * n + 1));
	}

	public static long fibonacci(int n) {
		double a = (1 + Math.sqrt(5)) / 2;
		double b = (1 - Math.sqrt(5)) / 2;
		a = Library.power(a, n);
		b = Library.power(b, n);
		return (long) ((a - b) / Math.sqrt(5));
	}
}
