import java.util.ArrayList;

public class Project074
{
	final static int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	private static int createNextNumber(int a)
	{
		String s = String.valueOf(a);
		int ans = 0;
		for (int i = 0; i < s.length(); i++)
		{
			String s1 = s.substring(i, i + 1);
			ans += fac[Integer.parseInt(s1)];
		}
		return ans;
	}

	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 1; i < 1000000; i++)
		{
			ArrayList<Integer> list = new ArrayList<>();
			int a = createNextNumber(i);
			while (!list.contains(a))
			{
				list.add(a);
				a = createNextNumber(a);
			}
			//System.out.println(i + " " + list.size());
			if (list.size() == 59)
				ans++;
		}
		System.out.println(ans);
	}
}
