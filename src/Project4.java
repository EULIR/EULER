public class Project4
{
	public static boolean judge(int t)
	{
		String str = String.valueOf(t);
		boolean k = true;
		for (int i = 1;i <= str.length() / 2;i++)
		{
			String s1 = str.substring(i - 1,i);
			String s2 = str.substring(str.length() - i,str.length() - i + 1);
			if (!s1.equals(s2))
			{
				k = false;
				break;
			}
		}
		return k;
	}
	public static void main(String[] args)
	{
		int t = 0;
		int ans = 0;
		for (int i = 100;i <= 999;i++)
			for (int j = i;j <= 999;j++)
			{
				t = i * j;
				if (judge(t))
				{
					if (t > ans)
						ans = t;
				}
			}
		System.out.println(ans);
	}
}