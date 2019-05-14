public class Project210 {
	public static void main(String[] args) {
		final long r = 1000000000;
		long ans = 2 * r * (r + 1) + 1 - ((2 * r + 1) * r / 4 + r + 1) - (r / 2 + r / 4) + count(r * r / 32) - (r / 4 - 1);
		System.out.println(ans);
	}

	public static long count(long r2) {
		long x = 0;
		long x2 = 1;
		while (x2 < r2) {
			x2 += x + x + 1;
			x++;
		}
		long total = 0;
		long y = 0;
		long y2next = 1;
		while (true) {
			x--;
			x2 -= x + x + 1;
			while (x2 + y2next < r2) {
				y++;
				y2next += y + y + 1;
			}
			if (x < y)
				break;
			total += 8 * y + 4;
		}
		total += (2 * x + 1) * (2 * x + 1);
		return total;
	}
}