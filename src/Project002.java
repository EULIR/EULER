public class Project002
{
	public static void main(String[] args)
	{
		final int a = 4000000;
		int first = 1;
		int second = 1;
		int third = 0;
		int ans = 0;
		while (first < a && second < a && third < a)
		{
			third = first + second;
			//System.out.print(third + " ");
			if (third % 2 == 0)
				ans += third;
			first = second;
			second = third;
		}
		System.out.println(ans);
	}
}