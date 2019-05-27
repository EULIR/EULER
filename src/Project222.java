import java.util.BitSet;
import java.util.stream.IntStream;

public class Project222 {
	static int size = 92274688;
	static double[] memo = new double[size];
	static int allSet = 2097151;
	static int multiply = 2097152;
	static double[][] deltas = new double[22][22];

	public static void main(String[] args) {
		BitSet set = new BitSet();
		for (int i = 0; i < 21; i++) {
			set.set(i);
			for (int j = i + 1; j < 21; j++) {
				int r1 = 30 + i;
				int r2 = 30 + j;
				int a = 100 - r1 - r2;
				int c = r1 + r2;
				double b = Math.sqrt(c * c - a * a);
				double delta = r1 + r2 - b;
				deltas[j][i] = delta;
				deltas[i][j] = delta;
			}
		}
		double ans = IntStream.rangeClosed(30, 50).mapToDouble(i -> 2 * i).sum();
		ans -= getBestDelta(allSet);
		System.out.println(ans);
	}

	public static double getBestDelta(int set) {
		if ((set & allSet) == 0) return 0;
		if (memo[set] != 0) return memo[set];
		int startIdx = set / multiply - 1;
		if (startIdx == -1) startIdx = 21;
		double bestDelta = 0;
		for (int i = 0; i < 21; i++)
			if ((1 << i & set) != 0) {
				double delta = deltas[startIdx][i];
				int newSet = (set & allSet) ^ (1 << i);
				newSet += (i + 1) * multiply;
				delta += getBestDelta(newSet);
				if (delta > bestDelta)
					bestDelta = delta;
			}
		memo[set] = bestDelta;
		return bestDelta;
	}
}