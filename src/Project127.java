import java.util.stream.IntStream;

public class Project127 {
	public static void main(String[] args) {
		final int MAX = 120000;
		int[] rad = new int[MAX + 1];
		boolean[] primeNumber = new boolean[MAX + 1];
		IntStream.rangeClosed(1, MAX).forEach(i -> rad[i] = 1);
		for (int i = 2; i <= MAX; i++) {
			if (primeNumber[i])
				continue;
			for (int j = i; j < rad.length; j += i) {
				primeNumber[j] = true;
				rad[j] *= i;
			}
		}
		int limit = MAX >> 1;
		int[] early = new int[limit + 1];
		int[] previous = new int[limit + 1];
		int[] last = new int[limit + 1];
		int count = 0;
		for (int i = limit; i >= 1; i--) {
			early[count] = i;
			previous[count] = last[rad[i]];
			last[rad[i]] = count++;
		}
		int[] radList = new int[limit + 1];
		int r = 0;
		for (int i = 1; i < limit; i++)
			if (last[i] != 0)
				radList[r++] = rad[i];
		int ans = 0;
		for (int i = 1; i < MAX; i++)
			for (int j = 0; j < r && ((i % 2 == 0) ? 3 : 2) * radList[j] * rad[i] < i; j++) {
				int n = radList[j] * rad[i];
				if (rad[n] != n)
					continue;
				for (int k = last[radList[j]]; k != -1; k = previous[k]) {
					int l = early[k];
					if (2 * l > i)
						break;
					if ((long) rad[i - l] * n < i) {
						ans += i;
					}
				}
			}
		System.out.println(ans);
	}
}
