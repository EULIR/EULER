public class Project349 {
	public static void main(String[] args) {
		int n = 400;
		boolean[][] grid = new boolean[n][n];
		int x = n / 2;
		int y = n / 2;
		int repeat = 104;
		int start = 10400;
		int[] reference = new int[repeat + 1];
		int index = repeat + start;
		int dir = 0;
		for (int i = 0; i <= index; i++) {
			grid[x][y] = !grid[x][y];
			if (grid[x][y]) dir = (dir + 1) % 4;
			else dir = (dir + 3) % 4;
			if (dir == 0) {
				y++;
			} else if (dir == 1) {
				x++;
			} else if (dir == 2) {
				y--;
			} else if (dir == 3) {
				x--;
			}
			int count = 0;
			if (i >= start) {
				int k = 0;
				while (k < n) {
					int l = 0;
					while (l < n) {
						count += grid[k][l] ? 1 : 0;
						l++;
					}
					k++;
				}
				reference[i - start] = count;
			}
		}
		int increase = reference[reference.length - 1] - reference[0];
		long steps = (long) 1e18;
		long added = (steps - start) / repeat * increase;
		long total = added + reference[(int) ((steps - start) % repeat)];
		System.out.println(total);
	}
}