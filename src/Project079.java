import java.util.Scanner;

public class Project079
{
	private static int contains(int[] arr, int b)
	{
		for (var i = 0; i < arr.length; i++)
			if (arr[i] == b)
				return i;
		return -1;
	}

	public static void main(String[] args)
	{
		var s = new Scanner(System.in);
		var k = -1;
		var arr = new int[50][3];
		var a = s.nextLine();
		while (!a.equals("-999"))
		{
			k++;
			for (var i = 0; i < a.length(); i++)
				arr[k][i] = Integer.parseInt(a.substring(i, i + 1));
			a = s.nextLine();
		}
		var ans = new int[9];
		for (var i = 0; i < 10; i++)
		{
			var boo = new boolean[10];
			for (var t : arr)
			{
				var index = contains(t, i);
				if (index != -1)
					for (var j = 0; j < index; j++)
						boo[t[j]] = true;
			}
			var number = 0;
			for (var bo : boo)
				if (bo)
					number++;
			ans[number + 1] = i;
		}
		for (var i = 1; i < ans.length; i++)
			System.out.print(ans[i]);
	}
}
