import java.util.HashSet;

public class Project111
{
	public static void generate(long num, int pos, int length, int repDig, int n, HashSet<Long> set)
	{
		if (length < n + pos)
			return;
		if (pos == length)
		{
			if (Library.isPrime(num))
				set.add(num);
			return;
		}
		if (n != 0 && !(repDig == 0 && pos == 0))
			generate(num * 10 + repDig, pos + 1, length, repDig, n - 1, set);
		for (int i = pos == 0 ? 1 : 0; i <= 9; i++)
		{
			if (i == repDig)
				continue;
			generate(num * 10 + i, pos + 1, length, repDig, n, set);
		}
	}

	public static void main(String args[])
	{
		long ans = 0;
		for (int i = 0; i <= 9; i++)
			for (int j = 10; j >= 1; j--)
			{
				HashSet<Long> set = new HashSet<>();
				generate(0, 0, 10, i, j, set);
				if (set.size() != 0)
				{
					long sum = 0;
					for (Long num : set)
						sum += num;
					ans += sum;
					break;
				}
			}
		System.out.println(ans);
	}
}
