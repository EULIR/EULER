import org.eeml.math.expr.Fraction;

public class Project329 {
	static final int MAX = 501;
	static char[] type = "PPPPNNPPPNPPNPN".toCharArray();
	static boolean[] prime = new boolean[MAX];
	static Fraction[][] ans = new Fraction[501][type.length + 1];

	public static void main(String[] args) {
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		Fraction t = new Fraction(0, 1);
		for (int i = 0; i < MAX; i++) {
			t = t.add(get(i, 0));
		}
		t = t.multiply(new Fraction(1, 500));
		System.out.println(t.getNumerator() + "/" + t.getDenominator());
	}

	public static Fraction get(int i, int j) {
		if (ans[i][j] != null)
			return ans[i][j];
		if (j == type.length)
			return ans[i][j] = new Fraction(1, 1);
		boolean isMatch = (type[j] == 'P') == (prime[i]);
		ans[i][j] = new Fraction(0, 1);
		Fraction m = (isMatch ? new Fraction(2, 3) : new Fraction(1, 3));
		if (i > 1)
			ans[i][j] = ans[i][j].add(m.multiply(get(i - 1, j + 1)));
		if (i < 500)
			ans[i][j] = ans[i][j].add(m.multiply(get(i + 1, j + 1)));
		if (i > 1 && i < 500)
			ans[i][j] = ans[i][j].multiply(new Fraction(1, 2));
		return ans[i][j];
	}
}
