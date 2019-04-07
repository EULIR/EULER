import java.util.HashSet;
import java.util.Set;

public class Project147 {

	public static void main(String[] args) {
		long total = 0;
		int maxWidth = 47;
		int maxHeight = 43;
		for (int i = 1; i <= maxWidth; i++) {
			for (int j = 1; j <= maxHeight; j++) {
				Set<Coordinate> set1 = new HashSet<>();
				for (int k = 0; k < i; k++) {
					for (int l = 0; l < j; l++) {
						set1.add(new Coordinate(k, 0 - l));
						set1.add(new Coordinate(k + 1, 0 - l));
						set1.add(new Coordinate(k, 0 - l - 1));
						set1.add(new Coordinate(k + 1, 0 - l - 1));
					}
				}
				Set<Coordinate> set2 = new HashSet<>();
				for (int k = 0; k < i; k++) {
					for (int l = 0; l < j; l++) {
						set2.add(new Coordinate(k - l, -k - l));
						set2.add(new Coordinate(k - l + 1, -k - l - 1));
						set2.add(new Coordinate(k - l, -k - l - 1));
						set2.add(new Coordinate(k - l + 1, -k - l - 1));
						set2.add(new Coordinate(k - l, -k - l - 2));
					}
				}
				total += countRectangles(set1) + countRectangles(set2);
			}
		}
		System.out.println(total);
	}

	public static long countRectangles(Set<Coordinate> set) {
		long count = 0;
		for (Coordinate aSet : set) {
			int x = aSet.x;
			int y = aSet.y;
			int i = 1;
			while (set.contains(new Coordinate(x + i, y))) {
				int j = 1;
				while (set.contains(new Coordinate(x, y - j)) && set.contains(new Coordinate(x + i, y - j))) {
					count++;
					j++;
				}
				i++;
			}
		}
		return count;
	}
}

class Coordinate {
	int x;
	int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Coordinate))
			return false;
		Coordinate xy = (Coordinate) obj;
		return xy.x == x && xy.y == y;
	}

	public int hashCode() {
		return x * 999 + y;
	}
}
