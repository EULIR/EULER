public class Project002
{
	public static void main(String[] args)
	{
		final var a = 4000000;
		var first = 1;
		var second = 1;
		var third = 0;
		var ans = 0;
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