public class Project63
{
	private static double log(double value)
	{
		double lnb = Math.log((double) 10);
		double lnv = Math.log(value);
		return lnv / lnb;
	}

	public static void main(String[] args)
	{
		int ans = 0;
		for (int i = 1; i < 10; i++)
			ans += (int) (1 / (1 - log(i)));
		System.out.println(ans);
	}
}
