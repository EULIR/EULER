import java.math.BigInteger;

public class Project57
{
	public static void main(String[] args)
	{
		int ans = 0;
		BigInteger numberOne = new BigInteger("3");
		BigInteger numberTwo = new BigInteger("2");
		for (int i = 0; i < 1000; i++)
		{
			BigInteger substituteOne = numberOne;
			BigInteger substituteTwo = numberTwo;
			numberOne = substituteOne.add(substituteTwo).add(substituteTwo);
			numberTwo = substituteOne.add(substituteTwo);
			if (numberOne.toString().length() > numberTwo.toString().length())
				ans++;
		}
		System.out.println(ans);
	}
}
