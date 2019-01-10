import java.util.HashSet;

public class Project124 {
	public static int factorProduct(int n) {
		HashSet<Integer> set = new HashSet<>();
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0) {
				set.add(j);
				n /= j;
				j = 1;
			}
		}
		if (n > 1)
			set.add(n);
		int prod = 1;
		for (Integer aSet : set) {
			//System.out.println(aSet);
			prod *= aSet;
		}
		return prod;
	}

	public static void main(String[] args) {
		int[][] arr = new int[100001][2];
		arr[1][0] = arr[1][1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i][0] = factorProduct(i);
			arr[i][1] = i;
		}
		cocktailSort(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		System.out.println(arr[10000][1]);
	}

	public static void cocktailSort(int[][] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = i; j < arr.length - i - 1; j++) {
				if (arr[j][0] > arr[j + 1][0]) {
					int[] temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			for (int j = arr.length - 1 - (i + 1); j > i; j--) {
				if (arr[j][0] < arr[j - 1][0]) {
					int[] temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
}
