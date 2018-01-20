public class project7
{
	public static void main(String[] args)
	{
		boolean[] s = new boolean[200000];
		int[] a = new int[20000];
		int k = 0;
		for (int i = 2;i <= 150000;i++)
			s[i] = true;
		for (int i = 2;i <= 150000;i++)
			if (s[i])
			{
				k++;
				a[k] = i;
				for (int j = 2;j <= (150000 / i);j++)
					s[j * i] = false;
			}
		System.out.println(a[10001]);
	}
}