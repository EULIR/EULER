public class Project046
{
	private static boolean isTure(int a)
	{
		for (var i = 2; i < a; i++)
			if (Library.isPrime(i))
			{
				var t = a - i;
				t /= 2;
				if (Library.isSquare(t))
					return false;
			}
		return true;
	}

	public static void main(String[] args)
	{
		var n = 1;
		while (true)
		{
			n += 2;
			if (Library.isPrime(n))
				continue;
			if (isTure(n))
			{
				System.out.println(n);
				break;
			}
		}
	}
}
