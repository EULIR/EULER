public class Project150 {
	public static void main(String[] args) {
		long cal = 0;
		int[][] randomNum = new int[1000][];
		for (int i = 0; i < 1000; i++) {
			randomNum[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				cal = (615949 * cal + 797807) % 1048576;
				randomNum[i][j] = (int) (cal - 524288L);
			}
		}
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < randomNum.length; i++) {
			long[][] table = new long[1000][1000];
			for (int j = randomNum.length - 1 - i; j >= 0; j--)
				for (int k = 0; k <= j; k++) {
					table[j][k] = randomNum[j][k];
					if (j + 1 <= randomNum.length - 1 - i) {
						table[j][k] += table[j + 1][k] + table[j + 1][k + 1];
						if (j + 2 <= randomNum.length - 1 - i) {
							table[j][k] -= table[j + 2][k + 1];
						}
					}
					if (table[j][k] < min) {
						min = table[j][k];
					}
				}
		}
		System.out.println(min);
	}
}
