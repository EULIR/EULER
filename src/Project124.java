import java.util.ArrayList;

public class Project124 {
	public static boolean isPower(int power, int base) {
		boolean result;
		if (power <= 0 || !(power % base == 0))
			return false;
		if (power / base > 1)
			result = isPower(power / base, base);
		else result = power % base == 0;
		return result;
	}

	public static boolean isLegal(ArrayList<Integer> prev, int a) {
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> prev = new ArrayList<>();
		int i = 1;
		int num = 1;
		while (num < 10000) {

			if (isLegal(prev, i)) {

			}
		}
		System.out.println(num);
		System.out.println(i);
	}
}
