public class Project120 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 3; i <= 1000; i++) {
			int r = 2 * i * ((i - 1) / 2);
			sum += r;
		}
		System.out.println(sum);
	}
}
