import java.util.ArrayList;

public class Project095
{
	public static void main(String[] args)
	{
		int[] divisorSum = new int[1000001];
		for (int i = 1; i <= 1000000; i++)
		{
			for (int j = i * 2; j <= 1000000; j += i)
				divisorSum[j] += i;
		}
		int max = Integer.MIN_VALUE;
		tag:
		for (int i = 2; i < 1000000; i++)
		{
			ArrayList<Integer> list = new ArrayList<>();
			list.add(i);
			int a = divisorSum[i];
			while (!list.contains(a) && a < 1000000)
			{
				list.add(a);
				a = divisorSum[a];
				if (a >= 1000000)
					continue tag;
			}
			//if (list.size() == 103)
			//	System.out.println(list);
			if (list.size() > max)
				max = list.size();
		}
		System.out.println(max);
	}
}