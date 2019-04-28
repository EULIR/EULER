import java.util.Set;
import java.util.TreeSet;

public class Project180 {
	private static Set<Rational> set = new TreeSet<>();

	public static void addSol(Rational x, Rational y, Rational z, int n) {
		Rational s = new Rational(x);
		s.add(y);
		s.add(z);
	}

	public static void main(String[] args) {
		int size = 35;
		for (long za = 1; za <= size; za++) {
			for (long zb = za + 1; zb <= size; zb++) {
				if (Library.gcd(za, zb) == 1) {
					Rational z = new Rational(za, zb);
					for (long xa = 1; xa <= size; xa++) {
						for (long xb = xa + 1; xb <= size; xb++) {
							if (Library.gcd(xa, xb) == 1) {
								Rational x = new Rational(xa, xb);
								Rational y = new Rational(z);
								y.subtract(x);
								if (y.isValid()) addSol(x, y, z, 1);
								Rational x2 = new Rational(x);
								x2.multiply(x);
								Rational z2 = new Rational(z);
								z2.multiply(z);
								y = new Rational(z2);
								y.subtract(x2);
								if (y.trySqrt() && y.isValid()) addSol(x, y, z, 2);
								x2 = new Rational(x);
								x2.reciprocal();
								z2 = new Rational(z);
								z2.reciprocal();
								y = new Rational(z2);
								y.subtract(x2);
								y.reciprocal();
								if (y.isValid()) addSol(x, y, z, -1);
								x2 = new Rational(x);
								x2.reciprocal();
								x2.multiply(x2);
								z2 = new Rational(z);
								z2.reciprocal();
								z2.multiply(z2);
								y = new Rational(z2);
								y.subtract(x2);
								y.reciprocal();
								if (y.trySqrt() && y.isValid()) addSol(x, y, z, -2);
							}
						}
					}
				}
			}
		}
		Rational t = new Rational(0, 1);
		set.forEach(t::add);
		System.out.println(t.getDen() + t.getNum());
	}
}

class Rational implements Comparable<Rational> {
	private long num, den;

	public Rational(long x, long y) {
		num = x;
		den = y;
		reduce();
	}

	public Rational(Rational r2) {
		num = r2.num;
		den = r2.den;
	}

	public void reduce() {
		long g = Library.gcd(den, num);
		num /= g;
		den /= g;
	}

	public void add(Rational r2) {
		long g = Library.gcd(den, r2.den);
		num = num * (r2.den / g) + r2.num * (den / g);
		den *= r2.den / g;
		reduce();
	}

	public void subtract(Rational r2) {
		long g = Library.gcd(den, r2.den);
		num = num * (r2.den / g) - r2.num * (den / g);
		den *= r2.den / g;
		reduce();
	}

	public void multiply(Rational r2) {
		num *= r2.num;
		den *= r2.den;
		reduce();
	}

	public void reciprocal() {
		long t = num;
		num = den;
		den = t;
	}

	public boolean trySqrt() {
		if (num < 0) return false;
		long n = (long) (.5 + Math.sqrt(num));
		if (n * n != num) return false;
		long d = (long) (.5 + Math.sqrt(den));
		if (d * d != den) return false;
		num = n;
		den = d;
		return true;
	}

	public int compareTo(Rational r2) {
		long g = Library.gcd(den, r2.den);
		long d = num * (r2.den / g) - (den / g) * r2.num;
		if (d < 0) return -1;
		if (d > 0) return 1;
		return 0;
	}

	public boolean isValid() {
		return num > 0 && den > num && den <= 35;
	}

	public String toString() {
		return num + "/" + den;
	}

	public long getNum() {
		return num;
	}

	public long getDen() {
		return den;
	}
}