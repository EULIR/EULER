public class Project64
{
	public static void main(String[] args)
	{
		for (int i = 1; i <= 10000; i++)
		{
			int m = 0;
			int d = 1;
			int a = (int) Math.floor(Math.sqrt(i));
			while (a != 0)
			{
				m = d * a - m;
				d = (int) ((i - m * m) / d);
				a = (int) Math.floor(Math.floor(i));
			}
		}
	}
}
