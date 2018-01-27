import java.math.BigInteger;
import java.util.ArrayList;

public class Project068
{
	private static BigInteger maxNumber = BigInteger.ZERO;

	private static void createLegalString(int[][] arr)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < arr.length; i++)
			if (min > arr[i][0])
			{
				min = arr[i][0];
				minIndex = i;
			}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
		{
			int k = (i + minIndex) % 5;
			for (int j = 0; j < arr[k].length; j++)
				str.append(arr[k][j]);
		}
		if (str.toString().length() == 17)
			return;
		BigInteger newNumber = new BigInteger(str.toString());
		if (newNumber.compareTo(maxNumber) > 0)
			maxNumber = newNumber;
	}

	private static int numberSum(int[] arr)
	{
		int ans = 0;
		for (int anArr : arr)
			ans += anArr;
		return ans;
	}

	private static void isMagic(ArrayList<Integer> list)
	{
		int[][] modellist = {
				{list.get(0), list.get(1), list.get(2)},
				{list.get(3), list.get(2), list.get(4)},
				{list.get(6), list.get(4), list.get(5)},
				{list.get(7), list.get(5), list.get(8)},
				{list.get(9), list.get(8), list.get(1)}};
		if (numberSum(modellist[0]) == numberSum(modellist[1]))
			if (numberSum(modellist[1]) == numberSum(modellist[2]))
				if (numberSum(modellist[2]) == numberSum(modellist[3]))
					if (numberSum(modellist[3]) == numberSum(modellist[4]))
						createLegalString(modellist);

	}

	private static void createTenDigitString(ArrayList<Integer> list, boolean[] boo)
	{
		if (list.size() == 10)
			//System.out.print(list + " ");
			isMagic(list);
		for (int i = 1; i <= 10; i++)
			if (!boo[i])
			{
				boo[i] = true;
				list.add(i);
				createTenDigitString(list, boo);
				boo[i] = false;
				list.remove(list.size() - 1);
			}
	}

	public static void main(String[] args)
	{
		boolean[] boo = new boolean[11];
		ArrayList<Integer> digitList = new ArrayList<>();
		createTenDigitString(digitList, boo);
		System.out.println(maxNumber);
	}
}
