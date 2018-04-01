import java.math.BigInteger;

public class Project025
{
	public static void main(String[] args)
	{
		var first = new BigInteger("1");
		var second = new BigInteger("1");
		BigInteger third;
		var k = 2;
		while (true)
		{
			third = first.add(second);
			k++;
			first = second;
			second = third;
			var s = third.toString();
			//System.out.println(s + " ");
			if (s.length() == 1000)
			{
				System.out.println(k);
				break;
			}
		}
	}
}
