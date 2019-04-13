import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class Project171 {
	public static final BigInteger TEN = BigInteger.TEN;
	public static Sum ZERO_SUM;

	static {
		ZERO_SUM = new Sum();
		ZERO_SUM.count = BigInteger.ZERO;
		ZERO_SUM.sum = BigInteger.ZERO;
	}

	public static class Sum {
		public BigInteger count;
		public BigInteger sum;
	}

	public static void main(String[] args) {
		Map<Integer, Sum> squareSumCount = new TreeMap<>();
		Sum a = new Sum();
		a.count = BigInteger.ONE;
		a.sum = BigInteger.ZERO;
		squareSumCount.put(0, a);
		for (int i = 0; i < 20; i++) {
			squareSumCount = layerDigit(squareSumCount, i);
		}
		BigInteger sum = BigInteger.ZERO;
		for (Map.Entry<Integer, Sum> r : squareSumCount.entrySet()) {
			int ki = (int) Math.sqrt(r.getKey());
			if (r.getKey() > 0 && (ki * ki == r.getKey())) {
				Sum s = r.getValue();
				sum = sum.add(s.sum);
			}
		}
		System.out.println(sum);
	}

	public static Map<Integer, Sum> layerDigit(Map<Integer, Sum> in, int digit) {
		Map<Integer, Sum> result = new TreeMap<>();
		for (int i = 0; i <= 9; i++) {
			BigInteger iPow = new BigInteger("" + i).multiply(TEN.pow(digit));
			for (Map.Entry<Integer, Sum> entry : in.entrySet()) {
				int val = entry.getKey() + i * i;
				Sum s = result.get(val);
				if (s == null) s = ZERO_SUM;
				Sum nextSum = new Sum();
				nextSum.count = s.count.add(entry.getValue().count);
				nextSum.sum = s.sum.add(entry.getValue().sum.add(iPow.multiply(entry.getValue().count)));
				result.put(val, nextSum);
			}
		}
		return result;
	}
}
