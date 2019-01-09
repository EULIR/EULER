public class Project126 {
	public static void main(String[] args) {
		int[] arr = new int[50000];
		for (int x = 1; count(x, x, x, 1) < 50000; x++) {
			for (int y = x; count(x, y, x, 1) < 50000; y++) {
				for (int z = y; count(x, y, z, 1) < 50000; z++) {
					for (int n = 1; count(x, y, z, n) < 50000; n++) {
						arr[count(x, y, z, n)]++;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1000) {
				System.out.println(i);
				System.exit(0);
			}
		}
	}

	public static int count(int x, int y, int z, int num) {
		return 2 * (x * y + y * z + x * z) + 4 * (x + y + z + num - 2) * (num - 1);
	}
}
