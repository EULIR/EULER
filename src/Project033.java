public class Project033
{
	public static void main(String[] args)
	{
		var num = 1;
		var den = 1;
		for (var i = 10; i < 100; i++)
			for (var j = i + 1; j < 100; j++)
			{
				if (i % 11 == 0 && j % 11 == 0)
					continue;
				var a1 = i / 10;
				var a2 = i % 10;
				var b1 = j / 10;
				var b2 = j % 10;
				if (a2 == b1)
				{
					var k = (double) a1 / b2;
					var t = (double) i / j;
					if (k == t)
					{
						num *= i;
						den *= j;
						//System.out.print(i + " " + j + " ");
					}
				}
			}
		var g = Library.gcd(num, den);
		//System.out.print(num + " " + den);
		System.out.print(den / g);
	}
}
