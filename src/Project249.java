import java.util.stream.IntStream;

public class Project249 {
	public static void main(String[] args) {
		long mod = (long) Math.pow(10, 16);
		int limit = 1600000;
		boolean[] prime = new boolean[limit + 5];
		for (int i = 2; i < limit; i++)
			if (!prime[i]) {
				for (int j = i; j < limit; j += i)
					prime[j] = true;
			}
		long[] arr = new long[limit];
		IntStream.range(1, limit).forEach(i -> arr[i] = 0);
		arr[0] = 1;
		for (int i = 2; i < 5000; i++)
			if (prime[i])
				for (int j = limit - i - 1; j >= 0; j--)
					arr[j + i] = (arr[j + i] + arr[j]) % mod;
		long ans = 0;
		for (int i = 2; i < limit; i++)
			if (prime[i]) {
				ans += arr[i];
				ans %= mod;
			}
		ans = ans % mod;
		System.out.println(ans);
	}
}
