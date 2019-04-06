import java.util.stream.IntStream;

public class Project143 {
	public static void main(String[] args) {
		final int NUM = 120000;
		boolean[] boo = new boolean[NUM + 1];
		for (long i = 1; 3 * i <= NUM; i++) {
			long t1 = i;
			for (long j = i; i + 2 * j <= NUM; j++) {
				while (t1 * t1 < i * i + j * j + i * j)
					t1++;
				if (t1 * t1 == i * i + j * j + i * j) {
					long t2 = j;
					long t3 = j;
					for (long k = j; i + j + k <= NUM; k++) {
						while (t2 * t2 < i * i + k * k + i * k)
							t2++;
						while (t3 * t3 < j * j + k * k + j * k)
							t3++;
						if (t2 * t2 == i * i + k * k + i * k && t3 * t3 == j * j + k * k + j * k)
							boo[(int) (i + j + k)] = true;
					}
				}
			}
		}
		long ans = IntStream.rangeClosed(1, NUM).filter(i -> boo[i]).asLongStream().sum();
		System.out.println(ans);
	}
}
