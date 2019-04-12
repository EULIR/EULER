public class Project167 {
	public static void main(String[] args) {
		long sum = 0;
		for (int n = 2; n <= 10; n++) {
			int b = 2 * n + 1;
			int len = 5000;
			int period = 0;
			int startPeriod = 1;
			int start = 0;
			int[] arr = null;
			while (period <= 0) {
				arr = new int[len];
				start = func(b, arr);
				period = findPeriod(arr, start, startPeriod);
				len = len * 4;
				startPeriod = (arr.length - start - 1) / 2;
			}
			long dist = 100000000000L - start - 1;
			long u = (dist / period) * (arr[start + period] - arr[start]) + arr[start + (int) (dist % period)];
			sum += u;
		}
		System.out.println(sum);
	}

	static int func(int b, int[] arr) {
		arr[0] = 2;
		arr[1] = b;
		int p = 2, testVal = b + 1, secondEven = -1, length = arr.length, posAfter2ndEven = 0;
		boolean[] used = new boolean[length * 10];
		used[2] = used[b] = true;
		while (true) {
			int hits = 0;
			if (secondEven < 0) {
				for (int i = 0, x = arr[0], y = testVal - x; x < y; i++, x = arr[i], y = testVal - x)
					if (used[y])
						hits++;
			} else {
				if (used[testVal - 2])
					hits++;
				if (used[testVal - secondEven])
					hits++;
			}
			if (hits == 1) {
				arr[p++] = testVal;
				used[testVal] = true;
				if ((testVal & 1) == 0 && secondEven < 0) {
					secondEven = testVal--;
					posAfter2ndEven = p;
				}
				if (p == length)
					return posAfter2ndEven;
			}
			testVal += secondEven > 0 ? 2 : 1;
		}
	}

	static int findPeriod(int[] list, int startPos, int startPeriod) {
		int[] diffs = new int[list.length - startPos - 1];
		for (int i = startPos; i < list.length - 1; i++)
			diffs[i - startPos] = list[i + 1] - list[i];
		for (int i = startPeriod; i < diffs.length / 2; i++) {
			int x;
			for (x = i; x < diffs.length; x++)
				if (diffs[x] != diffs[x % i])
					break;
			if (x == diffs.length)
				return i;
		}
		return -1;
	}
}