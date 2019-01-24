public class Project138 {
	public static void main(String[] args) {
		int k = 0;
		long i = 3;
		long ans = 0;
		while (k < 12) {
			i++;
			double l1 = Math.sqrt((i + 1) * (i + 1) + ((double) i / 2) * ((double) i / 2));
			long ll1 = (long) l1;
			if (Math.abs(ll1 - l1) < 0.000000000000000000000000000000000000000000000000000000000001 && 2 * ll1 > i) {
				k++;
				ans += ll1;
				System.out.println(i + " " + ll1);
			}
			double l2 = Math.sqrt((i - 1) * (i - 1) + ((double) i / 2) * ((double) i / 2));
			long ll2 = (long) l2;
			if (Math.abs(ll2 - l2) < 0.000000000000000000000000000000000000000000000000000000000001 && 2 * ll2 > i) {
				k++;
				ans += ll2;
				System.out.println(i + " " + ll2);
			}
		}
		System.out.println(ans);
	}
}
