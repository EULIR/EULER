public class Project030
{
	public static void main(String[] args)
	{
		int[] a = {0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049};
		var ans = 0;
		for (var i = 2; i < 1000000; i++)
		{
			var s1 = String.valueOf(i);
			var sum = 0;
			for (var j = 0; j < s1.length(); j++)
			{
				var s2 = s1.substring(j, j + 1);
				var k = Integer.parseInt(s2);
				sum += a[k];
			}
			if (sum == i)
				ans += i;
		}
		System.out.print(ans);
	}
}
