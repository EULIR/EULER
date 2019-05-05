public class Project189 {
	static long[][] count = new long[9][];

	public static void main(String[] args) {
		int Limit = 8;
		if (args.length > 0) Limit = Integer.parseInt(args[0]);
		long result = func("", Limit);
		System.out.println(result);
	}

	public static long func(String in, int limit) {
		long result = 0;
		int len = in.length();
		if (count[len] == null) count[len] = new long[hoch(3, len)];
		if (len == 0) {
			result += func("0", limit);
			result += func("1", limit);
			result += func("2", limit);
		} else if (len < limit) {
			char[] oben = in.toCharArray();
			int z = 0;
			int inverted = 0;
			for (int i = 0; i < len; i++) {
				z = z * 3;
				z = z + ((3 - (oben[0]) + (oben[i])) % 3);
				inverted = inverted * 3;
				inverted = inverted + ((3 - (oben[len - 1]) + (oben[len - 1 - i])) % 3);
			}
			z = Library.min(z, inverted);
			if (count[len][z] == 0) {
				for (int i = 0; i < hoch(2, len); i++) {
					char[] unten = new char[len];
					int k = i;
					for (int j = 0; j < len; j++) {
						int add = k % 2;
						k = k >> 1;
						unten[j] = (char) ((oben[j] + 1 + add) % 3 + '0');
					}
					result += do189b("", unten, limit);
				}
				count[len][z] = result;
			} else result = count[len][z];
		} else {
			result += 1L;
		}
		return result;
	}

	public static long do189b(String in, char[] unten, int limit) {
		long result = 0;
		int len = in.length();
		if (len == unten.length) {
			result += func(in + (char) (((int) unten[len - 1] + 1) % 3 + '0'), limit);
			result += func(in + (char) (((int) unten[len - 1] + 2) % 3 + '0'), limit);
		} else if (len == 0 || unten[len - 1] == unten[len]) {
			result += do189b(in + (char) (((int) unten[len] + 1) % 3 + '0'), unten, limit);
			result += do189b(in + (char) (((int) unten[len] + 2) % 3 + '0'), unten, limit);
		} else result += do189b(in + (char) ((99 - (int) (unten[len - 1] + unten[len])) % 3 + '0'), unten, limit);
		return result;
	}

	public static int hoch(int i, int j) {
		if (j == 0) return 1;
		int result = 1;
		for (int k = 0; k < j; k++) result = result * i;
		return result;
	}
}
