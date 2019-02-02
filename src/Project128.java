public class Project128 {
	public static void main(String[] args) {
		long[] arr = new long[2001];
		final int MAX = 10000000;
		boolean[] prime = new boolean[MAX + 5];
		for (int i = 2; i < MAX; i++)
			if (!prime[i])
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
		int step = 12;
		long t = 8;
		for (int i = 3; i <= 2000; t += step, step += 6) {
			if (prime[step - 1] && prime[step + 1] && prime[step + step + 5])
				arr[i++] = t;
			if (prime[step - 1] && prime[step + 5] && prime[step + step - 7])
				arr[i++] = t + step - 1;
		}
		System.out.println(arr[2000]);
	}
}
