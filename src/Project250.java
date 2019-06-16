import java.math.BigInteger;

public class Project250 {
	public static void main(String[] args) {
		int[] mods = new int[250251];
		BigInteger c = BigInteger.valueOf(250);
		long mod = (long) Math.pow(10, 16);
		for (int i = 1; i <= 250250; i++) {
			BigInteger temp = BigInteger.valueOf(i);
			temp = temp.modPow(temp, c);
			mods[i] = temp.intValue();
		}
		long[][] sum = new long[2][250];
		int count = 1;
		sum[0][0] = 3600570401554431L;
		for (int i = 1; i <= 250250; i++) {
			if (mods[i] == 0)
				continue;
			for (int j = 249; j >= 0; j--) {
				int index = j - mods[i];
				if (index < 0) index += 250;
				sum[count % 2][j] = (sum[(count - 1) % 2][j] + sum[(count - 1) % 2][index]) % mod;
			}
			sum[count % 2][mods[i]]++;
			count++;
		}
		System.out.println(sum[(count - 1) % 2][0]);
	}
}
