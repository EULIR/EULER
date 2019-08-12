import java.math.BigInteger;
import java.util.stream.LongStream;

public class Project291 {
	public static void main(String[] args) {
		long n = 5000000000000000L;
		long max = (long) Math.sqrt(n);
		int ans = (int) LongStream.rangeClosed(1, max).mapToObj(i -> BigInteger.valueOf(i * i + (i + 1) * (i + 1))).takeWhile(k -> k.compareTo(BigInteger.valueOf(n)) <= 0).filter(k -> k.isProbablePrime(10)).count();
		System.out.println(ans);
	}
}
