import java.math.BigInteger;

public class Project043
{
	private static boolean[] boo = new boolean[10];
	private static int k = -1;
	private static String[] str = new String[3628801];

	private static void make(String s)
	{
		if (s.length() == 10)
		{
			k++;
			str[k] = s;
		} else
			for (var i = 0; i < boo.length; i++)
				if (boo[i])
				{
					boo[i] = false;
					make(s + i);
					boo[i] = true;
				}

	}

	public static void main(String[] args)
	{
		for (var i = 0; i < boo.length; i++)
			boo[i] = true;
		for (var i = 0; i < str.length; i++)
		{
			str[i] = "";
		}
		make("");
		var ans = new BigInteger("0");
		for (var s : str)
			if (!s.equals(""))
				if (Integer.parseInt(s.substring(1, 4)) % 2 == 0)
					if (Integer.parseInt(s.substring(2, 5)) % 3 == 0)
						if (Integer.parseInt(s.substring(3, 6)) % 5 == 0)
							if (Integer.parseInt(s.substring(4, 7)) % 7 == 0)
								if (Integer.parseInt(s.substring(5, 8)) % 11 == 0)
									if (Integer.parseInt(s.substring(6, 9)) % 13 == 0)
										if (Integer.parseInt(s.substring(7, 10)) % 17 == 0)
										{
											var big = new BigInteger(s);
											ans = ans.add(big);
											//System.out.println(s);
										}
		System.out.println(ans);
	}
}
