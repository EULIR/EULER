public class Project152 {
	static int[] numList = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 18, 20, 21, 24, 28, 30, 35, 36, 39, 40, 42, 45, 52, 56, 60, 63, 70, 72};
	static int validCombination;

	public static void main(String[] args) {
		validCombination = 0;
		selectAll(0, 0.0D);
		System.out.println(validCombination);
	}

	public static void selectAll(int index, double value) {
		if (Math.abs(value - 0.5) < 0.000000000001) {
			validCombination++;
			return;
		}
		if (index >= numList.length)
			return;
		selectAll(index + 1, value);
		value += (double) 1 / (numList[index] * numList[index]);
		selectAll(index + 1, value);
	}
}
