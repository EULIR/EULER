public class Project491 {
	private static int[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

	public static void main(String[] args) {
		System.out.println(search(9, 0, 0));
	}

	public static long search(int cnt, int sum, int prv) {
		if (prv > 10)
			return 0;
		if (cnt < 0)
			if (prv == 10 && sum % 11 == 1) {
				long ans = 13168189440000L; //20!
				for (int i = 0; i <= 9; i++)
					if (arr[i] != 1)
						ans /= 2;
				if (arr[0] == 1)
					ans = ans / 10 * 9;
				if (arr[0] == 2)
					ans = ans / 5 * 4;
				return ans;
			} else return 0;
		long ans = 0;
		for (int i = 0; i <= arr[cnt]; i++) {
			arr[cnt] -= i;
			ans += search(cnt - 1, sum + i * cnt, prv + i);
			arr[cnt] += i;
		}
		return ans;
	}
}
