import java.util.stream.IntStream;

public class Project135 {
	public static void main(String[] args) {
		final int MAX_LIMIT = 1000000;
		int[] arr = new int[MAX_LIMIT + 1];
		for (int i = 1; i <= MAX_LIMIT; i++) {
			for (int j = 1; i * j <= MAX_LIMIT; j++) {
				if ((3 * j) > i)
					if ((i + j) % 4 == 0)
						if ((3 * j - i) % 4 == 0) {
							arr[i * j]++;
						}
			}
		}
		int num = (int) IntStream.range(0, arr.length).filter(i -> arr[i] == 10).count();
		System.out.println(num);
	}
}
