import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.IntStream;

//hash algorithm
public class Project109 {
//	private static ArrayList<Dart> set;
//
//	public static boolean contains(Dart d) {
//		return IntStream.range(0, set.size()).anyMatch(i -> set.get(i).equals(d));
//	}

	public static void main(String[] args) {
		ArrayList<Throw> allPossibility = new ArrayList<>();
		ArrayList<Throw> doublePossibility = new ArrayList<>();
		for (int i = 1; i < 21; i++) {
			allPossibility.add(new Throw(1, i));
			allPossibility.add(new Throw(2, i));
			allPossibility.add(new Throw(3, i));
			doublePossibility.add(new Throw(2, i));
		}
		allPossibility.add(new Throw(0, 0));
		allPossibility.add(new Throw(1, 25));
		allPossibility.add(new Throw(2, 25));
		doublePossibility.add(new Throw(2, 25));
		HashSet<Dart> set = new HashSet<>();
		IntStream.range(0, allPossibility.size()).forEach(i -> allPossibility.forEach(anAllPossibility ->
				doublePossibility.stream().map(aDoublePossibility ->
						new Dart(allPossibility.get(i), anAllPossibility, aDoublePossibility)).forEach(set::add)));
		//System.out.println(set.size());
		int num = (int) set.stream().filter(d -> d.getScore() < 100).count();
		System.out.println(num);
	}
}

class Dart {
	private Throw[] dart;

	public Dart(Throw t1, Throw t2, Throw t3) {
		dart = new Throw[]{t1, t2, t3};
	}

	public int getScore() {
		return this.dart[0].getScore() + this.dart[1].getScore() + this.dart[2].getScore();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Dart))
			return false;
		Dart d = (Dart) obj;
		if (!this.dart[2].equals(d.dart[2]))
			return false;
		long hash1 = 123 * this.dart[0].hashCode() + this.dart[1].hashCode();
		long hash2 = d.dart[0].hashCode() + 123 * d.dart[1].hashCode();
		return hash1 == hash2;
	}

	@Override
	public int hashCode() {
		return dart[0].hashCode() * dart[1].hashCode() + dart[2].hashCode();
	}
}

class Throw {
	private int weight;
	private int value;
	private int score;

	public Throw(int weight, int value) {
		this.weight = weight;
		this.value = value;
		score = weight * value;
	}

	public int getScore() {
		return score;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Throw))
			return false;
		Throw aThrow = (Throw) obj;
		return this.weight == aThrow.weight && this.value == aThrow.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(weight, value);
	}
}
