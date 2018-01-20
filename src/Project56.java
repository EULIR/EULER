import java.math.BigInteger;

public class Project56
{
	public static void main(String[] args)
	{
		int max = 0;
		for (int i = 1; i < 100; i++)
			for (int j = 1; j < 100; j++)
			{
				BigInteger number = new BigInteger(String.valueOf(i)).pow(j);
				String s = number.toString();
				int digitSum = 0;
				for (int k = 0; k < s.length(); k++)
				{
					String str = s.substring(k, k + 1);
					digitSum += Integer.parseInt(str);
				}
				if (digitSum > max)
					max = digitSum;
			}
		System.out.println(max);
	}
}
