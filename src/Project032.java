import static java.lang.String.valueOf;

public class Project032
{
	private static boolean judge(int a, int b, int c)
	{
		var s1 = valueOf(a);
		var s2 = valueOf(b);
		var s3 = valueOf(c);
		var boo = new boolean[10];
		for (var i = 0; i < s1.length(); i++)
		{
			var s = s1.substring(i, i + 1);
			boo[Integer.parseInt(s)] = true;
		}
		for (var i = 0; i < s2.length(); i++)
		{
			var s = s2.substring(i, i + 1);
			boo[Integer.parseInt(s)] = true;
		}
		for (var i = 0; i < s3.length(); i++)
		{
			var s = s3.substring(i, i + 1);
			boo[Integer.parseInt(s)] = true;
		}
		for (var i = 1; i <= 9; i++)
			if (!boo[i])
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		var sum = 0;
		var boo = new boolean[10001];
		for (var i = 1000; i < 10000; i++)
			for (var j = 2; j <= Math.sqrt(i); j++)
				if (i % j == 0)
					if (judge(i, j, i / j))
					{
						//System.out.println(i + " " + j + " " + i / j);
						boo[i] = true;
					}
		for (var i = 1000; i < boo.length; i++)
			if (boo[i])
				sum += i;
		System.out.print(sum);
	}
}
