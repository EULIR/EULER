public class Project243 {
	public static void main(String[] args) {
		long t = 1, denominator = 1, index = 2;
		while (true) {
			t *= index - 1;
			denominator *= index;
			index++;
			while (!Library.isPrime(index)) index++;
			if ((double) t / denominator < 0.1635881955585578)
				for (int i = 1; i <= index; i++)
					if ((double) i * t / (i * denominator - 1) < 0.1635881955585578) {
						System.out.println(i * denominator);
						System.exit(0);
					}
		}
	}
}
