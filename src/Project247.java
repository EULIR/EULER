import org.jetbrains.annotations.NotNull;

import java.util.TreeSet;

public class Project247 {
	public static void main(String args[]) {
		System.out.println(new Project247().solve(3));
	}

	public Object solve(Integer n) {
		this.n = n;
		int max = -1;
		add(new Square(0, 0, 1, 0));
		for (int i = 1; stillToCheck > 0; i++) {
			Square c = get();
			if (c.left == n && c.below == n) max = i;
			c.addNext();
		}
		return max;
	}

	int n;
	TreeSet<Square> yetToProcess = new TreeSet<>();
	int stillToCheck = 0;

	private void add(Square c) {
		yetToProcess.add(c);
		if (c.below <= n && c.left <= n)
			stillToCheck++;
	}

	private Square get() {
		Square c = yetToProcess.pollFirst();
		if (c != null && c.left <= n && c.below <= n)
			stillToCheck--;
		return c;
	}

	private class Square implements Comparable<Square> {
		int left;
		int below;
		double x;
		double y;
		double xNext;
		double area;

		public Square(int left, int below, double x, double y) {
			this.left = left;
			this.below = below;
			this.x = x;
			this.y = y;
			this.xNext = getSquareX();
			this.area = (xNext - x) * (xNext - x);
		}

		private double getSquareX() {
			double d = x - y;
			return 0.5 * (d + Math.sqrt(d * d + 4));
		}

		public void addNext() {
			add(new Square(left + 1, below, xNext, y));
			add(new Square(left, below + 1, x, 1 / xNext));

		}

		public int compareTo(@NotNull Square o) {
			return Double.compare(o.area, area);
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + "): " + area;
		}
	}
}
