import java.util.Arrays;
import java.util.stream.IntStream;

public class Project214 {
	public static int M = 40000000;
	public static int[] fact;
	public static int[] tot;

	public static void main(String[] args) {
		int[] primes = new int[4000000];
		boolean[] sieve = new boolean[M + 1];
		IntStream.iterate(2, k -> k < M, k -> k + 2).forEach(k -> {
			sieve[k] = false;
			sieve[k + 1] = true;
		});
		int num = 1;
		primes[0] = 2;
		while (true) {
			int i = primes[num - 1] + 1;
			while (i < M) {
				if (sieve[i])
					break;
				i++;
			}
			if (i == M)
				break;
			primes[num++] = i;
			int j = i * 2;
			while (j < M) {
				sieve[j] = false;
				j += i;
			}
		}
		fact = new int[M];
		tot = new int[M];
		Arrays.fill(fact, 1);
		for (int i = 2; i < M; i++)
			if (fact[i] == 1) {
				for (int k = i + i; k < M; k += i)
					if (fact[k] == 1)
						fact[k] = i;
			}
		for (int i = 2; i < M; i++)
			tot[i] = phi(i);
		long ans = 0;
		for (int i = 0; i < num; i++) {
			int p = primes[i];
			if (chain(p) == 25)
				ans += p;
		}
		System.out.println(ans);
	}

	public static int phi(int x) {
		if (x <= 1)
			return 1;
		int f = fact[x];
		if (f == 1)
			return x - 1;
		int p = 1;
		int fp = 1;
		while ((x /= f) % f == 0) {
			p++;
			fp *= f;
		}
		return phi(x) * (f - 1) * fp;
	}

	public static int chain(int p) {
		int len = 1;
		while (p > 1) {
			p = tot[p];
			len++;
			if (len > 25)
				return 26;
		}
		return len;
	}
}