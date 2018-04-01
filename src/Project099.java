import java.util.Scanner;

public class Project099
{
	public static void main(String[] args)
	{
		var s = new Scanner(System.in);
		var max = 0.00;
		var maxIndex = 0;
		for (var i = 0; i < 1000; i++)
		{
			var str = s.nextLine();
			var base = Integer.parseInt(str.substring(0,str.indexOf(",")));
			var exp = Integer.parseInt(str.substring(str.indexOf(",") + 1));
			var result = exp * Library.log(10, base);
			if (result > max)
			{
				max = result;
				maxIndex = i;
			}
		}
		System.out.println(++maxIndex);
	}
}
