import java.util.ArrayList;

public class Project087
{
	public static void main(String[] args)
	{
		var arr = new boolean[50000001];
		final var MAX = 8000;
		var prime = new boolean[MAX + 5];
		ArrayList<Integer> primeList = new ArrayList<>();
		for (var i = 2; i < MAX; i++)
			if (!prime[i])
			{
				primeList.add(i);
				for (var j = i; j < MAX; j += i)
					prime[j] = true;
			}
		for (var i = 0; i < primeList.size() && primeList.get(i) * primeList.get(i) < 50000000; i++)
			for (var j = 0; j < primeList.size() && primeList.get(j) * primeList.get(j) * primeList.get(j) < 50000000; j++)
				for (var k = 0; k < primeList.size() && primeList.get(k) * primeList.get(k) * primeList.get(k) * primeList.get(k) < 50000000; k++)
				{
					var t = primeList.get(i) * primeList.get(i) + primeList.get(j) * primeList.get(j) * primeList.get(j) + primeList.get(k) * primeList.get(k) * primeList.get(k) * primeList.get(k);
					if (t < 50000000)
						arr[t] = true;
				}
		var ans = 0;
		for (var b : arr)
			if (b)
				ans++;
		System.out.println(ans);
	}
}
