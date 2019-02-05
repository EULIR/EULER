public class Project146 {
	public static void main(String[] args) {
		final int MAX = Integer.MAX_VALUE - 1;
		boolean[] prime = new boolean[MAX];
		for (int i = 2; i < MAX; i++)
			if (!prime[i])
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
		int ans = 0;
		for (int i = 2; i < Math.sqrt(MAX - 27); i++) {
			if (prime[i * i + 1] && prime[i * i + 3] && prime[i * i + 7] && prime[i * i + 9] && prime[i * i + 13] && prime[i * i + 27])
				ans += i;
		}
		System.out.println(ans);
	}
}
