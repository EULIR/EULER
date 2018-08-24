public class Project117 {
	public static void main(String[] args) {
		int LENGTH = 50;
		long[] arr = new long[LENGTH + 1];
		arr[0] = 1;
		for (int i = 1; i <= LENGTH; i++) {
			for (int j = 1; j <= 4 && j <= i; j++)
				arr[i] += arr[i - j];
		}
		System.out.println(arr[LENGTH]);
	}
}
