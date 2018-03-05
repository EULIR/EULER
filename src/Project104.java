import java.math.BigInteger;
import java.util.Arrays;

public class Project104
{
	private static boolean judge(String str)
	{
		char[] c = str.toCharArray();
		char[] arr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		Arrays.sort(c);
		return Arrays.equals(arr, c);
	}

	public static void main(String[] args)
	{
		BigInteger one = BigInteger.ONE;
		BigInteger two = BigInteger.ONE;
		BigInteger three;
		int k = 2;
		while (true)
		{
			three = one.add(two);
			one = two;
			two = three;
			k++;
			if (k < 541)
				continue;
			if (judge(three.toString().substring(0, 9)))
				if (judge(Library.reverse(three.toString()).substring(0, 9)))
				{
					System.out.println(k);
					break;
				}
		}
	}
}
