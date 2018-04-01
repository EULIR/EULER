import java.util.Scanner;

public class Project107
{
	public static void main(String[] args)
	{
		var array = new int[40][40];
		var s = new Scanner(System.in);
		var original = 0;
		var current = 0;
		for (var i = 0; i < 40; i++)
		{
			var str = s.nextLine();
			var arr = str.split(",");
			for (var j = 0; j < arr.length; j++)
				if (arr[j].equals("-"))
					array[i][j] = -1;
				else
				{
					array[i][j] = Integer.parseInt(arr[j]);
					original += array[i][j];
				}
		}
		var boo = new boolean[40];
		boo[0] = true;
		for (var i = 1; i < 40; i++)
		{
			var min = -1;
			var goal = -1;
			for (var j = 0; j < 40; j++)
				for (var k = 0; k < 40 && boo[j]; k++)
					if (!boo[k] && array[j][k] != -1 && (min == -1 || array[j][k] < min))
					{
						min = array[j][k];
						goal = k;
					}
			boo[goal] = true;
			current += min;
		}
		System.out.println(original / 2 - current);
	}
}
