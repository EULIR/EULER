public class Project518 {
	public static void main(String[] args) {
		long answer = 0;
		final int MAX = 100000000;
		boolean[] prime = new boolean[MAX + 5];
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) for (int j = i; j < MAX; j += i)
				prime[j] = true;
		for (int i = 1; i * i <= MAX; i++)
			for (int j = i + 1; j * j <= MAX; j++)
				if (Library.gcd(i, j) == 1) {
					for (int k = 1; k <= MAX / (j * j); k++) {
						if (!prime[k * i * i - 1] && !prime[k * j * j - 1] && !prime[k * i * j - 1]) {
							answer += (k * (i * i + i * j + j * j));
							answer -= 3;
						}
					}
				}
		System.out.println(answer);
	}
}
