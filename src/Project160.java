public class Project160 {
	public static void main(String[] args) {
		long ans = 1;
		for (int i = 1; i <= 2560000; i++) {
			ans *= i;
			while (ans % 10 == 0)
				ans /= 10;
			ans %= 10000000;
		}
		System.out.println(ans % 100000);
	}
}