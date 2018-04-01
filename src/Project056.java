import java.math.BigInteger;

public class Project056
{
	public static void main(String[] args)
	{
		var max = 0;
		for (var i = 1; i < 100; i++)
			for (var j = 1; j < 100; j++)
			{
				var number = new BigInteger(String.valueOf(i)).pow(j);
				var s = number.toString();
				var digitSum = 0;
				for (var k = 0; k < s.length(); k++)
				{
					var str = s.substring(k, k + 1);
					digitSum += Integer.parseInt(str);
				}
				if (digitSum > max)
					max = digitSum;
			}
		System.out.println(max);
	}
}
