import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Project223 {
	static final int MAX = 25000000;
	static HashSet<Triplet> set = new HashSet<>();

	public static void main(String[] args) {
		findNext(1, 1, 1);
		findNext(1, 2, 2);
		System.out.println(set.size());
	}

	public static void findNext(int a, int b, int c) {
		if (a + b + c > MAX / 3) return;
		set.add(new Triplet(a, b, c));
		findNext(2 * c + b - 2 * a, 2 * c + 2 * b - a, 3 * c + 2 * b - 2 * a);
		findNext(2 * c + b + 2 * a, 2 * c + 2 * b + a, 3 * c + 2 * b + 2 * a);
		findNext(2 * c - 2 * b + a, 2 * c - b + 2 * a, 3 * c - 2 * b + 2 * a);
	}
}

class Triplet {
	int a;
	int b;
	int c;

	public Triplet(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Triplet))
			return false;
		Triplet triplet = (Triplet) obj;
		int[] tri = {triplet.a, triplet.b, triplet.c};
		int[] th = {this.a, this.b, this.c};
		Arrays.sort(tri);
		Arrays.sort(th);
		return Arrays.equals(tri, th);
	}

	@Override
	public int hashCode() {
		int[] th = {this.a, this.b, this.c};
		Arrays.sort(th);
		return Objects.hash(th);
	}
}