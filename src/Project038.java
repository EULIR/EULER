import java.util.ArrayList;
import java.util.Collections;

public class Project038
{
	private static boolean judge(String s)
	{
		boolean[] boo = new boolean[10];
		if (s.length() != 9)
			return false;
		else
			for (int i = 0; i < s.length(); i++)
				boo[Integer.parseInt(String.valueOf(s.charAt(i)))] = true;
		for (int i = 1; i < 10; i++)
			if (!boo[i])
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < 10000; i++)
		{
			StringBuilder s = new StringBuilder();
			int n = 0;
			while (s.length() < 9)
			{
				n++;
				int k = n * i;
				s.append(k);
			}
			if (judge(s.toString()))
				list.add(s.toString());
		}
		System.out.print(Collections.max(list));
	}
}
