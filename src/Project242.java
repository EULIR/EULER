public class Project242 {
	public static void main(String[] args) {
		long MAX = 1000000000000L;
		MAX--;
		MAX /= 4;
		long ans = 1;
		long p = 1;
		while (MAX != 0) {
			if ((MAX & 1) == 1)
				ans = (ans * 2) + p;
			p *= 3;
			MAX /= 2;
		}
		System.out.println(ans);
	}
}
