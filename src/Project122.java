import java.util.Arrays;
import java.util.stream.IntStream;

public class Project122 {
	final static int MAX = 200;
	static int[] route = new int[MAX + 1];
	static int[] compare = new int[MAX + 1];

	public static void main(String[] args) {
		Arrays.fill(compare, Integer.MAX_VALUE);
		track(0, 1);
		int sum = IntStream.rangeClosed(1, MAX).map(i -> compare[i]).sum();
		System.out.println(sum);
	}

	public static void track(int num, int pow) {
		if (pow > MAX || num > compare[pow])
			return;
		compare[pow] = num;
		route[num] = pow;
		for (int i = num; i >= 0; i--) {
			track(num + 1, pow + route[i]);
		}
	}
}
