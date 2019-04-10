import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Project161 {
	static StringBuilder grid = new StringBuilder();
	static HashMap<String, Long> cache = new HashMap<>();

	static int x, y, len;

	public static void main(String[] args) {
		x = 9;
		y = 12;
		len = x * y;
		StringBuilder row = new StringBuilder();
		IntStream.range(0, y).mapToObj(i -> "0").forEach(row::append);
		grid.append(IntStream.range(0, x).mapToObj(i -> row).collect(Collectors.joining()));
		System.out.println(count());
	}

	public static long count() {
		String key = grid.toString();
		if (cache.containsKey(key))
			return cache.get(key);
		int pos = 0;
		while (pos < len) {
			if (grid.charAt(pos) == '0')
				break;
			pos++;
		}
		if (pos == len)
			return 1;
		long ret = 0;
		for (int p = 0; p < 6; p++) {
			if (!change(p, pos, '1'))
				continue;
			ret += count();
			change(p, pos, '0');
		}
		cache.put(key, ret);
		return ret;
	}

	public static boolean change(int pce, int pos, char set) {
		if (grid.charAt(pos) == set) return false;
		switch (pce) {
			case 0:
				if (pos / x == y - 1 || pos % x == x - 1 || grid.charAt(pos) != grid.charAt(pos + x) || grid.charAt(pos) != grid.charAt(pos + 1))
					return false;
				grid.setCharAt(pos, set);
				grid.setCharAt(pos + 1, set);
				grid.setCharAt(pos + x, set);
				break;
			case 1:
				if (pos / x == y - 1 || pos % x == x - 1 || grid.charAt(pos) != grid.charAt(pos + x + 1) || grid.charAt(pos) != grid.charAt(pos + 1))
					return false;
				grid.setCharAt(pos, set);
				grid.setCharAt(pos + 1, set);
				grid.setCharAt(pos + x + 1, set);
				break;
			case 2:
				if (pos / x == y - 1 || pos % x == x - 1 || grid.charAt(pos) != grid.charAt(pos + x) || grid.charAt(pos) != grid.charAt(pos + x + 1))
					return false;
				grid.setCharAt(pos, set);
				grid.setCharAt(pos + x, set);
				grid.setCharAt(pos + x + 1, set);
				break;
			case 3:
				if (pos / x == y - 1 || pos % x == 0 || grid.charAt(pos) != grid.charAt(pos + x) || grid.charAt(pos) != grid.charAt(pos + x - 1))
					return false;
				grid.setCharAt(pos, set);
				grid.setCharAt(pos + x, set);
				grid.setCharAt(pos + x - 1, set);
				break;
			case 4:
				if (pos / x > y - 3 || grid.charAt(pos) != grid.charAt(pos + x) || grid.charAt(pos) != grid.charAt(pos + x + x))
					return false;
				grid.setCharAt(pos, set);
				grid.setCharAt(pos + x, set);
				grid.setCharAt(pos + x + x, set);
				break;
			case 5:
				if (pos % x > x - 3 || grid.charAt(pos) != grid.charAt(pos + 1) || grid.charAt(pos) != grid.charAt(pos + 2))
					return false;
				grid.setCharAt(pos, set);
				grid.setCharAt(pos + 1, set);
				grid.setCharAt(pos + 2, set);
				break;
			default:
				break;
		}
		return true;
	}
}
