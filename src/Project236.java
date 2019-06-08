import java.util.stream.IntStream;

public class Project236 {
	private static int[] A_236 = {1312, 5248, 5760, 2624, 3936};
	private static int[] B_236 = {1888, 640, 3776, 3776, 5664};
	private static int A;
	private static int B;

	private static long nBest;
	private static long dBest;
	private static double xBest = 0;

	static {
		IntStream.range(0, A_236.length).forEach(i -> A += A_236[i]);
		IntStream.range(0, B_236.length).forEach(i -> B += B_236[i]);
	}

	public static void main(String[] args) {
		for (int a1 = 1; a1 < A_236[0]; a1++) {
			System.out.println("a1 " + a1);
			for (int b1 = 1; b1 < B_236[0]; b1++) {
				if (b1 * A_236[0] > a1 * B_236[0]) {
					long gcd = Library.gcd(b1 * A_236[0], a1 * B_236[0]);
					search(1, b1 * A_236[0] / gcd, a1 * B_236[0] / gcd, a1, b1);
				}
			}
		}
		System.out.println("BEST " + nBest + "/" + dBest);
	}

	public static void search(int pos, long num, long den, long suma, long sumb) {
		if ((double) num / den <= xBest) {
			return;
		}
		if (pos == A_236.length) {
			if (suma * B * den == sumb * A * num) {
				double x = (double) num / den;
				if (x > xBest) {
					xBest = x;
					nBest = num;
					dBest = den;
					System.out.print("RUNNING BEST ");
				}
				System.out.println("solution " + num + "/" + den + "  (" + x + ")");

			}
		} else {
			long aBase = A_236[pos] * den;
			long bBase = B_236[pos] * num;
			long gcd = Library.gcd(aBase, bBase);
			aBase /= gcd;
			bBase /= gcd;
			for (long aa = aBase, bb = bBase; aa < A_236[pos] && bb < B_236[pos]; aa += aBase, bb += bBase) {
				search(pos + 1, num, den, suma + aa, sumb + bb);
			}
		}
	}
}