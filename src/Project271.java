public class Project271 {
	public static int[][] solutions = {
			{7, 1, 2, 4},
			{13, 1, 3, 9},
			{19, 1, 7, 11},
			{31, 1, 5, 25},
			{37, 1, 10, 26},
			{43, 1, 6, 36}};

	static long modularInverse(long a, long b) {
		long x = 0;
		long y = 1;
		long last_x = 1;
		long last_y = 0;
		long quotient;
		long temp;
		long init_b = b;
		while (b > 0) {
			quotient = a / b;
			temp = b;
			b = a % b;
			a = temp;
			temp = x;
			x = last_x - quotient * x;
			last_x = temp;
			temp = y;
			y = last_y - quotient * y;
			last_y = temp;
		}
		return (last_x + init_b) % init_b;
	}

	public static long addSolution(long a, long b, long multiplier, long modulus) {
		long aa, temp;
		aa = a % modulus;
		if (aa >= b) b += modulus;
		temp = (b - aa) % modulus;
		temp *= modularInverse(multiplier, modulus);
		temp %= modulus;
		a += multiplier * temp;
		return a;
	}

	public static void main(String[] args) {
		long ans = 0;
		int index;
		for (int i = 1; i < 729; i++) {
			long a = 1;
			long multiplier = 153416670;
			index = i;
			for (int j = 0; j < 6; j++) {
				a = addSolution(a, solutions[j][1 + index % 3], multiplier, solutions[j][0]);
				multiplier *= solutions[j][0];
				index = index / 3;
			}
			ans += a;
		}
		System.out.println(ans);
	}
}
