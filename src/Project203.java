import java.util.Arrays;
import java.util.HashSet;

public class Project203 {
	public static void main(String[] args) {
		HashSet<Long> set = new HashSet<>();
		long[][] pascal = new long[51][];
		pascal[0] = new long[1];
		pascal[0][0] = 1;
		for (int i = 1; i < 51; i++) {
			pascal[i] = new long[i + 1];
			pascal[i][0] = 1;
			pascal[i][pascal[i].length - 1] = 1;
			for (int j = 1; j < pascal[i].length - 1; j++) {
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				set.add(pascal[i][j]);
			}
		}
		long sum = set.stream().mapToLong(a -> a).filter(Project203::isSquarefree).sum();
		System.out.println(sum);
	}

	public static boolean isSquarefree(long n) {
		long[] square = {4, 9, 25, 49, 121, 169, 289, 361, 529, 841, 961, 1369, 1681, 1849, 2209};
		return Arrays.stream(square).takeWhile(squareOfPrime -> squareOfPrime <= n).noneMatch(squareOfPrime -> n % squareOfPrime == 0);
	}
}
