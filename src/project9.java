public class project9
{
	public static void main(String[] args)
	{
		for (int i = 1; i <= 998; i++)
			for (int j = (i + 1); j <= (1000 - i); j++)
			{
				int k = 1000 - i - j;
				if (k > j)
					if (i * i + j * j == k * k)
						System.out.println(i * j * k);
			}
	}
}