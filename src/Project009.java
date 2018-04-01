public class Project009
{
	public static void main(String[] args)
	{
		for (var i = 1; i <= 998; i++)
			for (var j = (i + 1); j <= (1000 - i); j++)
			{
				var k = 1000 - i - j;
				if (k > j)
					if (i * i + j * j == k * k)
						System.out.println(i * j * k);
			}
	}
}