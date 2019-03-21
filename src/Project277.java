public class Project277 {
	public static void main(String[] args) {
		String str = "UDDDUdddDDUDDddDdDddDDUDDdUUDd";
		loop:
		for (long i = 0; ; i++) {
			long n = i;
			for (int j = str.length() - 1; j >= 0; j--) {
				switch (str.charAt(j)) {
					case 'D':
						n *= 3;
						break;
					case 'd':
						n = 3 * n + 1;
						if (n % 2 == 0)
							n /= 2;
						else continue loop;
						break;
					case 'U':
						n = 3 * n - 2;
						if (n % 4 == 0)
							n /= 4;
						else continue loop;
				}
				if (n > 1000000000000000L) {
					System.out.println(n);
					System.exit(0);
				}
			}

		}
	}
}
