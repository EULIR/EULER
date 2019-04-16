import java.util.Arrays;

public class Project178 {
	public static void main(String[] args) {
		long[][][][] arr = new long[40][10][2][2];
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++)
				arr[i][j][0][0] = arr[i][j][0][1] = arr[i][j][1][0] = arr[i][j][1][1] = 0;
		arr[0][1][0][0] = arr[0][2][0][0] = arr[0][3][0][0] = arr[0][4][0][0] = arr[0][5][0][0] = arr[0][6][0][0] = arr[0][7][0][0] = arr[0][8][0][0] = arr[0][9][0][1] = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i][0][0][0] = 0;
			arr[i][0][0][1] = 0;
			arr[i][0][1][0] = arr[i - 1][1][0][0] + arr[i - 1][1][1][0];
			arr[i][0][1][1] = arr[i - 1][1][0][1] + arr[i - 1][1][1][1];
			arr[i][arr[i].length - 1][0][0] = 0;
			arr[i][arr[i].length - 1][0][1] = arr[i - 1][arr[i].length - 2][0][0] + arr[i - 1][arr[i].length - 2][0][1];
			arr[i][arr[i].length - 1][1][0] = 0;
			arr[i][arr[i].length - 1][1][1] = arr[i - 1][arr[i].length - 2][1][0] + arr[i - 1][arr[i].length - 2][1][1];
			for (int j = 1; j < arr[i].length - 1; j++) {
				arr[i][j][0][0] = arr[i - 1][j - 1][0][0] + arr[i - 1][j + 1][0][0];
				arr[i][j][0][1] = arr[i - 1][j - 1][0][1] + arr[i - 1][j + 1][0][1];
				arr[i][j][1][0] = arr[i - 1][j - 1][1][0] + arr[i - 1][j + 1][1][0];
				arr[i][j][1][1] = arr[i - 1][j - 1][1][1] + arr[i - 1][j + 1][1][1];
			}
		}
		long ans = Arrays.stream(arr).mapToLong(anArr -> Arrays.stream(anArr).mapToLong(longs -> longs[1][1]).sum()).sum();
		System.out.print(ans);
	}
}
