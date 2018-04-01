import java.util.ArrayList;

public class Project074
{
	private final static int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	private static int createNextNumber(int a)
	{
		var s = String.valueOf(a);
		var ans = 0;
		for (var i = 0; i < s.length(); i++)
		{
			var s1 = s.substring(i, i + 1);
			ans += fac[Integer.parseInt(s1)];
		}
		return ans;
	}

	public static void main(String[] args)
	{
		var ans = 0;
		for (var i = 1; i < 1000000; i++)
		{
			ArrayList<Integer> list = new ArrayList<>();
			var a = createNextNumber(i);
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
