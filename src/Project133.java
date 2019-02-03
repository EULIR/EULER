import java.math.BigInteger;
import java.util.stream.IntStream;

public class Project133 {
	public static void main(String[] args) {
		long ans = 3;
		ans += IntStream.range(2, 100000).filter(i -> Library.isPrime(i) && !(BigInteger.TEN.modPow(BigInteger.TEN.pow(100), BigInteger.valueOf(i)).compareTo(BigInteger.ONE) == 0)).asLongStream().sum();
		System.out.println(ans);
	}
}
