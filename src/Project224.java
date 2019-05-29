import java.util.HashSet;

public class Project224 {
	static final int MAX = 75000000;
	static HashSet<Triplet> set = new HashSet<>();

	public static void main(String[] args) {
		findNext(2, 2, 3);
		System.out.println(set.size());
	}

	public static void findNext(int a, int b, int c) {
		if (a + b + c > MAX / 3) return;
		set.add(new Triplet(a, b, c));
		findNext(a - 2 * b + 2 * c, 2 * a - b + 2 * c, 2 * a - 2 * b + 3 * c);
		findNext(a + 2 * b + 2 * c, 2 * a + b + 2 * c, 2 * a + 2 * b + 3 * c);
		findNext(-a + 2 * b + 2 * c, -2 * a + b + 2 * c, -2 * a + 2 * b + 3 * c);
	}
}
