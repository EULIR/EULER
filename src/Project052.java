import java.util.Arrays;
import java.util.stream.IntStream;

public class Project052
{
	private static boolean haveSameDigit(String s1, String s2, String s3, String s4, String s5, String s6)
	{
		int[] digitOfString1 = new int[10];
		int[] digitOfString2 = new int[10];
		int[] digitOfString3 = new int[10];
		int[] digitOfString4 = new int[10];
		int[] digitOfString5 = new int[10];
		int[] digitOfString6 = new int[10];
		IntStream.range(0, s1.length()).forEach(i -> digitOfString1[Integer.parseInt(s1.substring(i, i + 1))]++);
		IntStream.range(0, s2.length()).forEach(i -> digitOfString2[Integer.parseInt(s2.substring(i, i + 1))]++);
		IntStream.range(0, s3.length()).forEach(i -> digitOfString3[Integer.parseInt(s3.substring(i, i + 1))]++);
		IntStream.range(0, s4.length()).forEach(i -> digitOfString4[Integer.parseInt(s4.substring(i, i + 1))]++);
		IntStream.range(0, s5.length()).forEach(i -> digitOfString5[Integer.parseInt(s5.substring(i, i + 1))]++);
		IntStream.range(0, s6.length()).forEach(i -> digitOfString6[Integer.parseInt(s6.substring(i, i + 1))]++);
		return Arrays.equals(digitOfString1, digitOfString2) && Arrays.equals(digitOfString1, digitOfString3) && Arrays.equals(digitOfString1, digitOfString4) && Arrays.equals(digitOfString1, digitOfString5) && Arrays.equals(digitOfString1, digitOfString6);
	}

	public static void main(String[] args)
	{
		int n = 0;
		while (true)
		{
			n++;
			String s1 = String.valueOf(n);
			String s2 = String.valueOf(n * 2);
			String s3 = String.valueOf(n * 3);
			String s4 = String.valueOf(n * 4);
			String s5 = String.valueOf(n * 5);
			String s6 = String.valueOf(n * 6);
			if (haveSameDigit(s1, s2, s3, s4, s5, s6))
			{
				System.out.println(n);
				break;
			}
		}
	}
}
