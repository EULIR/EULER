import java.math.BigInteger;

public class Project025
{
	public static void main(String[] args)
	{
		BigInteger first = new BigInteger("1");
		BigInteger second = new BigInteger("1");
		BigInteger third = new BigInteger("0");
		int k = 2;
		while (true)
		{
			third = first.add(second);
			k++;
			first = second;
			second = third;
			String s = third.toString();
			//System.out.println(s + " ");
			if (s.length() == 1000)
			{
				System.out.println(k);
				break;
			}
		}
	}
}
