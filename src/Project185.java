public class Project185 {
	private static int[] match = {0, 1, 3, 3, 3, 1, 2, 3, 1, 2, 3, 1, 1, 2, 2, 2, 2, 3, 1, 3, 3, 2};
	private static String[] guess = {
			"2321386104303845",
			"3847439647293047",
			"5855462940810587",
			"9742855507068353",
			"4296849643607543",
			"3174248439465858",
			"4513559094146117",
			"7890971548908067",
			"8157356344118483",
			"2615250744386899",
			"8690095851526254",
			"6375711915077050",
			"6913859173121360",
			"6442889055042768",
			"5616185650518293",
			"2326509471271448",
			"5251583379644322",
			"1748270476758276",
			"4895722652190306",
			"3041631117224635",
			"1841236454324589",
			"2659862637316867"
	};


	public static void main(String[] args) {
		findSequence("");
	}

	private static void findSequence(String guess) {
		if (guess.length() > 16)
			return;
		if (!isLegal(guess))
			return;
		if (guess.length() < 7)
			System.out.println(guess);
		if (guess.length() == 16) {
			System.out.println(guess);
			System.exit(0);
		}
		switch (guess.length()) {
			case 1:
				findSequence(guess + '6');
				break;
			case 2:
				findSequence(guess + '4');
				break;
			default:
				for (char i = '0'; i <= '9'; i++)
					findSequence(guess + i);
				break;
		}
	}

	private static boolean isLegal(String guess) {
		for (int i = 0; i < Project185.guess.length; i++) {
			int num = 0;
			for (int j = 0; j < guess.length(); j++)
				if (Project185.guess[i].charAt(j) == guess.charAt(j))
					num++;
			if (num > match[i])
				return false;
			if (16 - guess.length() < match[i] - num)
				return false;
		}
		return true;
	}
}
