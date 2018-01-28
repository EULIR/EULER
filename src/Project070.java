import java.util.Arrays;

public class Project070
{
	private static int euler(int n)
	{
		int res = n, a = n;
		for (int i = 2; i * i <= a; i++)
			if (a % i == 0)
			{
				res = res / i * (i - 1);
				while (a % i == 0)
					a /= i;
			}
		if (a > 1)
			res = res / a * (a - 1);
		return res;
	}

	private static boolean judge(int a, int b)
	{
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		int[] a1 = new int[7];
		int[] a2 = new int[7];
		for (int i = 0; i < s1.length(); i++)
			a1[i] = s1.charAt(i);
		for (int i = 0; i < s2.length(); i++)
			a2[i] = s2.charAt(i);
		Arrays.sort(a1);
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}

	public static void main(String[] args)
	{
		int min = 0;
		int minIndex = 1;
		for (int i = 2; i < 10000000; i++)
		{
			int euler = euler(i);
			if (judge(euler, i))
			{
				if ((long) i * min < (long) minIndex * euler)
				{
					min = euler;
					minIndex = i;
				}
			}
		}
		System.out.println(minIndex);
	}
}
