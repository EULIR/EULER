public class Project220 {
	public static void main(String[] args) {
		long[] res = displacement(1000000000000L, 50);
		System.out.println(res[2] + "," + res[3]);
	}

	private static long[] displacement(long distance, int generation) {
		if (generation == 0) {
			if (distance == 0)
				return new long[]{0, 1, 0, 0};
			else if (distance == 1)
				return new long[]{0, 1, 0, 1};
		}
		long halfLength = 1L << (generation - 1);
		boolean boo = distance > halfLength;
		if (boo)
			distance = 2 * halfLength - distance;
		long[] ret = displacement(distance, generation - 1);
		long ex = ret[0];
		long ey = ret[1];
		ret[0] = ex + ey;
		ret[1] = ey - ex;
		if (boo) {
			long x = ret[2];
			long y = ret[3];
			ret[2] = ex + ey - y;
			ret[3] = ey - ex + x;
		}
		return ret;
	}
}