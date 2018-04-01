public class Project112
{
	private static boolean isBouncy(int a)
	{
		var increasing = true;
		var decreasing = true;
		var lastDigit = a % 10;
		a /= 10;
		while (a != 0)
		{
			var digit = a % 10;
			if (digit > lastDigit)
				decreasing = false;
			else if (digit < lastDigit)
				increasing = false;
			lastDigit = digit;
			a /= 10;
		}
		return !increasing && !decreasing;
	}

	public static void main(String[] args)
	{
		var bouncy = 0;
		var i = 101;
		while (true)
		{
			if (isBouncy(i))
				bouncy++;
			if (bouncy * 100 == i * 99)
			{
				System.out.println(i);
				break;
			}
			i++;
		}
	}
}
