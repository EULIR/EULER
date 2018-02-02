import java.util.HashSet;
import java.util.Set;

public class Project075
{
	public static void main(String[] args)
	{
		Set<int[]> triples = new HashSet<>();
		for (int s = 3; s * s <= 1500000; s += 2)
			for (int t = s - 2; t > 0; t -= 2)
				if (Library.gcd(s, t) == 1)
				{
					int a = s * t;
					int b = (s * s - t * t) / 2;
					int c = (s * s + t * t) / 2;
					if (a + b + c <= 1500000)
						triples.add(new int[]{a, b, c});
				}
		byte[] solution = new byte[1500001];
		for (int[] triple : triples)
		{
			int sum = triple[0] + triple[1] + triple[2];
			for (int i = sum; i < solution.length; i += sum)
				solution[i] = (byte) Library.min(solution[i] + 1, 2);
		}
		int ans = 0;
		for (int s : solution)
			if (s == 1)
				ans++;
		System.out.println(ans);
	}
}
