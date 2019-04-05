import java.math.BigInteger;

public class Project140 {
	public static void main(String[] args) {
		BigInteger[] arr = new BigInteger[30];
		arr[0] = BigInteger.valueOf(2);
		arr[1] = BigInteger.valueOf(5);
		arr[2] = BigInteger.valueOf(21);
		arr[3] = BigInteger.valueOf(42);
		BigInteger ans = BigInteger.valueOf(70);
		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i - 2].multiply(BigInteger.valueOf(7)).subtract(arr[i - 4]).add(BigInteger.valueOf(7));
			ans = ans.add(arr[i]);
		}
		System.out.println(ans);
	}
}
