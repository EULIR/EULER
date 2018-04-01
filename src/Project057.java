import java.math.BigInteger;

public class Project057
{
	public static void main(String[] args)
	{
		var ans = 0;
		var numberOne = new BigInteger("3");
		var numberTwo = new BigInteger("2");
		for (var i = 0; i < 1000; i++)
		{
			var substituteOne = numberOne;
			var substituteTwo = numberTwo;
			numberOne = substituteOne.add(substituteTwo).add(substituteTwo);
			numberTwo = substituteOne.add(substituteTwo);
			if (numberOne.toString().length() > numberTwo.toString().length())
				ans++;
		}
		System.out.println(ans);
	}
}
