public class Project458 {
	public static void main(String[] args) {
		final int length = 7;
		final int size = 6;
		final int n = 1000000000;
		final long NUM = 1000000000000L;
		long[] s = new long[size];
		long[][] p = new long[size][size];
		s[0] = length;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (i == j + 1)
					p[i][j] = length - i;
				else if (i > j)
					p[i][j] = 0;
				else p[i][j] = 1;
			}
		long d = NUM - 1;
		while (d > 0) {
			if (d % 2 > 0) {
				long[] z = new long[size];
				for (int i = 0; i < size; i++) {
					for (int k = 0; k < size; k++)
						z[i] += (p[i][k] * s[k]) % n;
					z[i] %= n;
				}
				s = z;
			}
			d /= 2;
			long[][] z = new long[size][size];
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < size; k++)
						z[i][j] += (p[i][k] * p[k][j]) % n;
					z[i][j] %= n;
				}
			p = z;
		}
		long a = 0;
		for (int i = 0; i < size; i++)
			a += s[i];
		System.out.println(a % n);
	}

}