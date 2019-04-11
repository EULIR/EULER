import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.stream.IntStream;

public class Project168 {
	public static void main(String[] args) {
		Hashtable<BigInteger, BigInteger> htAllLastDigs = new Hashtable<>();
		BigInteger mod = new BigInteger("100000");
		BigInteger[] arr = new BigInteger[101];
		String[] strs = new String[101];
		IntStream.rangeClosed(0, 100).forEach(i -> {
			strs[i] = String.valueOf(i);
			arr[i] = new BigInteger(strs[i]);
		});
		String snum = "1";
		BigInteger num = new BigInteger(snum);
		for (int i = 1; i <= 99; i++) {
			num = num.multiply(BigInteger.TEN);
			for (int s = 1; s <= 9; s++) {
				BigInteger q1 = num.subtract(arr[s]);
				for (int d = 1; d <= 9; d++) {
					BigInteger q2 = q1.multiply(arr[d]);
					for (int div = 99; div >= 1; div--) {
						BigInteger res[] = q2.divideAndRemainder(arr[div]);
						if (res[1].equals(BigInteger.ZERO)) {
							String resStr0 = res[0].toString();
							int len;
							if ((len = resStr0.length()) == i) {
								String strD = strs[d];
								BigInteger bi1 = new BigInteger(resStr0 + strD);
								BigInteger bi2 = new BigInteger(strD + resStr0);
								if (bi2.divideAndRemainder(bi1)[1].equals(BigInteger.ZERO))
									htAllLastDigs.put(bi1, bi1.divideAndRemainder(mod)[1]);
							} else if (len > i) break;
						}
					}
				}
			}
		}
		Enumeration en = htAllLastDigs.keys();
		BigInteger sum = BigInteger.ZERO;
		while (en.hasMoreElements()) {
			Object k = en.nextElement();
			sum = sum.add(htAllLastDigs.get(k));
		}
		System.out.println(sum.divideAndRemainder(mod)[1]);
	}
}
