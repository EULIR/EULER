import static java.lang.String.valueOf;

public class Project32
{
	private static boolean judge(int a, int b, int c)
	{
		String s1 = valueOf(a);
		String s2 = valueOf(b);
		String s3 = valueOf(c);
		boolean[] boo = new boolean[10];
		for (int i = 0; i < s1.length(); i++)
		{
			String s = s1.substring(i,i + 1);
			boo[Integer.parseInt(s)] = true;
		}
		for (int i = 0; i < s2.length(); i++)
		{
			String s = s2.substring(i,i + 1);
			boo[Integer.parseInt(s)] = true;
		}
		for (int i = 0; i < s3.length(); i++)
		{
			String s = s3.substring(i,i + 1);
			boo[Integer.parseInt(s)] = true;
		}
		for (int i = 1; i <= 9; i++)
			if (!boo[i])
				return false;
		return true;
	}
	public static void main(String[] args)
	{
		int sum = 0;
		boolean[] boo = new boolean[10001];
		for (int i = 1000; i < 10000; i++)
			for (int j = 2; j <= Math.sqrt(i); j++)
				if (i % j == 0)
					if (judge(i, j, i / j))
					{
						//System.out.println(i + " " + j + " " + i / j);
						boo[i] = true;
					}
		for (int i = 1000; i < boo.length; i++)
			if (boo[i])
				sum += i;
		System.out.print(sum);
	}
}
