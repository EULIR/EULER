public class Project129 {
	public static int calculate(int n) {
		if (Library.gcd(n, 10) != 1)
			return 0;
		var i = 1;
		var num = 1;
		do {
			i = (i * 10 + 1) % n;
			num++;
		} while (i != 0);
		return num;
	}

	public static void main(String[] args) {
		final var MAX = 1000001;
		var n = MAX;
		while (calculate(n) < MAX)
			n += 2;
		System.out.println(n);
	}
}
