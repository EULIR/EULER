import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Project200 {
	static Random rng;
	static char[] cc;
	static ArrayList<BigInteger> list;
	static boolean[] prime;
	static String twoHundred;

	public static void main(String[] args) {
		twoHundred = "200";
		list = new ArrayList<>();
		cc = "0123456789".toCharArray();
		rng = new Random();
		long max = 1000000;
		prime = new boolean[(int) max + 1];
		IntStream.range(0, prime.length).forEach(i -> prime[i] = true);
		IntStream.range(2, prime.length).filter(i -> prime[i]).flatMap(i -> IntStream.iterate(2 * i, j -> j < prime.length, j -> j + i)).forEach(j -> prime[j] = false);
		outer:
		for (long x = 2; x <= max; x++) {
			if (sqube(x, x).toString().length() > 12)
				break;
			if (isPrime(x)) {
				for (long y = x + 1; y <= max; y++) {
					if (isPrime(y)) {
						BigInteger a = sqube(x, y);
						BigInteger b = sqube(y, x);
						if (b.toString().length() > 12)
							continue outer;
						if (works(a))
							list.add(a);
						if (works(b))
							list.add(b);
					}
				}
			}
		}
		sort();
		System.out.println(list.get(199));
	}

	public static void sort() {
		while (!sorted()) bubbleSort();
	}

	public static void bubbleSort() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					BigInteger a = list.get(i);
					BigInteger b = list.get(j);
					list.set(i, b);
					list.set(j, a);
				}
			}
		}
	}

	public static boolean sorted() {
		return IntStream.range(0, list.size() - 1).noneMatch(i -> list.get(i).compareTo(list.get(i + 1)) > 0);
	}

	public static boolean works(BigInteger x) {
		String s = x.toString();
		if (!s.contains(twoHundred))
			return false;
		char[] c = s.toCharArray();
		char[] t = s.toCharArray();
		if (Integer.parseInt(Character.toString(c[c.length - 1])) % 2 == 0) {
			for (int j = 1; j <= 9; j += 2) {
				t[t.length - 1] = cc[j];
				if (check(t))
					return false;
				t[t.length - 1] = c[t.length - 1];
			}
			return true;
		}
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i == 0 && j == 0)
					continue;
				t[i] = cc[j];
				if (check(t))
					return false;
				t[i] = c[i];
			}
		}
		return true;
	}

	public static boolean check(char[] c) {
		return isPrime(new BigInteger(String.valueOf(c)));
	}

	public static BigInteger sqube(long x, long y) {
		return BigInteger.valueOf(x).pow(2).multiply(BigInteger.valueOf(y).pow(3));
	}

	public static BigInteger generate(int x) {
		StringBuilder sb = new StringBuilder();
		sb.append(rng.nextInt(9) + 1);
		for (int i = 1; i <= x; i++)
			sb.append(rng.nextInt(10));
		return new BigInteger(sb.toString());
	}

	public static boolean witness(BigInteger a, BigInteger n) {
		BigInteger temp = n.subtract(BigInteger.ONE);
		long powersTwo = 0;
		BigInteger two = new BigInteger("2");
		while (temp.mod(two).equals(BigInteger.ZERO)) {
			powersTwo++;
			temp = temp.divide(two);
		}
		BigInteger first = a.modPow(temp, n);
		for (int i = 1; i <= powersTwo; i++) {
			BigInteger next = first.pow(2).mod(n);
			if (next.equals(BigInteger.ONE) && !first.equals(BigInteger.ONE) && !first.equals(n.subtract(BigInteger.ONE)))
				return true;
			first = next;
		}
		return !first.equals(BigInteger.ONE);
	}

	public static boolean isPrime(long n) {
		return prime[(int) n];
	}

	public static boolean isPrime(BigInteger n) {
		for (int j = 1; j <= 8; j++) {
			BigInteger a = generate(n.toString().length()).mod(n);
			if (witness(a, n)) {
				return false;
			}
		}
		return true;
	}
}