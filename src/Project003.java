public class Project003
{
	public static void main(String[] args)
	{
		var a = 600851475143l;
		long ans = 1;
		long fac = 2;
		while (a > 1)
		{
			if (a % fac == 0)
			{
				ans = fac;
				a /= fac;
				while (a % fac == 0)
					a /= fac;
			}
			fac++;
		}
		System.out.println(ans);
	}
}