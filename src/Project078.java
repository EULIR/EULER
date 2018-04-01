public class Project078
{
	private static void cal(int a)
	{
		var arr = new int[a];
		arr[0] = 1;
		for (var i = 1; i < a; i++)
			for (var j = i; j < a; j++)
			{
				arr[j] += arr[j - i];
				arr[j] %= 1000000;
			}
		for (var i = 0; i < a; i++)
			if (arr[i] == 0)
			{
				System.out.println(i);
				System.exit(0);
			}
	}

	public static void main(String[] args)
	{
		var a = 1;
		while (true)
			cal(a *= 2);
	}
}
