import java.util.stream.IntStream;

public class Project172 {
	public static void main(String[] args) {
		System.out.println(func(0, 0));
	}

	static long arr[][] = new long[18][1048576];

	public static long func(int bits, int pos) {
		if (pos == 18)
			return 1;
		if (arr[pos][bits] > 0)
			return arr[pos][bits] - 1;
		int start = pos == 0 ? 1 : 0;
		long sum = IntStream.rangeClosed(start, 9).filter(d -> (bits >> d + d & 3) != 3).mapToLong(d -> func(bits + (1 << (d + d)), pos + 1)).sum();
		arr[pos][bits] = sum + 1;
		return sum;
	}
}
