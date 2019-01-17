import java.util.HashMap;
import java.util.Map;

public class Project113 {
	static Map<String, Long> map = new HashMap<>();

	private static long combination(int m, int n) {
		String key = m + "," + n;
		if (n == 0)
			return 1;
		if (n == 1)
			return m;
		if (n > m / 2)
			return combination(m, m - n);
		if (n > 1) {
			if (!map.containsKey(key))
				map.put(key, combination(m - 1, n - 1) + combination(m - 1, n));
			return map.get(key);
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(combination(110, 10) + combination(109, 9) - 1002);
	}
}
