import java.text.MessageFormat;

public class Project138 {
	public static void main(String[] args) {
		double n = 4.0D;
		double ans = 0;
		for (int i = 2; i <= 12; i++) {
			double m = (2 * n) + Math.sqrt((5 * n * n) + (i % 2 == 0 ? 1 : -1));
			ans += m * m + n * n;
			n = m;
		}
		System.out.println(MessageFormat.format("{0}", ans));
	}
}
