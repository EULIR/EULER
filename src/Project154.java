public class Project154 {
	public static void main(String[] args) {
		final int NUM = 200000;
		int[] arr1 = new int[NUM + 1];
		int[] arr2 = new int[NUM + 1];
		int five;
		int two;
		for (int i = 2; i <= NUM; i++) {
			five = i;
			two = i;
			arr1[i] = arr1[i - 1];
			arr2[i] = arr2[i - 1];
			while (five % 5 == 0) {
				arr1[i]++;
				five /= 5;
			}
			while (two % 2 == 0) {
				arr2[i]++;
				two /= 2;
			}
		}
		long count = 0;
		for (int i = 0; i <= NUM; i++)
			for (int j = 0; j <= NUM - i; j++) {
				int k = NUM - i - j;
				five = arr1[NUM] - arr1[i] - arr1[j] - arr1[k];
				two = arr2[NUM] - arr2[i] - arr2[j] - arr2[k];
				if (five >= 12 && two >= 12) count++;
			}
		System.out.println(count);
	}
}
