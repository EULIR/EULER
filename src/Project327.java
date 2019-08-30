public class Project327 {
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 3; i <= 40; i++) {
			long lo = 1;
			long hi = Long.MAX_VALUE;
			while (lo < hi) {
				long mid = (lo + hi) / 2;
				if (inRange(mid, i, 30))
					hi = mid;
				else lo = mid + 1;
			}
			sum += lo;
		}
		System.out.println(sum);
	}

	private static boolean inRange(long dq, int c, int r) {
		if (dq == 0) return false;
		if (dq <= c) return dq >= r + 1;
		if (dq % c >= 2)
			return inRange(dq / c * (c - 2) + dq % c - 1, c, r - 1);
		return inRange((dq - c) / c * (c - 2) + c - 1, c, r - 1);
	}
}
