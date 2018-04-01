import java.util.ArrayList;
import java.util.Collections;

public class Project038
{
	private static boolean judge(String s)
	{
		var boo = new boolean[10];
		if (s.length() != 9)
			return false;
		else
			for (var i = 0; i < s.length(); i++)
				boo[Integer.parseInt(String.valueOf(s.charAt(i)))] = true;
		for (var i = 1; i < 10; i++)
			if (!boo[i])
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		var list = new ArrayList<String>();
		for (var i = 1; i < 10000; i++)
		{
			var s = new StringBuilder();
			var n = 0;
			while (s.length() < 9)
			{
				n++;
				var k = n * i;
				s.append(k);
			}
			if (judge(s.toString()))
				list.add(s.toString());
		}
		System.out.print(Collections.max(list));
	}
}
