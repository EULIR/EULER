import org.eeml.math.expr.Fraction;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Project259 {
	private static Set<Fraction> exp(String s) {
		Set<Fraction> result = new HashSet<>();
		result.add(new Fraction(Integer.valueOf(s), 1));
		for (int i = 1; i < s.length(); i++) {
			Set<Fraction> v1 = exp(s.substring(0, i));
			Set<Fraction> v2 = exp(s.substring(i));
			v1.stream().<Consumer<? super Fraction>>map(f1 -> f2 -> {
				result.add(f1.add(f2));
				result.add(f1.subtract(f2));
				result.add(f1.multiply(f2));
				if (f2.getNumerator() != 0)
					result.add(f1.divide(f2));
			}).forEach(v2::forEach);
		}
		return result;
	}

	public static void main(String[] args) {
		long ans = exp("123456789").stream().filter(f -> f.getDenominator() == 1 && f.getNumerator() > 0).mapToLong(Fraction::getNumerator).sum();
		System.out.println(ans);
	}
}