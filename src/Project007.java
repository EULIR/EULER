public class Project007
{
	public static void main(String[] args)
	{
		var s = new boolean[200000];
		var a = new int[20000];
		var k = 0;
		for (var i = 2; i <= 150000; i++)
			s[i] = true;
		for (var i = 2; i <= 150000; i++)
			if (s[i])
			{
				k++;
				a[k] = i;
				for (var j = 2; j <= (150000 / i); j++)
					s[j * i] = false;
			}
		System.out.println(a[10001]);
	}
}