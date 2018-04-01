public class Project054
{
	private static int[] Card(String str)
	{
		var arr = new int[2];
		arr[0] = "23456789TJQKA".indexOf(str.substring(0, 1));
		arr[1] = "CSHD".indexOf(str.substring(1));
		return arr;
	}

	private static void doubleSort(int[][] a)
	{
		for (var i = 0; i < a.length; i++)
			for (var j = 0; j < a.length; j++)
				if ((a[i][0] < a[j][0]) || ((a[i][0] == a[j][0]) && (a[i][1] < a[j][1])))
				{
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
	}

	private static boolean judgeOnePair(int[][] a)
	{
		return (a[0][0] == a[1][0]) || (a[1][0] == a[2][0]) || (a[2][0] == a[3][0]) || (a[3][0] == a[4][0]);
	}

	private static boolean judgeTwoPairs(int[][] a)
	{
		var t = 0;
		if (a[0][0] == a[1][0])
			t++;
		if (a[1][0] == a[2][0])
			t++;
		if (a[2][0] == a[3][0])
			t++;
		if (a[3][0] == a[4][0])
			t++;
		return t == 2;
	}

	private static boolean judgeThreeOfAKind(int[][] a)
	{
		return ((a[0][0] == a[1][0]) && (a[0][0] == a[2][0])) || ((a[1][0] == a[2][0]) && (a[1][0] == a[3][0])) || ((a[2][0] == a[3][0]) && (a[2][0] == a[4][0]));
	}

	private static boolean judgeStraight(int[][] a)
	{
		return (a[0][0] + 1 == a[1][0]) && (a[1][0] + 1 == a[2][0]) && (a[2][0] + 1 == a[3][0]) && (a[3][0] + 1 == a[4][0]);
	}

	private static boolean judgeFlush(int[][] a)
	{
		return (a[0][1] == a[1][1]) && (a[0][1] == a[2][1]) && (a[0][1] == a[3][1]) && (a[0][1] == a[4][1]);
	}

	private static boolean judgeFullHouse(int[][] a)
	{
		return ((a[0][0] == a[1][0]) && (a[2][0] == a[3][0]) && (a[2][0] == a[4][0])) || ((a[3][0] == a[4][0]) && (a[0][0] == a[1][0]) && (a[0][0] == a[2][0]));
	}

	private static boolean judgeFourOfAKind(int[][] a)
	{
		if (a[1][0] == a[2][0])
			if (a[1][0] == a[3][0])
				return (a[1][0] == a[0][0]) || (a[1][0] == a[4][0]);
		return false;
	}

	private static boolean judgeStraightFlush(int[][] a)
	{
		var t = a[0][1];
		for (var anA : a)
			if (anA[1] != t)
				return false;
		t = a[0][0];
		for (var i = 0; i < a.length; i++)
			if (a[i][0] != i + t)
				return false;
		return true;
	}

	private static boolean judgeRoyalFlush(int[][] a)
	{
		var t = a[0][1];
		for (var anA : a)
			if (anA[1] != t)
				return false;
		for (var i = 0; i < a.length; i++)
			if (a[i][0] != i + 8)
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		var s = "8C TS KC 9H 4S 7D 2S 5D 3S AC";
		var playerOneRank = 0;
		var playerTwoRank = 0;
		int[][] playerOne = {Card(s.substring(0, 2)), Card(s.substring(3, 5)), Card(s.substring(6, 8)), Card(s.substring(9, 11)), Card(s.substring(12, 14))};
		int[][] playerTwo = {Card(s.substring(15, 17)), Card(s.substring(18, 20)), Card(s.substring(21, 23)), Card(s.substring(24, 26)), Card(s.substring(27, 29))};
		doubleSort(playerOne);
		doubleSort(playerTwo);
		if (judgeRoyalFlush(playerOne))
			playerOneRank = 10;
		else if (judgeStraightFlush(playerOne))
			playerOneRank = 9;
		else if (judgeFourOfAKind(playerOne))
			playerOneRank = 8;
		else if (judgeFullHouse(playerOne))
			playerOneRank = 7;
		else if (judgeFlush(playerOne))
			playerOneRank = 6;
		else if (judgeStraight(playerOne))
			playerOneRank = 5;
		else if (judgeThreeOfAKind(playerOne))
			playerOneRank = 4;
		else if (judgeTwoPairs(playerOne))
			playerOneRank = 3;
		else if (judgeOnePair(playerOne))
			playerOneRank = 2;
		else playerOneRank = 1;

	}
}
