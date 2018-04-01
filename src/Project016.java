import java.math.BigInteger;

public class Project016
{
	public static void main(String[] args)
	{
		var bigNum = new BigInteger("2");
		var result = bigNum.pow(1000).toString();
		var num = result.toCharArray();
		var sum = 0;
		for (var n : num)
			sum += n - 48;
		System.out.println(sum);
	}
}