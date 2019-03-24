import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Project293 {
	static int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59};
	static int arr[] = new int[1000000];
	static int index = 0;

	public static void dfs(int pos, long x) {
		if (x != 1) {
			int i = 2;
			while (true) {
				if (BigInteger.valueOf(x + i).isProbablePrime(30)) {
					arr[index] = i;
					index++;
					break;
				}
				i++;
			}
		}
		LongStream.iterate(x * prime[pos], i -> i < 1000000000, i -> i * prime[pos]).forEach(i -> dfs(pos + 1, i));
	}

	public static void main(String args[]) {
		IntStream.range(0, 1000000).forEach(i -> arr[i] = 0);
		dfs(0, 1);
		Arrays.sort(arr);
		long ans = IntStream.range(0, 1000000).filter(i -> arr[i] != 0 && (i == 0 || arr[i] > arr[i - 1])).mapToLong(i -> arr[i]).sum();
		System.out.println(ans);
	}
}
