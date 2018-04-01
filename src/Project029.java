import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Project029
{
	public static void main(String[] args)
	{
		var list = new ArrayList<String>();
		for (var i = 2; i <= 100; i++)
			for (var j = 2; j <= 100; j++)
			{
				var big1 = new BigInteger(String.valueOf(i));
				big1 = big1.pow(j);
				var s1 = big1.toString();
				list.add(s1);
			}
		List<String> newList = new ArrayList<String>(new HashSet<>(list));
		System.out.print(newList.size());
	}
}
