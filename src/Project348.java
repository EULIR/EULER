import java.util.Map;
import java.util.TreeMap;

public class Project348 {
	public static void main(String[] args) {
		TreeMap<Long, Integer> times = new TreeMap<>();
		final long MAX = 1100000000L;
		for (long i = 2; i * i * i <= MAX; i++) {
			for (long j = 2; i * i * i + j * j <= MAX; j++) {
				long num = i * i * i + j * j;
				if (Library.isReverse(String.valueOf(num))) {
					Integer integer = times.get(num);
					times.put(num, integer == null ? 1 : 1 + integer);
				}
			}
		}
		long ans = 0;
		int k = 0;
		for (Map.Entry<Long, Integer> ent : times.entrySet()) {
			if (ent.getValue() == 4) {
				ans += ent.getKey();
				if (k == 4) {
					System.out.println(ans);
					break;
				} else k++;
			}
		}
	}
}

