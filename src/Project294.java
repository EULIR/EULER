public class Project294 {
	public static void main(String[] args) {
		System.out.println(count(3138428376721L));
	}

	public static long count(long maxDigits) {
		long[][] sumByMod = new long[24][23];
		for (int i = 0; i <= 9; i++)
			sumByMod[i][i] = 1;
		long[][] toReturn = new long[24][23];
		toReturn[0][0] = 1;
		boolean first = true;
		final int ringSize = 22;
		for (long d = maxDigits; d > 0; d /= ringSize) {
			long[][][] cur = new long[ringSize][24][23];
			cur[0] = sumByMod;
			int mult = 1;
			for (int i = 1; i < ringSize; i++) {
				if (first)
					mult = (mult * 10) % 23;
				combine(cur[i], cur[i - 1], cur[0], mult);
			}
			sumByMod = cur[ringSize - 1];
			int curMod = (int) (d % ringSize);
			if (curMod > 0) {
				long[][] toReturnNext = new long[24][23];
				combine(toReturnNext, cur[curMod - 1], toReturn, 1);
				toReturn = toReturnNext;
			}
			first = false;
		}
		return toReturn[23][0];
	}

	private static void combine(long[][] result, long[][] in1, long[][] in2, int in2Mult) {
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j + i < 24; j++) {
				int curRow = j + i;
				for (int k = 0; k < 23; k++)
					for (int l = 0; l < 23; l++) {
						int mod = (k + l * in2Mult) % 23;
						result[curRow][mod] = (result[curRow][mod] + in1[i][k] * in2[j][l]) % 1000000000;
					}
			}
		}
	}
}