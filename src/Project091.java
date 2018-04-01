import java.util.Arrays;

public class Project091
{
	private static boolean isRightTriangle(int x1, int y1, int x2, int y2)
	{
		var distanceOne = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		var distanceTwo = Math.sqrt(x1 * x1 + y1 * y1);
		var distanceThree = Math.sqrt(x2 * x2 + y2 * y2);
		double[] distance = {distanceOne, distanceTwo, distanceThree};
		Arrays.sort(distance);
		return Math.abs(distance[0] * distance[0] + distance[1] * distance[1] - distance[2] * distance[2]) < 0.0001;
	}

	public static void main(String[] args)
	{
		var ans = 0;
		for (var x1 = 0; x1 <= 50; x1++)
			for (var x2 = 0; x2 <= 50; x2++)
				for (var y1 = 0; y1 <= 50; y1++)
					for (var y2 = 0; y2 <= 50; y2++)
						if (!(x1 == x2 && y1 == y2) && !(x1 == 0 && y1 == 0) && !(x2 == 0 && y2 == 0) && isRightTriangle(x1, y1, x2, y2))
							ans++;
		System.out.println(ans / 2);
	}
}
