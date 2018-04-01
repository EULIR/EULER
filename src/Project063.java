public class Project063
{
	public static void main(String[] args)
	{
		var ans = 0;
		for (var i = 1; i < 10; i++)
			ans += (int) (1 / (1 - Library.log(10, i)));
		System.out.println(ans);
	}
}
