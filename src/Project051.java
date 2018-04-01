import java.util.TreeSet;

public class Project051
{
	private static TreeSet<String> sixDigitCombination(int a, int b, int c, String pattern)
	{
		TreeSet<String> T = new TreeSet<>();
		for (var i = 0; i < 10; i++)
		{
			var str = pattern.replaceFirst("b", a + "");
			str = str.replaceFirst("b", b + "");
			str = str.replaceFirst("b", c + "");
			str = str.replace("a", i + "");
			T.add(str);
		}
		return T;
	}

	private static boolean isPrimeSet(TreeSet<String> tree)
	{
		var it = tree.iterator();
		var flag = 0;
		while (it.hasNext())
			if (Library.isPrime(Integer.parseInt(it.next())))
				flag++;
		return flag == 8;
	}

	private static TreeSet<Integer> getPrimeSet(TreeSet<String> tree)
	{
		var it = tree.iterator();
		TreeSet<Integer> tr = new TreeSet<>();
		while (it.hasNext())
		{
			var a = Integer.parseInt(it.next());
			if (Library.isPrime(a))
				tr.add(a);
		}
		return tr;
	}

	public static void main(String[] args)
	{
		String[] sixDigit = {"bbaaab", "babaab", "baabab", "baaabb", "abbaab", "ababab", "abaabb", "aabbab", "aababb", "aaabbb"};
		TreeSet<String> sixDigitTree;
		for (var i = 0; i < 10; i++)
			for (var j = 0; j < 10; j++)
				for (var k = 0; k < 10; k++)
					for (var aSixDigit : sixDigit)
					{
						sixDigitTree = sixDigitCombination(i, j, k, aSixDigit);
						if (isPrimeSet(sixDigitTree))
							System.out.println(getPrimeSet(sixDigitTree));
					}
	}
}
