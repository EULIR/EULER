import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Project266 {
	static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
			59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
			139, 149, 151, 157, 163, 167, 173, 179, 181};
	static BigInteger max = BigInteger.ONE;
	static int[] buffer;
	static int[] prebuffer;
	static List<BigInteger> preProds;
	static int preSize;
	static BigInteger root;

	public static void main(String[] args) {
		preSize = 20;
		root = new BigInteger("2323218950681478446587180516177954548");
		buffer = new int[primes.length];
		prebuffer = new int[primes.length];
		preProds = new ArrayList<>();
		preProcess(0, preSize, BigInteger.ONE);
		Collections.sort(preProds);
		process(0, primes.length - 1, BigInteger.ONE);
		System.out.println(max);
	}

	public static void preProcess(int pos, int posPrim, BigInteger prod) {
		IntStream.iterate(posPrim, i -> i >= 0, i -> i - 1).forEach(i -> {
			prebuffer[pos] = primes[i];
			BigInteger newProd = prod.multiply(new BigInteger(String.valueOf(primes[i])));
			preProds.add(newProd);
			if (i > 0) preProcess(pos + 1, i - 1, newProd);
		});
	}

	static BigInteger nearest(BigInteger key) {
		int extremo1 = 0;
		int extremo2 = preProds.size() - 1;
		if (key.equals(BigInteger.ZERO)) return null;
		if (key.compareTo(preProds.get(0)) < 0) return null;
		int ultimoExtremo = -999;
		boolean lastGt = true;
		BigInteger probe = null;
		while (true) {
			int extremo = (extremo1 + extremo2) / 2;
			if (extremo == ultimoExtremo)
				if (lastGt) return probe;
				else if (extremo > 0)
					return preProds.get(extremo - 1);
				else
					return preProds.get(0);
			probe = preProds.get(extremo);
			switch (key.compareTo(probe)) {
				case 0:
					return probe;
				case 1:
					extremo1 = extremo;
					lastGt = true;
					break;
				default:
					extremo2 = extremo;
					lastGt = false;
					break;
			}
			ultimoExtremo = extremo;
		}
	}

	public static void process(int pos, int posPrim, BigInteger prod) {
		for (int z = posPrim; z >= 0; z--) {
			if (z <= preSize) {
				BigInteger q = root.divide(prod);
				BigInteger cercano = nearest(q);
				if (cercano != null) {
					BigInteger newProd = prod.multiply(cercano);
					check(newProd);
				}
				break;
			}
			buffer[pos] = primes[z];
			BigInteger newProd = prod.multiply(new BigInteger(String.valueOf(primes[z])));
			if (newProd.compareTo(root) > 0) continue;
			check(newProd);
			if (z > 0) process(pos + 1, z - 1, newProd);
		}
	}

	public static void check(BigInteger x) {
		if (x.compareTo(max) > 0) max = x;
	}
}