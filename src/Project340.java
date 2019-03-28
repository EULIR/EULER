import java.math.BigInteger;

public class Project340 {
	public static void main(String[] args) {
		BigInteger a = BigInteger.valueOf(1801088541L);
		BigInteger b = BigInteger.valueOf(558545864083284007L);
		BigInteger c = BigInteger.valueOf(35831808L);
		BigInteger d = b.add(BigInteger.ONE);
		BigInteger e = b.divideAndRemainder(a)[0];
		BigInteger f = a.multiply(BigInteger.valueOf(4)).subtract(c.multiply(BigInteger.valueOf(3)));
		System.out.println(b.multiply(d).shiftRight(1)
				.add(a.multiply(e.multiply(e.add(BigInteger.ONE)).multiply(f).shiftRight(1)))
				.subtract(c.multiply(d))
				.add(d.mod(a).multiply(b.divide(a).add(BigInteger.ONE)).multiply(f)));
	}
}
