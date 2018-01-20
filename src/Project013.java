import java.math.BigDecimal;
import java.util.Scanner;

public class Project013
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		BigDecimal ans = new BigDecimal(0);
		for (int i = 1; i <= 100; i++)
		{
			BigDecimal aBigDecimal;
			aBigDecimal = scanner.nextBigDecimal();
			ans = aBigDecimal.add(ans);
		}
		System.out.println(ans);
	}
}