import java.util.ArrayList;

public class Project175 {
	public static void main(String[] args) {
		long n = 13717421;
		long m = 109739369;
		long a = 0;
		long b = 1;
		long c = 1;
		long d = 1;
		boolean equal = false;
		ArrayList<Long> store = new ArrayList<>();
		long count = 0;
		int old = -1;
		int first = -1;
		while (!equal) {
			long add1 = a + c;
			long add2 = b + d;
			long diff = add1 * m - n * add2;
			if (diff == 0) equal = true;
			else if (diff < 0) {
				a = add1;
				b = add2;
				if (old == -1) {
					first = 0;
					old = 0;
					count++;
				} else if (old == 0) count++;
				else {
					store.add(count);
					count = 1;
					old = 0;
				}
			} else {
				c = add1;
				d = add2;
				if (old == -1) {
					first = 1;
					old = 1;
					count++;
				} else if (old == 1) count++;
				else {
					store.add(count);
					count = 1;
					old = 1;
				}
			}
		}
		store.add(count);
		StringBuilder s = new StringBuilder((first == 1) ? ("," + (store.get(0) + 1)) : ("," + (store.get(0)) + ",1"));
		first = (first + 1) % 2;
		for (int i = 1; i < store.size() - 1; i++) {
			s.insert(0, "," + store.get(i));
			first = (first + 1) % 2;
		}
		s = new StringBuilder(first == 0 ? s.insert(0, "1," + store.get(store.size() - 1)) : (1 + store.get(store.size() - 1)) + s.toString());
		System.out.println(s);
	}
}
