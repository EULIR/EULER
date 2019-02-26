public class Project191 {
	private static int[] arr;

	public static void main(String[] args) {
		arr = new int[480];
		System.out.println(valid(30, 0, 0));
	}

	public static int valid(int timePeriod, int absence, int late) {
		if (absence == 3 || late > 1)
			return 0;
		if (timePeriod == 0)
			return 1;
		int n = 6 * timePeriod + 2 * absence + late;
		if (arr[n] != 0)
			return arr[n];
		arr[n] = valid(timePeriod - 1, 0, late) +
				valid(timePeriod - 1, absence + 1, late) +
				valid(timePeriod - 1, 0, late + 1);
		return arr[n];
	}
}
