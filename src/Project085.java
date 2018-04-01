public class Project085
{
	private static int countRectangle(int width, int length)
	{
		return (width + 1) * width * (length + 1) * length / 4;
	}

	public static void main(String[] args)
	{
		var area = 0;
		var difference = Integer.MAX_VALUE;
		for (var i = 1; i < Math.sqrt(2000000); i++)
			for (var j = 1; j < Math.sqrt(2000000); j++)
			{
				var t = countRectangle(i, j);
				var k = Math.abs(t - 2000000);
				if (k < difference)
				{
					difference = k;
					area = i * j;
				}
			}
		System.out.println(area);
	}
}
