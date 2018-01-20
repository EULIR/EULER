public class Project49
{
	private static boolean isPrime(int n)
	{
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}
	private static boolean judge(String s1, String s2, String s3)
	{
		boolean[] boo = new boolean[10];
		for (int i = 0; i < boo.length; i++)
			boo[i] = false;
		for (int i = 0; i < s1.length(); i++)
			boo[Integer.parseInt(s1.substring(i, i + 1))] = true;
		for (int i = 0; i < s2.length(); i++)
			boo[Integer.parseInt(s2.substring(i, i + 1))] = true;
		for (int i = 0; i < s3.length(); i++)
			boo[Integer.parseInt(s3.substring(i, i + 1))] = true;
		int num = 0;
		for (boolean aBoo : boo)
			if (aBoo)
				num++;
		return num == 3;
	}
	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 1001; i + 6660 < 10000; i += 2)
			if (isPrime(i))
				if (isPrime(i + 3330))
					if (isPrime(i + 6660))
					{
						String s1 = String.valueOf(i).substring(0,3);
						String s2 = String.valueOf(i + 3330).substring(0,3);
						String s3 = String.valueOf(i + 6660).substring(0,3);
						if (judge(s1, s2, s3))
							ans = i;
					}
		System.out.print(ans);
		System.out.print(ans + 3330);
		System.out.print(ans + 6660);
	}
}
