import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Project336 {
	public static void main(String[] args) {
		ArrayList<String>[] arr = new ArrayList[12];
		IntStream.rangeClosed(1, 11).forEach(i -> arr[i] = new ArrayList<>());
		arr[3].add("BAC");
		IntStream.rangeClosed(4, 11).forEach(i -> {
			ArrayList<String> arrangement = arr[i - 1];
			arrangement.forEach(s -> arr[i].addAll(generateNext(s)));
			Collections.sort(arr[i]);
		});
		System.out.println(arr[6].get(9));
		System.out.println(arr[11].get(2010));
	}

	private static ArrayList<String> generateNext(String a) {
		char[] c = a.toCharArray();
		IntStream.range(0, c.length).forEach(i -> c[i]++);
		String b = "A" + new String(c);
		b = reverse(b, 0);
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 1; i < b.length() - 1; i++)
			ans.add(reverse(b, i));
		return ans;
	}

	private static String reverse(String b, int begin) {
		char[] c = new char[b.length()];
		IntStream.range(0, begin).forEach(i -> c[i] = b.charAt(i));
		IntStream.range(begin, b.length()).forEach(i -> c[i] = b.charAt(begin + b.length() - i - 1));
		return new String(c);
	}
}
