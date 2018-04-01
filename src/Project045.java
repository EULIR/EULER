import static java.lang.Integer.MAX_VALUE;

public class Project045
{
	public static void main(String[] args)
	{
		for (var i = 1; i < MAX_VALUE; i++)
			if (Library.isHexagonal(i))
				if (Library.isPentagonal(i))
					if (Library.isTriangle(i))
						System.out.println(i);
	}
}
