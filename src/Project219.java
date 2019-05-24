public class Project219 {
	public static void main(String[] args) {
		long n = 1000000000;
		long m = 0;
		long a = 1;
		long b = 0;
		long c = 0;
		long d = 0;
		long e = 0;
		n--;
		while (n > 0) {
			if (n >= a) {
				n -= a;
				b += a;
				e += a;
				a = b;
				b = c;
				c = d;
				d = e;
				e = 0;
				m++;
			} else {
				a -= n;
				b += n;
				e += n;
				n = 0;
			}
		}
		long ans = a * m + b * (m + 1) + c * (m + 2) + d * (m + 3) + e * (m + 4);
		System.out.println(ans);
	}
}
