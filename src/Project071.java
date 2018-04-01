import java.util.TreeMap;

class Fraction
{
	private int a;
	private int b;

	public Fraction(int n, int r)
	{
		a = n;
		b = r;
	}

	public int getB()
	{
		return b;
	}

	public int getA()
	{
		return a;
	}
}

public class Project071
{
	public static void main(String[] args)
	{
		TreeMap<Double, Fraction> map = new TreeMap<>();
		for (var i = 2; i <= 1000000; i++)
		{
			var j = (int) Math.floor(((double) 3 / 7) * i);
			var d = (double) j / i;
			if (d > 0.428570 && d < 0.428572)
				if (Library.gcd(i, j) == 1)
				{
					var fra = new Fraction(j, i);
					map.put(d, fra);
				}
		}
		var it = map.keySet().iterator();
		var lastNumerator = 0;
		//int lastDenominator = 0;
		while (it.hasNext())
		{
			double a = it.next();
			var b = map.get(a);
			if (b.getA() == 3 && b.getB() == 7)
			{
				System.out.println(lastNumerator);
				System.exit(0);
			}
			lastNumerator = b.getA();
			//lastDenominator = b.getB();
			//System.out.println(a + " " + b);
		}
	}
}
