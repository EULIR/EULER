public class Project116 {
	public static void main(String[] args) {
		int length = 50;
		long ans = 0;
		for (int i = 2; i < 5; i++) {
			long[] arr = new long[length + 1];
			arr[0] = 1;
			for (int j = 1; j <= length; j++) {
				arr[j] += arr[j - 1];
				if (j >= i)
					arr[j] += arr[j - i];
			}
			ans += arr[length] - 1;
		}
		System.out.println(ans);
	}
}