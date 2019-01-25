import java.math.BigDecimal;
import java.math.RoundingMode;

public class Project138 {
	public static void main(String[] args) {
		int k = 0;
		BigDecimal i = new BigDecimal(3);
		BigDecimal ans = new BigDecimal(0);
		while (k < 12) {
			i = i.add(BigDecimal.valueOf(1));
			BigDecimal a = i.add(BigDecimal.valueOf(1)).pow(2);
			BigDecimal b = BigDecimal.valueOf(2).divide(i, 1024, RoundingMode.UNNECESSARY).pow(2);
			BigDecimal l1 = a.add(b);
//			long ll1 = (long) l1;
//			if (Math.abs(ll1 - l1) < 0.000000000000000000000000000000000000000000000000000000000001 && 2 * ll1 > i) {
//				k++;
//				ans += ll1;
//				System.out.println(i + " " + ll1);
//			}
//			double l2 = Math.sqrt((i - 1) * (i - 1) + ((double) i / 2) * ((double) i / 2));
//			long ll2 = (long) l2;
//			if (Math.abs(ll2 - l2) < 0.000000000000000000000000000000000000000000000000000000000001 && 2 * ll2 > i) {
//				k++;
//				ans += ll2;
//				System.out.println(i + " " + ll2);
			//}
		}
		//System.out.println(ans);
	}

	public static BigDecimal sqrt(BigDecimal d) {
		BigDecimal error = new BigDecimal("1e-15");
		BigDecimal t = new BigDecimal(String.valueOf(d));
		BigDecimal a;
		return null;
	}
}
