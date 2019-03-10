import java.util.HashSet;

public class Project346 {
	public static void main(String[] args) {
		final long LIMIT = 1000000000000L;
		HashSet<Long> set = new HashSet<>();
		for (int i = 2; i <= Math.sqrt(LIMIT) + 1; i++) {
			long sum = i + 1;
			long a = i;
			for (int j = 0; j <= Library.log(i, LIMIT) + 1; j++) {
				a *= i;
				sum += a;
				if (sum > LIMIT)
					break;
				set.add(sum);
			}
		}
		System.out.println(set.stream().mapToLong(i -> i).sum() + 1);
	}
}
