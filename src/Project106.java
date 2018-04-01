public class Project106
{
	public static void main(String[] args)
	{
		var total = 0;
		var n = 12;
		for (var x = 1; x < (1 << n); x++)
			for (var y = x + 1; y < (1 << n); y++)
				if ((x & y) == 0)
				{
					var d1 = 0;
					var d2 = 0;
					for (var j = 0; j < n; j++)
						if ((x & (1 << j)) > 0)
							d1++;
					for (var j = 0; j < n; j++)
						if ((y & (1 << j)) > 0)
							d2++;
					if (d1 == d2)
					{
						var t = 0;
						var boo1 = false;
						var boo2 = false;
						for (var j = 0; j < n; j++)
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
