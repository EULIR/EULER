import java.util.stream.IntStream;

public class Project206 {
	public static void main(String[] args) {
		IntStream.iterate(1010101010, i -> i < 1389026623, i -> i + 10).forEach(i -> {
			long square = (long) i * (long) i;
			if (match(String.valueOf(square))) {
				System.out.println(i);
				System.exit(0);
			}
		});
	}

	public static boolean match(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i += 2) {
			sb.append(str, i, i + 1);
		}
		//System.out.println(sb.toString());
		return sb.toString().equals("1234567890");
	}
}
