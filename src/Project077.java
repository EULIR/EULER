public class Project077
{
	private static void cal(int a)
	{
		int[] arr = new int[a];
		arr[0] = 1;
		for (int i = 0; i < a; i++)
		{
			if (!Library.isPrime(i))
				continue;
			for (int j = i; j < a; j++)
				arr[j] += arr[j - i];
		}
		for (int i = 0; i < a; i++)
			if (arr[i] > 5000)
			{
				System.out.println(i);
				System.exit(0);
			}
	}

	public static void main(String[] args)
	{
		int a = 1;
		while (true)
			cal(a *= 2);
	}
}
