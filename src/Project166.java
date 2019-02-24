public class Project166 {
	public static void main(String[] args) {
		//xxxx
		//xxx_
		//____
		//x__x
		int num = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					for (int l = 0; l < 10; l++) {
						for (int m = 0; m < 10; m++) {
							for (int n = 0; n < 10; n++) {
								for (int o = 0; o < 10; o++) {
									for (int p = 0; p < 10; p++) {
										for (int q = 0; q < 10; q++) {
											int sum = i + j + k + l;
											if (isLegal(sum - m - n - o) && isLegal(sum - i - m - p) && isLegal(sum - l - o - p) && isLegal(sum - i - n - q)
													&& isLegal(sum - (sum - i - m - p) - (sum - l - o - p) - (sum - i - n - q)) && isLegal(sum - j - n - (sum - l - o - p)) && isLegal(sum - k - o - (sum - i - n - q)))
												num++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(num);
	}

	private static boolean isLegal(int i) {
		return i <= 9 && i >= 0;
	}
}
