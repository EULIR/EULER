import java.util.HashMap;
import java.util.TreeSet;

public class Project062
{
	public static void main(String[] args)
	{
		TreeSet<Long> cubes;
		HashMap<Double, TreeSet<Long>> map = new HashMap<>();
		for (long i = 0; ; i++)
		{
			long cube = i * i * i;
			Long entry = cube;
			double digitCounter = 0.00D;
			for (; cube > 0; cube /= 10)
				digitCounter += Math.pow(10, cube % 10);
			Double counter = digitCounter;
			cubes = map.get(counter);
			if (cubes == null)
				cubes = new TreeSet<>();
			cubes.add(entry);
			if (cubes.size() == 5)
				break;
			map.put(counter, cubes);
		}
		System.out.println(cubes.first());
	}
}
