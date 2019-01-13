public class Project131 {
	public static int p(int i) {
		return (i + 1) * (i + 1) * (i + 1) - i * i * i;
	}

	public static void main(String[] args) {
		int num = 0;
		for (int i = 1; p(i) < 1000000; i++) {
			if (Library.isPrime(p(i)))
				num++;
		}
		System.out.println(num);
	}
}
