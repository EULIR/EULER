import java.util.Scanner;

public class Project079
{
	private static int contains(int[] arr, int b)
	{
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == b)
				return i;
		return -1;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int k = -1;
		int[][] arr = new int[50][3];
		String a = s.nextLine();
		while (!a.equals("-999"))
		{
			k++;
			for (int i = 0; i < a.length(); i++)
				arr[k][i] = Integer.parseInt(a.substring(i, i + 1));
			a = s.nextLine();
		}
		int[] ans = new int[9];
		for (int i = 0; i < 10; i++)
		{
			boolean[] boo = new boolean[10];
			for (int[] t : arr)
			{
				int index = contains(t, i);
				if (index != -1)
					for (int j = 0; j < index; j++)
						boo[t[j]] = true;
			}
			int number = 0;
			for (boolean bo : boo)
				if (bo)
					number++;
			ans[number + 1] = i;
		}
		for (int i = 1; i < ans.length; i++)
			System.out.print(ans[i]);
	}
}
