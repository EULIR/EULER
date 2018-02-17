import java.util.Arrays;

public class Project091
{
	private static boolean isRightTriangle(int x1, int y1, int x2, int y2)
	{
		double distanceOne = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		double distanceTwo = Math.sqrt(x1 * x1 + y1 * y1);
		double distanceThree = Math.sqrt(x2 * x2 + y2 * y2);
		double[] distance = {distanceOne, distanceTwo, distanceThree};
		Arrays.sort(distance);
		return Math.abs(distance[0] * distance[0] + distance[1] * distance[1] - distance[2] * distance[2]) < 0.0001;
	}

	public static void main(String[] args)
	{
		int ans = 0;
		for (int x1 = 0; x1 <= 50; x1++)
			for (int x2 = 0; x2 <= 50; x2++)
				for (int y1 = 0; y1 <= 50; y1++)
					for (int y2 = 0; y2 <= 50; y2++)
						if (!(x1 == x2 && y1 == y2) && !(x1 == 0 && y1 == 0) && !(x2 == 0 && y2 == 0) && isRightTriangle(x1, y1, x2, y2))
							ans++;
		System.out.println(ans / 2);
	}
}
