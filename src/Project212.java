import java.util.stream.IntStream;

public class Project212 {
	static long result = 0;
	static int[][] C;
	static int[] parms;
	static long[] counts;
	static int Limit;

	public static void main(String[] args) {
		Limit = 50000;
		int[] S = new int[6 * Limit + 1];
		C = new int[Limit + 1][6];
		parms = new int[Limit];
		counts = new long[Limit + 1];
		IntStream.rangeClosed(1, 55).forEach(k -> S[k] = (int) ((100003 - 200003 * k + 300007 * (hoch(k, 3L))) % 1000000));
		IntStream.range(56, 6 * Limit + 1).forEach(k -> S[k] = (S[(k - 24)] + S[(k - 55)]) % 1000000);
		int i = 1;
		for (int n = 1; n <= Limit; n++) {
			C[n][0] = S[i++] % 10000;
			C[n][1] = S[i++] % 10000;
			C[n][2] = S[i++] % 10000;
			C[n][3] = S[i++] % 399 + 1;
			C[n][4] = S[i++] % 399 + 1;
			C[n][5] = S[i++] % 399 + 1;
		}
		do212();
		System.out.println(result);

	}

	public static void do212() {
		int[] next = new int[6];
		long zwischensumme = 0;
		for (int n = 1; n <= Limit; n++) {
			next[0] = C[n][0];
			next[1] = C[n][1];
			next[2] = C[n][2];
			next[3] = C[n][3];
			next[4] = C[n][4];
			next[5] = C[n][5];
			zwischensumme += next[3] * next[4] * next[5];
			parms[0] = n;
			do212(next, 1);
		}
		result += zwischensumme;
	}

	public static void do212(int[] schnitt, int len) {
		int start;
		boolean add = len % 2 == 0;
		start = parms[len - 1] + 1;
		int[] next = new int[6];
		long zwischensumme = 0;
		for (int n = start; n <= Limit; n++) {
			if (Library.max(schnitt[0], C[n][0]) < Library.min(schnitt[0] + schnitt[3], C[n][0] + C[n][3])
					&& Library.max(schnitt[1], C[n][1]) < Library.min(schnitt[1] + schnitt[4], C[n][1] + C[n][4])
					&& Library.max(schnitt[2], C[n][2]) < Library.min(schnitt[2] + schnitt[5], C[n][2] + C[n][5])) {
				next[0] = Library.max(schnitt[0], C[n][0]);
				next[1] = Library.max(schnitt[1], C[n][1]);
				next[2] = Library.max(schnitt[2], C[n][2]);
				next[3] = Library.min(schnitt[0] + schnitt[3], C[n][0] + C[n][3]) - next[0];
				next[4] = Library.min(schnitt[1] + schnitt[4], C[n][1] + C[n][4]) - next[1];
				next[5] = Library.min(schnitt[2] + schnitt[5], C[n][2] + C[n][5]) - next[2];
				zwischensumme += next[3] * next[4] * next[5];
				parms[len] = n;
				do212(next, len + 1);
			}
		}
		if (add) result += zwischensumme;
		else result -= zwischensumme;
	}

	public static long hoch(long b, long e) {
		long result = 1;
		while (e > 0) {
			if ((e & 1) == 1) result = result * b;
			e >>= 1;
			b = b * b;
		}
		return result;
	}
}
