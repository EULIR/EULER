public class Project159 {
	public static void main(String[] args) {
		int[] arr = new int[1000000];
		for (int i = 2, j = 2; i < 1000000; i++, j = j == 9 ? 1 : j + 1)
			arr[i] = j;
		int ans = 0;
		for (int i = 2; i < 1000000; i++) {
			int d = arr[i];
			for (int j = 2, n = i + i; j <= i && n < 1000000; j++, n += i) {
				int value = (d + arr[j]);
				if (arr[n] < value)
					arr[n] = value;
			}
			ans += d;
		}
		System.out.println(ans);
	}
}
