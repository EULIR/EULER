public class Project173 {
	public static void main(String[] args) {
		final int TARGET = 1000000;
		long ans = 0;
		for (int i = 1; 4 * i <= TARGET; i++)
			for (int j = i + 2; j * j - i * i <= TARGET; j += 2)
				ans++;
		System.out.println(ans);
	}
}
