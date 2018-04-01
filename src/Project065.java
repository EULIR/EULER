import java.math.BigInteger;

public class Project065
{
	public static void main(String[] args)
	{
		var d = new BigInteger("1");
		var n = new BigInteger("2");
		for (var i = 2; i <= 100; i++)
		{
			long c;
			var temp = d;
			if (i % 3 == 0)
				c = 2 * (i / 3);
			else c = 1;
			var BigC = new BigInteger(c + "");
			d = n;
			n = d.multiply(BigC).add(temp);
		}
		var Str = n.toString();
		var result = 0;
		for (var i = 0; i < Str.length(); i++)
			result += Integer.valueOf(Str.charAt(i) + "");
		System.out.println(result);
	}
}
