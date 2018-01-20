import java.math.*;
public class Project20
{
	public static void main(String[] args)
	{
		BigInteger bigNum = new BigInteger("1");
		for (int i = 1; i <= 100; i++)
		{
			BigInteger bigNum1 = new BigInteger(String.valueOf(i));
			bigNum = bigNum.multiply(bigNum1);
		}
		String s = bigNum.toString();
		//System.out.println(s);
		//System.out.println(sum);
		int ans = 0;
		//System.out.print(s.length());
		for (int i = 0; i <= s.length() - 2; i++)
		{
			String s1 = s.substring(i,i + 1);
			int a = Integer.parseInt(s1);
			//System.out.print(a);
			ans += a;
		}
		System.out.println(ans);
	}
}