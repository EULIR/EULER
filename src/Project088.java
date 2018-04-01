import java.util.ArrayList;

public class Project088
{
	private static boolean judge(int p, int s, int k)
	{
		if (s < k)
			return false;
		if (p == 1)
			return s == k;
		if (k == 1)
			return p == s;
		for (var i = 2; i <= p && i <= s - k + 1; i++)
			if (p % i == 0)
				if (judge(p / i, s - i, k - 1))
					return true;
		return false;
	}

	public static void main(String[] args)
	{
		var sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (var i = 2; i <= 12000; i++)
		{
			var n = i + 1;
			while (true)
			{
				if (judge(n, n, i))
				{
					if (!list.contains(n))
					{
						list.add(n);
						sum += n;
					}
					break;
				}
				n++;
			}
		}
		System.out.println(sum);
	}
}
