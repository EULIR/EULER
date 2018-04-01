public class Project035
{
	public static void main(String[] args)
	{
		var a = new String[6];
		var ans = 1;
		for (var i = 3; i < 1000000; i++)
		{
			var s1 = String.valueOf(i);
			for (var j = 0; j < s1.length(); j++)
				a[j] = s1.substring(j, j + 1);
			var boo = true;
			for (var j = 0; j < s1.length(); j++)
			{
				var s = new StringBuilder();
				for (var k = j; k < s1.length() + j; k++)
					s.append(a[k % s1.length()]);
				if (!Library.isPrime(Integer.parseInt(s.toString())))
				{
					boo = false;
					break;
				}
			}
			if (boo)
			{
				ans++;
				//System.out.print(i + " ");
			}
		}
		System.out.print(ans);
	}
}