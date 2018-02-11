public class Project085
{
	private static int countRectangle(int width, int length)
	{
		return (width + 1) * width * (length + 1) * length / 4;
	}

	public static void main(String[] args)
	{
		int area = 0;
		int difference = Integer.MAX_VALUE;
		for (int i = 1; i < Math.sqrt(2000000); i++)
			for (int j = 1; j < Math.sqrt(2000000); j++)
			{
				int t = countRectangle(i, j);
				int k = Math.abs(t - 2000000);
				if (k < difference)
				{
					difference = k;
					area = i * j;
				}
			}
		System.out.println(area);
	}
}
