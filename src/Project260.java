public class Project260 {
	static int L = 1000;
	static short[][][] f = new short[L + 1][L + 1][];

	public static void main(String[] args) {
		for (int x = 0; x <= L; ++x)
			for (int y = x; y <= L; ++y) {
				f[x][y] = new short[L - y + 2];
				for (int z = 0; z < L - y + 2; ++z)
					f[x][y][z] = (short) z;
			}
		long ans = 0;
		for (int x = 0; x <= L; ++x)
			for (int y = x; y <= L; ++y) {
				if (f[x][y] == null) continue;
				int z = f[x][y][0] + y;
				if (z > L) continue;
				ans += x + y + z;
				f[x][y] = null;
				f[x][z] = null;
				f[y][z] = null;
				for (int y2 = y + 1; y2 < z; ++y2) delete(x, y2, z);
				for (int x2 = x + 1; x2 < y; ++x2) delete(x2, y, z);
				for (int x2 = y; x2 < z; ++x2) delete(y, x2, z);
				int maxn = L - z;
				for (int n = 1; n <= maxn; ++n) delete(x, y + n, z + n);
				maxn = y - x;
				for (int n = 1; n <= maxn; ++n) delete(x + n, y, z + n);
				maxn = L - x;
				for (int n = y - x; n <= maxn; ++n) delete(y, x + n, z + n);
				maxn = L - z;
				for (int n = 1; n <= maxn; ++n) delete(x + n, y + n, z + n);
				maxn = z - y;
				for (int n = 1; n <= maxn; ++n) delete(x + n, y + n, z);
				maxn = Math.min(L - y, z - x);
				for (int n = z - y; n <= maxn; ++n) delete(x + n, z, y + n);
				maxn = L - y;
				for (int n = Math.min(L - y, z - x); n <= maxn; ++n)
					delete(z, x + n, y + n);
			}
		System.out.println(ans);
	}

	public static void delete(int x, int y, int z) {
		short[] a = f[x][y];
		if (a == null)
			return;
		if (z > L)
			return;
		z -= y;
		int n = a[z + 1];
		if (n <= z)
			return;
		int p = a[z] + 1;
		if (p > z) p = z;
		a[z + 1] = (short) z;
		a[p] = (short) n;
		a[n] = (short) (p - 1);
	}
}
