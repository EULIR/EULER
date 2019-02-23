import java.text.MessageFormat;

public class Project158 {
	public static void main(String[] args) {
		double a = 1D;
		double min = Integer.MAX_VALUE;
		for (int i = 1; i <= 26; i++) {
			a = a * (26 - i + 1) / i;
			double l = (Library.power(2, i) - i - 1) * a;
			if (min < l)
				min = l;
		}
		System.out.println(MessageFormat.format("{0}", min));
	}
}
