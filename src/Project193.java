import java.util.stream.LongStream;

public class Project193 {
	public static void main(String args[]) {
		long ans = 33554432;
		ans *= 33554432;
		long y = ans;
		ans += LongStream.rangeClosed(2, 33554432).filter(i -> func(i) != 0).map(i -> func(i) * (y / (i * i))).sum();
		System.out.println(ans);
	}

	static int func(long n) {
		if (n <= 3)
			return -1;
		if (n % 4 == 0)
			return 0;
		int result = 1;
		if (n % 2 == 0) {
			result = result * (-1);
			n = n / 2;
		}
		long p = 3;
		while (p * p <= n) {
			if (n % (p * p) == 0)
				return 0;
			if (n % p == 0) {
				result = result * (-1);
				n = n / p;
			}
			p = p + 2;
		}
		if (n > 1) result = result * -1;
		return result;
	}
}
