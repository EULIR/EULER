import java.util.ArrayList;

public class Project037
{
	private static boolean judge(ArrayList<String> list)
	{
		for (var aList : list)
			if (!Library.isPrime(Integer.parseInt(aList)))
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		var list = new ArrayList<String>();
		var k = 0;
		var n = 9;
		var ans = 0;
		while (k < 11)
		{
			n++;
			if (!Library.isPrime(n))
				continue;
			var s = String.valueOf(n);
			for (var i = 0; i < s.length(); i++)
				list.add(s.substring(i));
			for (var i = 0; i < s.length() - 1; i++)
				list.add(s.substring(0, i + 1));
			//for (String alist : list)
			//{
			//System.out.print(alist + " ");
			//}
			if (judge(list))
			{
				k++;
				//System.out.print(n + " ");
				ans += n;
			}
			list = new ArrayList<String>();
		}
		System.out.print(ans);
	}
}
