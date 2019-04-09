public class Project165 {
	public static void main(String[] args) {
		long key = 290797L;
		int arr[][] = new int[5000][4];
		for (int i = 0; i < 5000; i++) {
			for (int j = 0; j < 4; j++) {
				key = key * key % 50515093;
				arr[i][j] = (int) key % 500;
			}
			for (int j = 0; j < i; j++)
				intersect(arr[i][0], arr[i][1], arr[i][2], arr[i][3], arr[j][0], arr[j][1], arr[j][2], arr[j][3]);
		}
	}

	public static void intersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		long d = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
		long n1 = (x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3);
		long n2 = (x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3);
		if (d == 0) return;
		if (d < 0) {
			d = -d;
			n1 = -n1;
			n2 = -n2;
		}
		if (n1 <= 0 || n2 <= 0 || n1 >= d || n2 >= d) return;
		double xa = x1 + (x2 - x1) * (n1 / (double) d);
		double ya = y1 + (y2 - y1) * (n1 / (double) d);
		long x = (long) ((xa + 5.0E-09) * 1.0E08);
		long y = (long) ((ya + 5.0E-09) * 1.0E08);
		System.out.println(x + "  " + y);
	}
}
