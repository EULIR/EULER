import java.util.stream.IntStream;

public class Project209 {
	public static void main(String[] args) {
		long t = 0;
		long ans = 1;
		long[] fibonacci = new long[64];
		fibonacci[1] = 1;
		IntStream.range(2, 64).forEach(i -> fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]);
		for (int i = 0; i < 64; i++) {
			if ((t & 1L << i) != 0)
				continue;
			int j = i;
			int len = 0;
			t |= 1L << j;
			j = ((j * 2) | j + 8 >>> 5 & 1) & 63;
			len++;
			while (j != i) {
				t |= 1L << j;
				j = ((j << 1) | (((j + 8) >>> 5) & 1)) & 63;
				len++;
			}
			ans *= fibonacci[len - 1] + fibonacci[len + 1];
		}
		System.out.println(ans);
	}
}