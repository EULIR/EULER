import java.math.BigInteger;

public class Project149 {
	public static void main(String[] args) {
		BigInteger[] arr = new BigInteger[4000001];
		for (int i = 1; i < arr.length; i++) {
			if (i <= 55) {
				BigInteger a = new BigInteger(String.valueOf(100003)).mod(BigInteger.valueOf(1000000));
				BigInteger b = new BigInteger(String.valueOf(200003)).multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(1000000));
				BigInteger c = new BigInteger(String.valueOf(300007)).multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(1000000));
				arr[i] = a.subtract(b).add(c).mod(BigInteger.valueOf(1000000));
				arr[i] = arr[i].subtract(BigInteger.valueOf(500000));
			} else {
				arr[i] = arr[i - 24].add(arr[i - 55]).add(BigInteger.valueOf(1000000)).mod(BigInteger.valueOf(1000000));
				arr[i] = arr[i].subtract(BigInteger.valueOf(500000));
			}
		}
		BigInteger[][] matrix = new BigInteger[2000][2000];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = arr[2000 * i + j + 1];
			}
		}
		BigInteger max = BigInteger.ZERO;
		for (int i = 0; i < 2000; i++) {
			int x = 1999;
			int y = i;
			BigInteger sum = BigInteger.ZERO;
			while (y >= 0) {
				sum = sum.add(matrix[x][y]);
				y--;
				x--;
			}
			if (sum.compareTo(max) > 0)
				max = sum;
		}
		for (int i = 1; i < 2000; i++) {
			int x = 1999 - i;
			int y = 1999;
			BigInteger sum = BigInteger.ZERO;
			while (x >= 0) {
				sum = sum.add(matrix[x][y]);
				y--;
				x--;
			}
			if (sum.compareTo(max) > 0)
				max = sum;
		}
		System.out.println(max);
	}
}
