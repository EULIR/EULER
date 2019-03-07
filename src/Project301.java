public class Project301 {
	public static void main(String[] args) {
		int ans = 0;
		for (int n = 1; n <= 1073741824; n++)
			if ((n ^ ((2 * n) ^ (3 * n))) == 0)
				ans++;
		System.out.println(ans);
	}
}
