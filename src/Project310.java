import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class Project310 {
	public static void main(String args[]) {
		int n = 100000;
		int g[] = new int[n + 1];
		TreeMap<Integer, Long> cs = new TreeMap<>();
		long total = 0;
		for (int i = 0; i <= n; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 1; j * j <= i; j++) {
				set.add(g[i - j * j]);
			}
			while (set.contains(g[i]))
				g[i]++;
			if (cs.containsKey(g[i]))
				cs.put(g[i], cs.get(g[i]) + 1);
			else cs.put(g[i], 1L);
		}
		for (Iterator<Integer> iterator = cs.keySet().iterator(); iterator.hasNext(); ) {
			Integer a = iterator.next();
			long ga = cs.get(a);
			for (Iterator<Integer> iterator1 = cs.keySet().iterator(); iterator1.hasNext(); ) {
				int b = iterator1.next();
				long gb = cs.get(b);
				int c = a ^ b;
				if (cs.containsKey(c)) {
					long gc = cs.get(c);
					total += ga * gb * gc;
				}
			}
		}
		total -= cs.get(0) * (3 * n + 1);
		total /= 6;
		System.out.println(total + cs.get(0) * (n + 1));
	}
}