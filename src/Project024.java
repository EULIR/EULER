import java.util.Arrays;

public class Project024
{
	private static String[] s = new String[3628801];
	private static boolean[] boo = new boolean[10];
	private static int k = -1;

	private static void calculate(String s1)
	{
		for (var i = 0; i <= 9; i++)
			if (boo[i])
			{
				boo[i] = false;
				var s2 = s1 + Integer.toString(i);
				if (s1.length() == 9)
				{
					k++;
					s[k] = s2;
				} else calculate(s2);
				boo[i] = true;
			}
	}

	public static void main(String[] args)
	{
		for (var i = 0; i < s.length; i++)
			s[i] = "9999999999";
		for (var i = 0; i < boo.length; i++)
			boo[i] = true;
		calculate("");
		Arrays.sort(s);

		System.out.println(s[1000000 - 1]);
	}
}