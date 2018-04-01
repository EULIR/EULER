public class Project017
{
	public static void main(String[] args)
	{
		var s = new String[1001];
		String[] one = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", ""};
		String[] ten = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		for (var i = 1; i <= 19; i++)
			s[i] = one[i];
		for (var i = 20; i <= 99; i++)
		{
			var a = i / 10;
			var b = i % 10;
			s[i] = ten[a] + one[b];
		}
		for (var i = 100; i <= 999; i++)
		{
			if (i % 100 == 0)
				s[i] = one[i / 100] + "hundred";
			else
			{
				var a = i / 100;
				s[i] = one[a] + "hundredand";
				var k = i / 100;
				k = i - k * 100;
				var b = k / 10;
				var c = k % 10;
				if (b <= 1)
					s[i] = s[i] + one[k];
				else
					s[i] = s[i] + ten[b] + one[c];
			}
		}
		s[1000] = "onethousand";
		var ans = 0;
		for (var i = 1; i <= 1000; i++)
		{
			System.out.println(s[i]);
			ans += s[i].length();
		}
		System.out.println(ans);
	}
}