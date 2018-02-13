import java.util.ArrayList;

public class Project087
{
	public static void main(String[] args)
	{
		boolean[] arr = new boolean[50000001];
		final int MAX = 8000;
		boolean[] prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < MAX; i++)
			if (!prime[i])
			{
				primeList.add(i);
				for (int j = i; j < MAX; j += i)
					prime[j] = true;
			}
		for (int i = 0; i < primeList.size() && primeList.get(i) * primeList.get(i) < 50000000; i++)
			for (int j = 0; j < primeList.size() && primeList.get(j) * primeList.get(j) * primeList.get(j) < 50000000; j++)
				for (int k = 0; k < primeList.size() && primeList.get(k) * primeList.get(k) * primeList.get(k) * primeList.get(k) < 50000000; k++)
				{
					int t = primeList.get(i) * primeList.get(i) + primeList.get(j) * primeList.get(j) * primeList.get(j) + primeList.get(k) * primeList.get(k) * primeList.get(k) * primeList.get(k);
					if (t < 50000000)
						arr[t] = true;
				}
		int ans = 0;
		for (boolean b : arr)
			if (b)
				ans++;
		System.out.println(ans);
	}
}
