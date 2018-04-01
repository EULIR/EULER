public class Project019
{
	private static boolean judge(int a)
	{
		return (((a % 4) == 0) && ((a % 100) != 0)) || ((a % 400) == 0);
	}

	private static int cal(int a, int b)
	{
		int[] p = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] r = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (judge(a))
			return r[b - 1];
		else return p[b - 1];
	}

	public static void main(String[] args)
	{
		var arr = new int[2002][20];
		arr[1900][1] = 1;
		for (var i = 1900; i <= 2000; i++)
			for (var j = 1; j <= 12; j++)
			{
				var a = cal(i, j);
				if (j == 12)
					arr[i + 1][1] = (arr[i][j] + a) % 7;
				else arr[i][j + 1] = (arr[i][j] + a) % 7;
			}
		var ans = 0;
		for (var i = 1901; i <= 2000; i++)
			for (var j = 1; j <= 12; j++)
				//System.out.print(arr[i][j] + " ");
				if (arr[i][j] == 0)
					ans++;
		System.out.println(ans);
	}
}