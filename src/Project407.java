import java.util.Arrays;

public class Project407 {
	public static int[] divisors(int n, int[] arr) {
		long num = (long) n;
		int p = arr[n];
		int cnt = 2;
		long powp = p;
		long pp = (long) p * p;
		while (num % pp == 0) {
			powp = pp;
			pp *= p;
			cnt++;
		}
		int nn = (int) (num / powp);
		if (nn == 1) {
			int[] divs = new int[cnt];
			divs[0] = 1;
			divs[1] = p;
			int i = 2;
			pp = (long) p * p;
			while (pp <= powp) {
				divs[i++] = (int) pp;
				pp *= p;
			}
			return divs;
		} else {
			int[] divsnn = divisors(nn, arr);
			int[] divs = new int[divsnn.length * cnt];
			int i = 0;
			for (int d : divsnn)
				divs[i++] = d;
			pp = p;
			while (pp <= powp) {
				for (int d : divsnn)
					divs[i++] = (int) (pp * d);
				pp *= p;
			}
			Arrays.sort(divs);
			return divs;
		}
	}

	public static void main(String[] args) {
		final int LIMIT = 10000000;
		int[] arr = new int[LIMIT + 1];
		arr[1] = 1;
		for (int i = 2; i <= LIMIT; i++)
			if (arr[i] == 0)
				for (int j = i; j <= LIMIT; j += i)
					arr[j] = i;
		int[] m = new int[LIMIT + 1];
		Arrays.fill(m, 2, LIMIT, 1);
		int[] div = new int[1];
		div[0] = 1;
		for (int i = 2; i <= LIMIT; i++) {
			int[] divisor = divisors(i, arr);
			for (int j = 0; j < divisor.length; j++) {
				int d = divisor[j];
				for (int k = 0; k < div.length; k++) {
					int d1 = div[k];
					long n = (long) d * d1;
					if (n > LIMIT) break;
					int o = (int) n;
					if (i < o && m[o] < i)
						m[o] = i;
				}
			}
			div = divisor;
		}
		long s = Arrays.stream(m).asLongStream().sum();
		System.out.println(s);
	}
}