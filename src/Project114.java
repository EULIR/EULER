public class Project114 {
	public static long block(int a, int b, long[] buffer) {
		long ans = 1;
		if (b > a)
			return ans;
		if (buffer[a] != 0)
			return buffer[a];
		for (int i = 0; i <= a - b; i++)
			for (int j = b; j <= a - i; j++)
				ans += block(a - i - j - 1, b, buffer);
		buffer[a] = ans;
		return ans;
	}

	public static void main(String[] args) {
		long[] buffer = new long[51];
		System.out.println(block(50, 3, buffer));
	}
}
