public class Project063
{
	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 1; i < 10; i++)
			ans += (int) (1 / (1 - Library.log(10, i)));
		System.out.println(ans);
	}
}
