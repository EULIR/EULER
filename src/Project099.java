import java.util.Scanner;

public class Project099
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		double max = 0.00;
		int maxIndex = 0;
		for (int i = 0; i < 1000; i++)
		{
			String str = s.nextLine();
			int base = Integer.parseInt(str.substring(0,str.indexOf(",")));
			int exp = Integer.parseInt(str.substring(str.indexOf(",") + 1));
			double result = exp * Library.log(10, base);
			if (result > max)
			{
				max = result;
				maxIndex = i;
			}
		}
		System.out.println(++maxIndex);
	}
}
