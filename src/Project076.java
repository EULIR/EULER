public class Project076
{
	public static void main(String[] args)
	{
		var a1 = new int[101];
		var a2 = new int[101];
		final var a = 100;
		for (var i = 0; i <= a; i++)
		{
			a1[i] = 1;
			a2[i] = 0;
		}
		for (var i = 2; i <= a; i++)
		{
			for (var j = 0; j <= a; j++)
				for (var k = 0; k + j <= a; k += i)
					a2[k + j] += a1[j];
			for (var j = 0; j <= a; j++)
			{
				a1[j] = a2[j];
				a2[j] = 0;
			}
		}
		System.out.println(a1[100] - 1);
	}
}
