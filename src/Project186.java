import java.util.LinkedList;
import java.util.stream.IntStream;

public class Project186 {
	static int[] counts = new int[1000000];
	static int[] group = new int[1000000];

	public static int trace(int po) {
		return po == group[po] ? po : (group[po] = trace(group[po]));
	}

	public static void main(String[] a) {
		Unit P = new Unit();
		IntStream.range(0, 1000000).forEach(i -> {
			group[i] = i;
			counts[i] = 1;
		});
		int ans = 0;
		while (counts[trace(524287)] < 990000) {
			int n1 = P.grab(), n2 = P.grab();
			if (n1 == n2)
				continue;
			ans++;
			if (trace(n1) == trace(n2))
				continue;
			counts[trace(n1)] += counts[trace(n2)];
			group[trace(n2)] = trace(n1);

		}
		System.out.println(ans);
	}
}

class Unit {
	int[] fib = new int[55];
	LinkedList<Integer> li = new LinkedList<>();

	public Unit() {
		for (int i = 1; i < 56; i++) {
			fib[i - 1] = (int) ((100003L - 200003L * i + 300007L * i * i * i) % 1000000L);
			li.add(fib[i - 1]);
		}
	}

	public int grab() {
		if (li.size() == 0)
			refill();
		return li.removeFirst();
	}

	void refill() {
		for (int i = 0; i < 24; i++)
			fib[i] = (fib[i + 31] + fib[i]);
		for (int i = 24; i < 55; i++)
			fib[i] = (fib[i - 24] + fib[i]);
		for (int i = 0; i < 55; i++) {
			while (fib[i] >= 1000000)
				fib[i] -= 1000000;
			li.add(fib[i]);
		}
	}
}