public class Project034
{
	public static void main(String[] args)
	{
		int[] a = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		var ans = 0;
		for (var i = 10; i < 100000; i++)
		{
			var s = String.valueOf(i);
			var sum = 0;
			for (var j = 0; j < s.length(); j++)
			{
				var s1 = s.substring(j, j + 1);
				sum += a[Integer.parseInt(s1)];
			}
			if (i == sum)
				ans += i;
		}
		System.out.println(ans);
	}
}
