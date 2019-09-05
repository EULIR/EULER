public class Project577 {
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i <= 4115; i++) {
			sum += i;
			long previous = i;
			long memory = 2 * i;
			for (int j = 0; j < 12345 - 3 * i; j++) {
				previous += memory;
				memory += i;
				sum += previous;
			}
		}
		System.out.println(sum);
	}
}
