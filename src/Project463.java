import java.math.BigInteger;
import java.util.HashMap;

public class Project463 {
	public static BigInteger two = new BigInteger("2");
	public static BigInteger three = new BigInteger("3");
	public static BigInteger four = new BigInteger("4");
	public static BigInteger five = new BigInteger("5");
	public static HashMap<BigInteger, BigInteger> map;

	public static void main(String[] args) {
		BigInteger target = three.pow(37);
		map = new HashMap<>();
		map.put(BigInteger.ZERO, BigInteger.ZERO);
		map.put(BigInteger.ONE, BigInteger.ONE);
		map.put(two, two);
		map.put(three, five);
		System.out.println(sumOffTo(target));
	}

	private static BigInteger sumOffTo(BigInteger input) {
		BigInteger cachedValue = map.get(input);
		if (cachedValue != null) return cachedValue;
		BigInteger firstIndex = input.divide(two);
		BigInteger valueOfEvens = sumOffTo(firstIndex).multiply(new BigInteger("6"));
		BigInteger secondIndex = input.divide(four);
		BigInteger valueOfFirstTermOfOdds = sumOffTo(secondIndex).multiply(new BigInteger("5"));
		BigInteger fouthIndex = input.subtract(three).divide(four);
		BigInteger valueOfSecondTermOfOdds = sumOffTo(fouthIndex).multiply(three);
		BigInteger remainder = input.remainder(four);
		BigInteger correctingFactor = BigInteger.ZERO;
		if (remainder.equals(BigInteger.ONE)) correctingFactor = f(input);
		if (remainder.equals(two))
			correctingFactor = f(input.subtract(BigInteger.ONE)).subtract((new BigInteger("5").multiply(f(input))));
		BigInteger returnValue =
				valueOfEvens.subtract(valueOfFirstTermOfOdds).subtract(valueOfSecondTermOfOdds)
						.subtract(BigInteger.ONE).add(correctingFactor);
		map.put(input, returnValue);
		return returnValue;
	}

	private static BigInteger f(BigInteger input) {
		BigInteger x = input;
		BigInteger b = BigInteger.ZERO;
		while (!x.equals(BigInteger.ZERO)) {
			b = b.shiftLeft(1);
			b = b.or((x.and(BigInteger.ONE)));
			x = x.shiftRight(1);
		}
		return b;
	}
}
