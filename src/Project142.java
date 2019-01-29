public class Project142 {
	public static void main(String[] args) {
		long a, b, c, d, e, f;
		boolean confirm = false;
		long ans = 0;
		for (long i = 4; !confirm; i++) {
			a = i * i;
			for (long j = 3; j < i && !confirm; j++) {
				c = j * j;
				f = a - c;
				if (f <= 0 || !Library.isSquare(f)) continue;
				long begin = (j % 2 == 1) ? 1 : 2;
				for (long k = begin; k < j; k += 2) {
					d = k * k;
					e = a - d;
					b = c - e;
					if (b <= 0 || e <= 0 || !Library.isSquare(b) || !Library.isSquare(e))
						continue;
					long x = (d + c) / 2;
					long y = (e + f) / 2;
					long z = (c - d) / 2;
					ans = x + y + z;
					confirm = true;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
