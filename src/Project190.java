import java.util.stream.IntStream;

public class Project190 {
	public static void main(String[] args) {
		System.out.println(IntStream.rangeClosed(2, 15).map(i -> (int) IntStream.rangeClosed(1, i).mapToDouble(j -> Math.pow(2 * j / (double) (i + 1), j)).reduce(1, (a, b) -> a * b)).sum());
	}
}
