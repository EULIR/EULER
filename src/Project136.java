import java.util.stream.IntStream;

public class Project136 {
	public static void main(String[] args) {
		final int MAX = 50000000;
		boolean[] count = new boolean[MAX];
		boolean[] value = new boolean[MAX];
		for (int i = 1; i < MAX; i++) {
			for (int j = (i + 2) / 3; j < MAX; j++) {
				var n = (j + i) * (3 * j - i);
				if (n < MAX) {
					if (!count[n]) {
						count[n] = true;
						value[n] = true;
					} else value[n] = false;
				} else break;
			}
		}
		int ans = (int) IntStream.range(0, MAX).filter(i -> count[i] && value[i]).count();
		System.out.println(ans);
	}
}
