import static java.lang.Integer.MAX_VALUE;

public class Project044
{
	public static void main(String[] args)
	{
		int min = MAX_VALUE;
		for (int i = 1; i < 3000; i++)
			for (int j = i + 1; j < 3000; j++)
			{
				int p1 = i * (3 * i - 1) / 2;
				int p2 = j * (3 * j - 1) / 2;
				if (Library.isPentagonal(p1 + p2))
					if (Library.isPentagonal(p2 - p1))
						if (p2 - p1 < min)
							min = p2 - p1;
			}
		System.out.println(min);
	}
}
