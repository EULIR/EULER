import java.util.Scanner;

public class Project107
{
	public static void main(String[] args)
	{
		int[][] array = new int[40][40];
		Scanner s = new Scanner(System.in);
		int original = 0;
		int current = 0;
		for (int i = 0; i < 40; i++)
		{
			String str = s.nextLine();
			String[] arr = str.split(",");
			for (int j = 0; j < arr.length; j++)
				if (arr[j].equals("-"))
					array[i][j] = -1;
				else
				{
					array[i][j] = Integer.parseInt(arr[j]);
					original += array[i][j];
				}
		}
		boolean[] boo = new boolean[40];
		boo[0] = true;
		for (int i = 1; i < 40; i++)
		{
			int min = -1;
			int goal = -1;
			for (int j = 0; j < 40; j++)
				for (int k = 0; k < 40 && boo[j]; k++)
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
