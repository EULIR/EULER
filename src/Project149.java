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
			BigInteger sum1 = BigInteger.ZERO;
			BigInteger sum2 = BigInteger.ZERO;
			for (int j = 0; j < 2000; j++) {
				sum1 = sum1.add(matrix[i][j]);
				sum2 = sum2.add(matrix[j][i]);
				if (sum1.compareTo(max) > 0)
					max = sum1;
				if (sum1.compareTo(BigInteger.ZERO) < 0)
					sum1 = BigInteger.ZERO;
				if (sum2.compareTo(max) > 0)
					max = sum2;
				if (sum2.compareTo(BigInteger.ZERO) < 0)
					sum2 = BigInteger.ZERO;
			}
		}
		for (int i = -2000; i <= 2000; i++) {
			BigInteger sum = BigInteger.ZERO;
			for (int j = 0; j < 2000; j++) {
				if ((i + j) >= 0 && (i + j) < 2000) {
					sum = sum.add(matrix[j][i + j]);
					if (sum.compareTo(max) > 0)
						max = sum;
					if (sum.compareTo(BigInteger.ZERO) < 0)
						sum = BigInteger.ZERO;
				}
			}
		}
		for (int i = 0; i <= 4000; i++) {
			BigInteger sum = BigInteger.ZERO;
			for (int j = 0; j < 2000; j++) {
				if (j - i >= 0) {
					sum = sum.add(matrix[j][j - i]);
					if (sum.compareTo(max) > 0)
						max = sum;
					if (sum.compareTo(BigInteger.ZERO) < 0)
						sum = BigInteger.ZERO;
				}
			}
		}
		System.out.println(max);
	}
}
