import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Project184 {
	public static void main(String[] args) {
		int r = 1200;
		long r2 = r * r;
		FractionLong half[] = getAllReducedFractions(r);
		long mul[] = new long[half.length];
		int n = 0;
		for (int i = 1; i < mul.length; i++) {
			FractionLong f = half[i];
			long d2 = f.n * f.n + f.d * f.d;
			int mulf = (int) Math.sqrt((r2 % d2 == 0) ? r2 / d2 - 1 : r2 / d2);
			if (mulf > 0)
				mul[n++] = mulf;
		}
		long mulInt[] = getIntegralFunction(mul);
		long val[] = IntStream.range(1, n).mapToLong(j -> mul[j] * mulInt[j - 1]).toArray();
		long valInt[] = getIntegralFunction(val);
		long result = 0;
		for (int i = 0; i < n; i++)
			result += mul[i] * (valInt[n - 1] - valInt[i] - mulInt[i] * (mulInt[n - 1] - mulInt[i]));
		result *= 2;
		System.out.println(result);
	}

	public static long[] getIntegralFunction(long[] v) {
		long sum = 0;
		long[] integral = new long[v.length];
		for (int i = 0; i < v.length; i++) {
			sum += v[i];
			integral[i] = sum;
		}
		return integral;
	}

	static final class FractionLong implements Comparable<FractionLong> {

		public long n;
		public long d;

		public FractionLong(long n, long d) {
			this.n = n;
			this.d = d;
		}

		public FractionLong negate() {
			return new FractionLong(-n, d);
		}

		public int compareTo(FractionLong f) {
			return Long.signum(n * f.d - f.n * d);
		}
	}

	private static FractionLong[] getAllReducedFractions(long rbound) {
		List<FractionLong> sbt = sternBrocotCircle(rbound, new FractionLong(0, 1), new FractionLong(1, 0));
		FractionLong[] r = new FractionLong[sbt.size() * 2 - 1];
		for (int i = 0; i < sbt.size(); i++) {
			FractionLong f = sbt.get(sbt.size() - 1 - i);
			r[i] = f.negate();
			r[r.length - 1 - i] = f;
		}
		return r;
	}

	private static List<FractionLong> sternBrocotCircle(long rBound, FractionLong from, FractionLong to) {
		long rBound2 = rBound * rBound;
		List<FractionLong> sbt = new ArrayList<>();
		Stack<FractionLong> stack = new Stack<>();
		while (true) {
			FractionLong mid = new FractionLong(from.n + to.n, from.d + to.d);
			if (mid.n * mid.n + mid.d * mid.d < rBound2) {
				stack.push(to);
				to = mid;
			} else {
				if (stack.empty()) break;
				sbt.add(from);
				from = to;
				to = stack.pop();
			}
		}
		sbt.add(from);
		sbt.add(to);
		return sbt;
	}
}
