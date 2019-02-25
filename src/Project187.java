import java.util.ArrayList;

public class Project187 {
	public static void main(String[] args) {
		final int MAX = 50000000;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i]) {
				primeList.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		int num = 0;
		for (int i = 0; primeList.get(i) < Math.sqrt(2 * MAX); i++) {
			for (int j = i; j < primeList.size(); j++) {
				if (primeList.get(i) * primeList.get(j) < 2 * MAX)
					num++;
				else break;
			}
		}
		System.out.println(num);
	}
}
