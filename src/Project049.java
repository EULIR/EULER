public class Project049
{
	private static boolean judge(String s1, String s2, String s3)
	{
		var boo = new boolean[10];
		for (var i = 0; i < boo.length; i++)
			boo[i] = false;
		for (var i = 0; i < s1.length(); i++)
			boo[Integer.parseInt(s1.substring(i, i + 1))] = true;
		for (var i = 0; i < s2.length(); i++)
			boo[Integer.parseInt(s2.substring(i, i + 1))] = true;
		for (var i = 0; i < s3.length(); i++)
			boo[Integer.parseInt(s3.substring(i, i + 1))] = true;
		var num = 0;
		for (var aBoo : boo)
			if (aBoo)
				num++;
		return num == 3;
	}

	public static void main(String[] args)
	{
		var ans = 0;
		for (var i = 1001; i + 6660 < 10000; i += 2)
			if (Library.isPrime(i))
				if (Library.isPrime(i + 3330))
					if (Library.isPrime(i + 6660))
					{
						var s1 = String.valueOf(i).substring(0, 3);
						var s2 = String.valueOf(i + 3330).substring(0, 3);
						var s3 = String.valueOf(i + 6660).substring(0, 3);
						if (judge(s1, s2, s3))
							ans = i;
					}
		System.out.print(ans);
		System.out.print(ans + 3330);
		System.out.print(ans + 6660);
	}
}
