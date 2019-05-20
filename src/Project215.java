import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;

public class Project215 {
	public static void main(String args[]) {
		int n = 32;
		int m = 10;
		BitSet cracks = new BitSet(n - 1);
		ArrayList<BitSet> rows = new ArrayList<>();
		generateRows(cracks, rows, -1, n);
		boolean[][] canConnect = new boolean[rows.size()][rows.size()];
		for (int i = 0; i < rows.size(); i++)
			for (int j = 0; j <= i; j++) {
				canConnect[i][j] = !rows.get(i).intersects(rows.get(j));
				canConnect[j][i] = canConnect[i][j];
			}
		long[] c = new long[rows.size()];
		Arrays.fill(c, 1);
		long[] nc = new long[rows.size()];
		for (int i = 1; i < m; i++) {
			Arrays.fill(nc, 0);
			for (int j = 0; j < nc.length; j++)
				for (int k = 0; k < nc.length; k++)
					if (canConnect[j][k])
						nc[k] += c[j];
			long[] temp = c;
			c = nc;
			nc = temp;
		}
		System.out.println(Arrays.stream(c).sum());
	}

	public static void generateRows(BitSet r, Collection<BitSet> rows, int pos, int n) {
		if (pos >= n - 4) {
			if (pos == n - 4 || pos == n - 3)
				rows.add(r);
			return;
		}
		BitSet r2 = (BitSet) r.clone();
		r2.set(pos + 2);
		generateRows(r2, rows, pos + 2, n);
		BitSet r3 = (BitSet) r.clone();
		r3.set(pos + 3);
		generateRows(r3, rows, pos + 3, n);
	}

}
