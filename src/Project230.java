import java.util.stream.IntStream;

public class Project230 {
	public static void main(String[] args) {
		String str1 = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
		String str2 = "8214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196";
		long[] arr = new long[75];
		arr[0] = arr[1] = 100;
		IntStream.range(2, 75).forEach(i -> arr[i] = arr[i - 1] + arr[i - 2]);
		long pow7 = 1;
		StringBuilder sb = new StringBuilder(17);
		for (int i = 0; i < 18; i++) {
			if (i > 0)
				pow7 *= 7;
			long d = (127 + 19 * i) * pow7;
			int fl = 0;
			while (arr[fl] < d)
				fl++;
			while (fl > 1) {
				if (d > arr[fl - 2]) {
					d -= arr[fl - 2];
					fl--;
				} else
					fl -= 2;
			}
			sb.insert(0, fl == 0 ? str1.charAt((int) d - 1) : str2.charAt((int) d - 1));
		}
		System.out.println(sb.toString());
	}
}