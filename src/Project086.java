public class Project086
{
	public static void main(String[] args)
	{
		int i = 0;
		int count = 0;
		while (count <= 1000000)
		{
			i++;
			for (int j = 2; j <= 2 * i + 1; j++)
				if (Library.isSquare(i * i + j * j))
					count += j <= i ? j / 2 : i - (j - 1) / 2;
		}
		System.out.println(i);
	}
}
