public class Project145 {
	public static boolean isReversible(long num) {
		String s = String.valueOf(num);
		for (int i = 0; i < s.length(); i++) {
			int a = s.charAt(i) - '0';
			if (a % 2 == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		long num = 0;
		for (long i = 1; i < 1000000000L; i++) {
			//System.out.println(i);
			long b = Long.parseLong(Library.reverse(String.valueOf(i)));
			//this algorithm is totally stupid! I found myself stupid immediately after I wrote this code
			//But I kept it to remind myself every time I see it
			//if (i % 10 == 0)
			if (String.valueOf(b).length() != String.valueOf(i).length())
				continue;
			if (isReversible(i + b))
				num++;
		}
		System.out.println(num);
	}
}
