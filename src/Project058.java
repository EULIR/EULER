public class Project058
{
	public static void main(String[] args)
	{
		var primeNumber = 0;
		var i = 1;
		while (true)
		{
			i++;
			var a = (2 * i - 1) * (2 * i - 1) - 6 * (i - 1);
			var b = (2 * i - 1) * (2 * i - 1) - 4 * (i - 1);
			var c = (2 * i - 1) * (2 * i - 1) - 2 * (i - 1);
			var num = 4 * i - 3;
			if (Library.isPrime(a))
				primeNumber++;
			if (Library.isPrime(b))
				primeNumber++;
			if (Library.isPrime(c))
				primeNumber++;
			if ((float) primeNumber / num < 0.1)
			{
				System.out.println(2 * i - 1);
				break;
			}
		}
	}
}
