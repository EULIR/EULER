import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Project29
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 2; i <= 100 ; i++)
			for (int j = 2; j <= 100; j++)
			{
				BigInteger big1 = new BigInteger(String.valueOf(i));
				big1 = big1.pow(j);
				String s1 = big1.toString();
				list.add(s1);
			}
		List<String> newList = new ArrayList<String>(new HashSet<>(list));
		System.out.print(newList.size());
	}
}
