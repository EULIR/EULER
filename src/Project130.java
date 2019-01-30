public class Project130 {
	public static int calculate(int x) {
		if (x % 2 == 0 || x % 5 == 0)
			return 0;
		int num;
		int t = num = 1;
		while (t != 0) {
			num++;
			t = (t * 10 + 1) % x;
		}
		return num;
	}

	public static void main(String[] args) {
		int num = 0;
		int ans = 0;
		for (int i = 10; num < 25; i++)
			if (i % 5 != 0 && i % 2 != 0 && !Library.isPrime(i) && (i - 1) % calculate(i) == 0) {
				num++;
				ans += i;
			}
		System.out.println(ans);
	}
}
