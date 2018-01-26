import java.util.ArrayList;
import java.util.List;

public class Project050
{
	public static void main(String[] args)
	{
		List<Integer> primeNumber = new ArrayList<Integer>();
		for (int i = 2; i < 1000000; i++)
			if (Library.isPrime(i))
				primeNumber.add(i);
		List<Integer> cum = new ArrayList<Integer>();
		int sum = 0;
		for (int num : primeNumber)
		{
			sum += num;
			cum.add(sum);
			if (sum >= 1000000)
				break;
		}
		int prime = 0;
		int maxChain = 0;
		for (int i = 0; i < cum.size(); i++)
			for (int j = i + 1; j < cum.size(); j++)
			{
				int temp = cum.get(j) - cum.get(i);
				if ((j - i + 1) > maxChain)
					if (primeNumber.contains(temp))
					{
						maxChain = j - i + 1;
						prime = temp;
					}
			}
		System.out.println(prime);
	}
}
