import java.util.ArrayList;
import java.util.List;

public class Project050
{
	public static void main(String[] args)
	{
		List<Integer> primeNumber = new ArrayList<Integer>();
		for (var i = 2; i < 1000000; i++)
			if (Library.isPrime(i))
				primeNumber.add(i);
		List<Integer> cum = new ArrayList<Integer>();
		var sum = 0;
		for (int num : primeNumber)
		{
			sum += num;
			cum.add(sum);
			if (sum >= 1000000)
				break;
		}
		var prime = 0;
		var maxChain = 0;
		for (var i = 0; i < cum.size(); i++)
			for (var j = i + 1; j < cum.size(); j++)
			{
				var temp = cum.get(j) - cum.get(i);
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
