import java.util.Scanner;

public class Project099
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 1000; i++) {
			String str = s.nextLine();
			int base = Integer.parseInt(str.substring(0,str.indexOf(",")));
			int exp = Integer.parseInt(str.substring(str.indexOf(",") + 1));
			System.out.println(base);
			System.out.println(exp);
		}
	}
}
