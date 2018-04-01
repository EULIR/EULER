import java.math.BigInteger;

public class Project020
{
	public static void main(String[] args)
	{
		var bigNum = new BigInteger("1");
		for (var i = 1; i <= 100; i++)
		{
			var bigNum1 = new BigInteger(String.valueOf(i));
			bigNum = bigNum.multiply(bigNum1);
		}
		var s = bigNum.toString();
		//System.out.println(s);
		//System.out.println(sum);
		var ans = 0;
		//System.out.print(s.length());
		for (var i = 0; i <= s.length() - 2; i++)
		{
			var s1 = s.substring(i, i + 1);
			var a = Integer.parseInt(s1);
			//System.out.print(a);
			ans += a;
		}
		System.out.println(ans);
	}
}