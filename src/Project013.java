import java.math.BigDecimal;
import java.util.Scanner;

public class Project013
{
	public static void main(String[] args)
	{
		var scanner = new Scanner(System.in);
		var ans = new BigDecimal(0);
		for (var i = 1; i <= 100; i++)
		{
			BigDecimal aBigDecimal;
			aBigDecimal = scanner.nextBigDecimal();
			ans = aBigDecimal.add(ans);
		}
		System.out.println(ans);
	}
}