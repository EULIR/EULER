public class Project443 {
	public static void main(String[] args) {
		long s = 13;
		long g;
		long p = 0;
		long i = 5;
		long c;
		long pre = i;
		while (i <= 1000000000000000L) {
			c = 0;
			while (c < 4700000) {
				g = Library.gcd(s, i);
				s += g;
				if (g > 1) {
					c = 0;
					pre = i;
					p = s;
				} else c++;
				i++;
			}
			s += 2 * pre - i;
			i = 2 * pre - 1;
		}
		System.out.println(p + 1000000000000000L - pre);
	}
}
