import java.util.ArrayList;

public class Project090
{
	private static boolean isValid(String diceOne, String diceTwo)
	{
		ArrayList<String> combinations = new ArrayList<>();
		for (int i = 0; i < diceOne.length(); i++)
			for (int j = 0; j < diceTwo.length(); j++)
			{
				String sideOne = diceOne.substring(i, i + 1);
				String sideTwo = diceTwo.substring(j, j + 1);
				combinations.add(sideOne + sideTwo);
				combinations.add(sideTwo + sideOne);
				if (sideOne.equals("6") || sideOne.equals("9"))
				{
					combinations.add("9" + sideTwo);
					combinations.add(sideTwo + "9");
					combinations.add("6" + sideTwo);
					combinations.add(sideTwo + "6");
				}
				if (sideTwo.equals("6") || sideTwo.equals("9"))
				{
					combinations.add("9" + sideOne);
					combinations.add(sideOne + "9");
					combinations.add("6" + sideOne);
					combinations.add(sideOne + "6");
				}
			}
		String[] target = {"01","04","09","16","25","36","49","64","81"};
		boolean[] test = new boolean[9];
		for (String combination : combinations)
			for (int j = 0; j < target.length; j++)
				if (combination.equals(target[j]))
					test[j] = true;
		for (boolean aboo : test)
			if (!aboo)
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		int ans = 0;
		String[] combination = {"012345", "012346", "012347", "012348", "012349", "012356", "012357", "012358", "012359", "012367", "012368", "012369", "012378", "012379", "012389", "012456", "012457", "012458", "012459", "012467", "012468", "012469", "012478", "012479", "012489", "012567", "012568", "012569", "012578", "012579", "012589", "012678", "012679", "012689", "012789", "013456", "013457", "013458", "013459", "013467", "013468", "013469", "013478", "013479", "013489", "013567", "013568", "013569", "013578", "013579", "013589", "013678", "013679", "013689", "013789", "014567", "014568", "014569", "014578", "014579", "014589", "014678", "014679", "014689", "014789", "015678", "015679", "015689", "015789", "016789", "023456", "023457", "023458", "023459", "023467", "023468", "023469", "023478", "023479", "023489", "023567", "023568", "023569", "023578", "023579", "023589", "023678", "023679", "023689", "023789", "024567", "024568", "024569", "024578", "024579", "024589", "024678", "024679", "024689", "024789", "025678", "025679", "025689", "025789", "026789", "034567", "034568", "034569", "034578", "034579", "034589", "034678", "034679", "034689", "034789", "035678", "035679", "035689", "035789", "036789", "045678", "045679", "045689", "045789", "046789", "056789", "123456", "123457", "123458", "123459", "123467", "123468", "123469", "123478", "123479", "123489", "123567", "123568", "123569", "123578", "123579", "123589", "123678", "123679", "123689", "123789", "124567", "124568", "124569", "124578", "124579", "124589", "124678", "124679", "124689", "124789", "125678", "125679", "125689", "125789", "126789", "134567", "134568", "134569", "134578", "134579", "134589", "134678", "134679", "134689", "134789", "135678", "135679", "135689", "135789", "136789", "145678", "145679", "145689", "145789", "146789", "156789", "234567", "234568", "234569", "234578", "234579", "234589", "234678", "234679", "234689", "234789", "235678", "235679", "235689", "235789", "236789", "245678", "245679", "245689", "245789", "246789", "256789", "345678", "345679", "345689", "345789", "346789", "356789", "456789"};
		for (int i = 0; i < combination.length; i++)
			for (int j = i; j < combination.length; j++)
				if (isValid(combination[i], combination[j]))
					ans++;
		System.out.println(ans);
	}
}
