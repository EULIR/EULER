import java.math.BigInteger;

public class Project016
{
	public static void main(String[] args)
	{
		BigInteger bigNum = new BigInteger("2");
		String result = bigNum.pow(1000).toString();
		char[] num = result.toCharArray();
		int sum = 0;
		for (char n : num)
			sum += n - 48;
		System.out.println(sum);
	}
}