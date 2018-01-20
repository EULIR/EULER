import java.util.ArrayList;

public class Project060
{
	private static boolean isPrime(int n)
	{
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	private static boolean connect(int n, int m)
	{
		String s1 = String.valueOf(n) + String.valueOf(m);
		String s2 = String.valueOf(m) + String.valueOf(n);
		return isPrime(Integer.parseInt(s1)) && isPrime(Integer.parseInt(s2));
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i = 2; i < 10000; i++)
			if (isPrime(i))
				prime.add(i);
		for (int i = 0; i < prime.size(); i++)
			for (int j = i + 1; j < prime.size(); j++)
				for (int k = j + 1; k < prime.size(); k++)
					for (int l = k + 1; l < prime.size(); l++)
						for (int m = l + 1; m < prime.size(); m++)
						{
							int primeOne = prime.get(i);
							int primeTwo = prime.get(j);
							int primeThree = prime.get(k);
							int primeFour = prime.get(l);
							int primeFive = prime.get(m);
							if (connect(primeOne, primeTwo))
								if (connect(primeOne, primeThree))
									if (connect(primeOne, primeFour))
										if (connect(primeOne, primeFive))
											if (connect(primeTwo, primeThree))
												if (connect(primeTwo, primeFour))
													if (connect(primeTwo, primeFive))
														if (connect(primeThree, primeFour))
															if (connect(primeThree, primeFive))
																if (connect(primeFour, primeFive))
																	System.out.println(primeOne + primeTwo + primeThree + primeFour + primeFive);
						}
	}
}
