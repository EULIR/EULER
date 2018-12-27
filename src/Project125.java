import java.util.ArrayList;

public class Project125 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		double max = Math.sqrt(100000000);
		long sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= max; i++) {
			int number = i * i;
			for (int j = i + 1; j <= max; j++) {
				number += j * j;
				if (number > 100000000)
					break;
				if (Library.isReverse(number) && !list.contains(number)) {
					sum += number;
					list.add(number);
				}
			}
		}
		System.out.println(sum);
		System.out.println(System.currentTimeMillis() - time);
	}
}