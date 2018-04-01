public class Project064
{
	public static void main(String[] args)
	{
		var ans = 0;
		for (var i = 1; i <= 10000; i++)
		{
			var period = 0;
			var m = 0;
			var d = 1;
			var a = (int) Math.floor(Math.sqrt(i));
			if (Library.isSquare(i))
				continue;
			while (a != 2 * (int) Math.floor(Math.sqrt(i)))
			{
				m = d * a - m;
				d = (i - m * m) / d;
				a = (int) Math.floor(((int) Math.floor(Math.sqrt(i)) + m) / d);
				period++;
			}
			if (period % 2 == 1)
				ans++;
		}
		System.out.println(ans);
	}
}
