import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Project054 {
	private static int[] card(String str) {
		var arr = new int[2];
		arr[0] = "  23456789TJQKA".indexOf(str.substring(0, 1));
		arr[1] = "CSHD".indexOf(str.substring(1));
		return arr;
	}

	private static void doubleSort(int[][] a) {
		for (var i = 0; i < a.length; i++)
			for (var j = 0; j < a.length; j++)
				if ((a[i][0] > a[j][0]) || ((a[i][0] == a[j][0]) && (a[i][1] > a[j][1]))) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
	}

	private static boolean judgeOnePair(int[][] a) {
		return (a[0][0] == a[1][0]) || (a[1][0] == a[2][0]) || (a[2][0] == a[3][0]) || (a[3][0] == a[4][0]);
	}

	private static boolean judgeTwoPairs(int[][] a) {
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

	private static boolean judgeThreeOfAKind(int[][] a) {
		return ((a[0][0] == a[1][0]) && (a[0][0] == a[2][0])) || ((a[1][0] == a[2][0]) && (a[1][0] == a[3][0])) || ((a[2][0] == a[3][0]) && (a[2][0] == a[4][0]));
	}

	private static boolean judgeStraight(int[][] a) {
		return (a[0][0] - 1 == a[1][0]) && (a[1][0] - 1 == a[2][0]) && (a[2][0] - 1 == a[3][0]) && (a[3][0] - 1 == a[4][0]);
	}

	private static boolean judgeFlush(int[][] a) {
		return (a[0][1] == a[1][1]) && (a[0][1] == a[2][1]) && (a[0][1] == a[3][1]) && (a[0][1] == a[4][1]);
	}

	private static boolean judgeFullHouse(int[][] a) {
		return ((a[0][0] == a[1][0]) && (a[2][0] == a[3][0]) && (a[2][0] == a[4][0])) || ((a[3][0] == a[4][0]) && (a[0][0] == a[1][0]) && (a[0][0] == a[2][0]));
	}

	private static boolean judgeFourOfAKind(int[][] a) {
		return a[1][0] == a[2][0] && a[1][0] == a[3][0] && ((a[1][0] == a[0][0]) || (a[1][0] == a[4][0]));
	}

	private static boolean judgeStraightFlush(int[][] a) {
		//verified 2018/12/18
		var t = a[0][1];
		for (var anA : a)
			if (anA[1] != t)
				return false;
		t = a[0][0];
		for (var i = 0; i < a.length; i++)
			if (a[i][0] != t - i)
				return false;
		return true;
	}

	private static boolean judgeRoyalFlush(int[][] a) {
		//verified 2018/12/18
		var t = a[0][1];
		for (var anA : a)
			if (anA[1] != t)
				return false;
		for (var i = 0; i < a.length; i++)
			if (a[i][0] != 14 - i)
				return false;
		return true;
	}

	private static int evaluate(int[][] a) {
		if (judgeRoyalFlush(a))
			return 10;
		if (judgeStraightFlush(a))
			return 9;
		if (judgeFourOfAKind(a))
			return 8;
		if (judgeFullHouse(a))
			return 7;
		if (judgeFlush(a))
			return 6;
		if (judgeStraight(a))
			return 5;
		if (judgeThreeOfAKind(a))
			return 4;
		if (judgeTwoPairs(a))
			return 3;
		if (judgeOnePair(a))
			return 2;
		return 1;
	}

	private static int proceed(String str) {
		int result = 0;
		int[][] playerOne = {card(str.substring(0, 2)), card(str.substring(3, 5)), card(str.substring(6, 8)), card(str.substring(9, 11)), card(str.substring(12, 14))};
		int[][] playerTwo = {card(str.substring(15, 17)), card(str.substring(18, 20)), card(str.substring(21, 23)), card(str.substring(24, 26)), card(str.substring(27, 29))};
		doubleSort(playerOne);
		doubleSort(playerTwo);
		String playerOnePower = Arrays.stream(playerOne).mapToInt(ints -> ints[0]).mapToObj(a -> "  23456789VWXYZ".substring(a, a + 1)).collect(Collectors.joining());
		String playerTwoPower = Arrays.stream(playerTwo).mapToInt(ints -> ints[0]).mapToObj(a -> "  23456789VWXYZ".substring(a, a + 1)).collect(Collectors.joining());
		var playerOneRank = evaluate(playerOne);
		var playerTwoRank = evaluate(playerTwo);
		if (playerOneRank > playerTwoRank)
			result = 1;
		else if (playerOneRank < playerTwoRank)
			result = 2;
		if (playerOneRank == playerTwoRank) {
			switch (playerOneRank) {
				case 9:
					result = playerOnePower.compareTo(playerTwoPower) > 0 ? 1 : 2;
					break;
				case 8:
					int num1 = playerOne[2][0];
					int num2 = playerTwo[2][0];
					result = getResult(playerOnePower, playerTwoPower, num1, num2);
					break;
				case 7:
					int three1 = playerOne[2][0];
					int three2 = playerTwo[2][0];
					int two1;
					int two2;
					if (playerOne[1][0] == three1)
						two1 = playerOne[4][0];
					else two1 = playerOne[1][0];
					if (playerTwo[1][0] == three2)
						two2 = playerTwo[4][0];
					else two2 = playerTwo[1][0];
					if (three1 > three2)
						result = 1;
					else if (three1 < three2)
						result = 2;
					else result = two1 > two2 ? 1 : 2;
					break;
				case 6:
					result = playerOnePower.compareTo(playerTwoPower) > 0 ? 1 : 2;
					break;
				case 5:
					result = playerOnePower.compareTo(playerTwoPower) > 0 ? 1 : 2;
					break;
				case 4:
					if (playerOne[2][0] > playerTwo[2][0])
						result = 1;
					else if (playerOne[2][0] < playerTwo[2][0])
						result = 2;
					else result = playerOnePower.compareTo(playerTwoPower) > 0 ? 1 : 2;
					break;
				case 3:
					int pair11 = playerOne[1][0];
					int pair12 = playerOne[3][0];
					int pair21 = playerTwo[1][0];
					int pair22 = playerTwo[3][0];
					if (pair11 > pair21)
						result = 1;
					else if (pair11 < pair21)
						result = 2;
					else result = getResult(playerOnePower, playerTwoPower, pair12, pair22);
					break;
				case 2:
					int same1 = 0;
					for (int i = 0; i < playerOne.length - 1; i++) {
						if (playerOne[i][0] == playerOne[i + 1][0]) {
							same1 = playerOne[i][0];
							break;
						}
					}
					int same2 = 0;
					for (int i = 0; i < playerTwo.length - 1; i++) {
						if (playerTwo[i][0] == playerTwo[i + 1][0]) {
							same2 = playerTwo[i][0];
							break;
						}
					}
					result = getResult(playerOnePower, playerTwoPower, same1, same2);
					break;
				case 1:
					result = playerOnePower.compareTo(playerTwoPower) > 0 ? 1 : 2;
					break;
			}
		}
		return result;
	}

	private static int getResult(String playerOnePower, String playerTwoPower, int num1, int num2) {
		int result;
		if (num1 > num2) result = 1;
		else if (num1 < num2) result = 2;
		else result = playerOnePower.compareTo(playerTwoPower) > 0 ? 1 : 2;
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int one = 0;
		for (int i = 0; i < 1000; i++) {
			String line = sc.nextLine();
			if (proceed(line) == 1)
				one++;
		}
		System.out.println(one);
	}
}
