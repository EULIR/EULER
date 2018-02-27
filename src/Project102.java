import java.util.Scanner;

public class Project102
{
	private static boolean originIsInTriangle(String[] str)
	{
		int[] arr = new int[str.length];
		for (int i = 0; i < str.length; i++)
			arr[i] = Integer.parseInt(str[i]);
		int a = Integer.signum((-arr[1]) * (arr[0] - arr[2]) - (-arr[0] * (arr[1] - arr[3])));
		int b = Integer.signum((-arr[3]) * (arr[2] - arr[4]) - (-arr[2] * (arr[3] - arr[5])));
		int c = Integer.signum((-arr[5]) * (arr[4] - arr[0]) - (-arr[4] * (arr[5] - arr[1])));
		return a == 0 || b == 0 || c == 0 || (a == b && a == c);
	}

	public static void main(String[] args)
	{
		int ans = 0;
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 1000; i++)
		{
			String str = s.nextLine();
			String[] arr = str.split(",");
			if (originIsInTriangle(arr))
				ans++;
		}
		System.out.println(ans);
	}
}
