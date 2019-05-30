public class Project225 {
	static boolean test(int m) {
		int a1 = 1;
		int b1 = 1;
		int c1 = 1;
		int a2 = 1;
		int b2 = 1;
		int c2 = 1;
		int d1 = (a1 + b1 + c1) % m;
		if (d1 == 0) return false;
		int d2 = (a2 + b2 + c2 + b2 + c2) % m;
		a1 = b1;
		b1 = c1;
		c1 = d1;
		b2 = (a2 + b2 + c2) % m;
		a2 = c2;
		c2 = d2;
		while (a1 != a2 || b1 != b2 || c1 != c2) {
			d1 = (a1 + b1 + c1) % m;
			if (d1 == 0) return false;
			d2 = (a2 + b2 + c2 + b2 + c2) % m;
			a1 = b1;
			b1 = c1;
			c1 = d1;
			b2 = (a2 + b2 + c2) % m;
			a2 = c2;
			c2 = d2;
		}
		return true;
	}

	public static void main(String[] args) {
		int t = 1;
		int index = 0;
		while (index < 124) {
			t += 2;
			if (test(t)) index++;
		}
		System.out.println(t);
	}
}