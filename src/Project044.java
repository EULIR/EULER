import static java.lang.Integer.MAX_VALUE;

public class Project044
{
	public static void main(String[] args)
	{
		var min = MAX_VALUE;
		for (var i = 1; i < 3000; i++)
			for (var j = i + 1; j < 3000; j++)
			{
				var p1 = i * (3 * i - 1) / 2;
				var p2 = j * (3 * j - 1) / 2;
				if (Library.isPentagonal(p1 + p2))
					if (Library.isPentagonal(p2 - p1))
						if (p2 - p1 < min)
							min = p2 - p1;
			}
		System.out.println(min);
	}
}
