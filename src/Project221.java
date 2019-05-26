import java.util.Arrays;

public class Project221 {
	private static long find(int n) {
		long[] arr = new long[10 * n];
		int index = -1;
		int p = -1;
		loop:
		for (long i = -1; ; i--)
			for (long j = 1; j < -i; j++)
				if (j + i != 0) {
					long r = (1 - i * j) / (j + i);
					if (r < i)
						if (r * (j + i) == (1 - i * j)) {
							index++;
							if (index == arr.length)
								break loop;
							arr[index] = i * j * r;
							if (arr[index] <= 0)
								arr[index] = Long.MAX_VALUE;
							int per = 100 * index / arr.length;
							if (p != per && per % 2 == 0)
								p = per;
						}
				}
		Arrays.sort(arr);
		return arr[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(find(150000));
	}
}