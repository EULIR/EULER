public class Project148 {
	public static void main(String[] args) {
		long[][] units = new long[13][8];
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j <= 7; j++) {
				units[i][j] = (i == 0) ? ((j * (j + 1)) / 2) : (((j * (j + 1)) / 2) * units[i - 1][7]);
			}
		}
		long ans = 0;
		int i = 0;
		long rows = 1000000000L;
		while (rows > 0) {
			int mod = (int) (rows % 7);
			ans = ans * (mod + 1) + units[i][mod];
			rows /= 7;
			i++;
		}
		System.out.println(ans);
	}
}