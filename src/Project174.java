import java.util.stream.IntStream;

public class Project174 {
	public static void main(String[] args) {
		final int TARGET = 1000000;
		int[] arr = new int[TARGET + 1];
		for (int i = 1; i <= TARGET / 2 + 1; i++)
			for (int j = i - 2; j > 0 && i * i - j * j <= TARGET; j -= 2)
				arr[i * i - j * j]++;
		int ans = (int) IntStream.rangeClosed(1, TARGET).filter(i -> arr[i] <= 10 && arr[i] != 0).count();
		System.out.println(ans);
	}
}
