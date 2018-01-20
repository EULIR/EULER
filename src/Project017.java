public class Project017
{
	public static void main(String[] args)
	{
		String[] s = new String[1001];
		String[] one = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", ""};
		String[] ten = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		for (int i = 1; i <= 19; i++)
			s[i] = one[i];
		for (int i = 20; i <= 99; i++)
		{
			int a = i / 10;
			int b = i % 10;
			s[i] = ten[a] + one[b];
		}
		for (int i = 100; i <= 999; i++)
		{
			if (i % 100 == 0)
				s[i] = one[i / 100] + "hundred";
			else
			{
				int a = i / 100;
				s[i] = one[a] + "hundredand";
				int k = i / 100;
				k = i - k * 100;
				int b = k / 10;
				int c = k % 10;
				if (b <= 1)
					s[i] = s[i] + one[k];
				else
					s[i] = s[i] + ten[b] + one[c];
			}
		}
		s[1000] = "onethousand";
		int ans = 0;
		for (int i = 1; i <= 1000; i++)
		{
			System.out.println(s[i]);
			ans += s[i].length();
		}
		System.out.println(ans);
	}
}