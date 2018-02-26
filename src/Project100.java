public class Project100
{
	public static void main(String[] args)
	{
		long[] m = new long[100];
		m[0] = 1;
		long[] n = new long[100];
		n[0] = 1;
		for (int i = 1; i <= 16; i++)
		{
			m[i] = 3 * m[i - 1] + 4 * n[i - 1];
			n[i] = 2 * m[i - 1] + 3 * n[i - 1];
			if (m[i] > 1000000000000L)
			{
				System.out.println((n[i] + 1) / 2);
				System.exit(0);
			}
		}
	}
}
