public class Project106
{
	public static void main(String[] args)
	{
		int total = 0;
		int n = 12;
		for (int x = 1; x < (1 << n); x++)
			for (int y = x + 1; y < (1 << n); y++)
				if ((x & y) == 0)
				{
					int d1 = 0;
					int d2 = 0;
					for (int j = 0; j < n; j++)
						if ((x & (1 << j)) > 0)
							d1++;
					for (int j = 0; j < n; j++)
						if ((y & (1 << j)) > 0)
							d2++;
					if (d1 == d2)
					{
						int t = 0;
						boolean boo1 = false;
						boolean boo2 = false;
						for (int j = 0; j < n; j++)
						{
							if ((x & (1 << j)) > 0)
								t++;
							if ((y & (1 << j)) > 0)
								t--;
							if (t > 0)
								boo1 = true;
							if (t < 0)
								boo2 = true;
						}
						if ((boo1 && boo2) || (!boo1 && !boo2))
							total++;
					}
				}
		System.out.println(total);
	}
}
