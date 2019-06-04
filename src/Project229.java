import java.util.BitSet;

public class Project229 {
	public static void main(String[] args) {
		BitSet num = number(1);
		num.and(number(2));
		num.and(number(3));
		num.and(number(7));
		System.out.println(num.cardinality());
	}

	public static BitSet number(int coefficient) {
		BitSet set = new BitSet();
		for (long i = 1; i * i <= 2000000000; i++)
			for (long j = 1; i * i + coefficient * j * j <= 2000000000; j++)
				set.set((int) (i * i + coefficient * j * j));
		return set;
	}
}