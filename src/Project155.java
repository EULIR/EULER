//see this library at https://eulir.github.io/eeml/
import org.eeml.math.expr.Fraction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Project155 {
	public static void main(String[] args) {
		final int MAX = 18;
		ArrayList<HashSet<Fraction>> bufferData = new ArrayList<>();
		HashSet<Fraction> set = new HashSet<>();
		set.add(new Fraction(60, 1));
		bufferData.add(set);
		for (int i = 2; i <= MAX; i++) {
			HashSet<Fraction> addAll = new HashSet<>();
			int j = i - 1;
			while (j >= (i + 1) / 2) {
				HashSet<Fraction> set1 = bufferData.get(j - 1);
				HashSet<Fraction> set2 = bufferData.get(i - j - 1);
				set1.stream().<Consumer<? super Fraction>>map(temp1 -> temp2 -> {
					Fraction temp3 = temp1.add(temp2);
					addAll.add(temp3);
					addAll.add((temp1.multiply(temp2)).divide(temp3));
				}).forEach(set2::forEach);
				j--;
			}
			bufferData.add(addAll);
		}
		HashSet<Fraction> all = new HashSet<>();
		IntStream.range(0, MAX).mapToObj(bufferData::get).forEach(all::addAll);
		System.out.println(all.size());
	}
}
