import java.math.BigInteger;

public class Project055
{
	private static BigInteger newNumber(BigInteger number)
	{
		var str1 = number.toString();
		var str2 = new StringBuilder();
		for (var i = str1.length() - 1; i >= 0; i--)
			str2.append(str1.charAt(i));
		var num = new BigInteger(str2.toString());
		return number.add(num);
	}

	private static boolean isPalindrome(BigInteger number)
	{
		var str1 = number.toString();
		var str2 = new StringBuilder();
		for (var i = str1.length() - 1; i >= 0; i--)
			str2.append(str1.charAt(i));
		return str1.equals(str2.toString());
	}

	public static void main(String[] args)
	{
		var ans = 0;
		for (var i = 1; i < 10000; i++)
		{
			var number = new BigInteger(String.valueOf(i));
			var boo = false;
			var n = 0;
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