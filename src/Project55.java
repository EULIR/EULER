import java.math.BigInteger;

public class Project55
{
	private static BigInteger newNumber(BigInteger number)
	{
		String str1 = number.toString();
		StringBuilder str2 = new StringBuilder();
		for (int i = str1.length() - 1; i >= 0; i--)
			str2.append(str1.charAt(i));
		BigInteger num = new BigInteger(str2.toString());
		return number.add(num);
	}

	private static boolean isPalindrome(BigInteger number)
	{
		String str1 = number.toString();
		StringBuilder str2 = new StringBuilder();
		for (int i = str1.length() - 1; i >= 0; i--)
			str2.append(str1.charAt(i));
		return str1.equals(str2.toString());
	}

	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 1; i < 10000; i++)
		{
			BigInteger number = new BigInteger(String.valueOf(i));
			boolean boo = false;
			int n = 0;
			while (n < 50)
			{
				number = newNumber(number);
				n++;
				if (isPalindrome(number))
				{
					boo = true;
					break;
				}
			}
			if (!boo)
				ans++;
		}
		System.out.println(ans);
	}
}