public class Project027
{
	public static void main(String[] args)
	{
		var max = 0;
		var ans = 0;
		for (var a = -997; a < 1000; a += 2)
			for (var b = 0; b <= 1000; b++)
			{
				var n = 0;
				for (var i = 0; ; i++)
				{
					if (Library.isPrime(i * i + a * i + b))
						n++;
					else break;
				}
				//if (n > 2)
				//	System.out.println(n + " " + a + " " + b);
				if (n > max)
				{
					max = n;
					ans = a * b;
				}
			}

		System.out.println(ans);
	}
}
