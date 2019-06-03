import java.util.HashSet;

public class Project228 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1864; i <= 1909; i++) {
			for (int j = 0; j < i; j++) {
				int t = Library.gcd(i, j);
				set.add((i / t) * 10000 + j / t);
			}
		}
		System.out.println(set.size());
	}
}
