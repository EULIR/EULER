import java.util.stream.IntStream;

public class Project493 {
	public static void main(String[] args) {
		double ans = IntStream.range(1, 20).mapToDouble(i -> (double) (60 - i) / (70 - i)).reduce(1, (a, b) -> a * b);
		ans = 7 * (1 - ans);
		System.out.println(ans);
	}
}
