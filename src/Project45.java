import static java.lang.Integer.MAX_VALUE;

public class Project45
{
	private static boolean isPentagonal(long a)
	{
		long t = 24 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 6 == 5;
	}

	private static boolean isHexagonal(long a)
	{
		long t = 8 * a + 1;
		return Math.sqrt(t) * Math.sqrt(t) == t && Math.sqrt(t) % 4 == 3;
	}

	private static boolean isTriangle(long a)
	{
		long t = a * 2;
		return Math.floor(Math.sqrt(t)) * (Math.floor(Math.sqrt(t)) + 1) / 2 == a;
	}

	public static void main(String[] args)
	{
		for (int i = 1; i < MAX_VALUE; i++)
			if (isHexagonal(i))
				if (isPentagonal(i))
					if (isTriangle(i))
						System.out.println(i);
	}
}
