public class Project069
{
	private static boolean relativelyPrime(int a, int b)
	{
		return Library.gcd(a, b) == 1;
	}

	public static void main(String[] args)
	{
		var max = 0.00D;
		var maxIndex = 0;
		for (var i = 2; i <= 1000000; i++)
		{
			if (i % 1001 != 0)
				continue;
			var number = 0;
			for (var j = 1; j <= i; j++)
				if (relativelyPrime(i, j))
					number++;
			var d = (double) i / number;
			//System.out.println(number + " " + i);
			if (d > max)
			{
				max = d;
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);
	}
}
