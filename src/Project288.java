import java.util.stream.IntStream;

public class Project288 {
	public static void main(String[] args) {
		long[] t = new long[10000010];
		long[] arr = new long[30];
		arr[0] = 1L;
		IntStream.range(1, 25).forEach(i -> arr[i] = 61 * arr[i - 1]);
		t[0] = 290797;
		IntStream.rangeClosed(1, 10000005).forEach(i -> {
			t[i] = (t[i - 1] * t[i - 1]) % 50515093;
			t[i - 1] %= 61;
		});
		long ans = 0;
		for (int i = 1; i <= 10000000; i++)
			for (int j = i; (j < i + 10) && (j <= 10000000); j++) {
				ans += t[j] * arr[j - i];
				ans %= arr[10];
			}
		System.out.println(ans);
	}
}
