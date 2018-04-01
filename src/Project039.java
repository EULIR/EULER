public class Project039
{
	public static void main(String[] args)
	{
		var maxx = 0;
		var ans = 0;
		for (var i = 3; i <= 1000; i++)
		{
			var max = 0;
			for (var j = 1; j <= i - 2; j++)
			{
				for (var k = j; k <= i - 2; k++)
				{
					var t = i - j - k;
					if (t >= k)
						if (j * j + k * k == t * t)
							max++;
				}
			}
			if (max > maxx)
			{
				maxx = max;
				ans = i;
			}
		}
		System.out.print(ans);
	}
}
