import java.util.stream.IntStream;

public class Project238 {
	public static void main(String[] args) {
		long max = 2 * (long) Math.pow(10, 15);
		int[] ind = new int[17207334];
		int[] tot = new int[17207334];
		int ct = 0;
		long total = 0;
		for (int i = 0, j = 0, k = 14025256; ; i++, k = (k * k) % 20300713) {
			if (i > 0 && k == 14025256)
				break;
			String st = String.valueOf(k);
			char[] charArray = st.toCharArray();
			for (char c : charArray) {
				int x = c - '0';
				ct++;
				if (x == 0) continue;
				total += x;
				ind[j] = ct;
				tot[j] = (int) total;
				j++;
			}
		}
		final int max2 = 100000000;
		int[] found = IntStream.range(0, Math.toIntExact(total)).map(i -> max2).toArray();
		long mn = 0;
		for (int i = -1; i < tot.length; i++) {
			int ti = i < 0 ? 0 : tot[i];
			int ii = i < 0 ? 0 : ind[i];
			for (int aTot : tot) {
				int k = aTot - ti;
				if (k <= 0) k += total;
				found[Math.toIntExact(k - 1)] = Math.min(found[Math.toIntExact(k - 1)], ii + 1);
			}
			if (found[Math.toIntExact(mn)] < max2)
				while (mn <= max && mn < found.length && found[Math.toIntExact(mn)] < max2)
					mn++;
			if (mn > max || mn == found.length)
				break;
		}
		long ans = 0;
		for (int i = 0; i < total; i++) ans += found[Math.toIntExact(i % total)];
		long tota = 0;
		for (int i = 0; i < max % total; i++) tota += found[Math.toIntExact(i % total)];
		System.out.println(tota + ans * (max / total));
	}
}
