import java.util.stream.IntStream;

public class Project204 {
	public static void main(String[] args) {
		int[] primeList = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		int[] arr = new int[100];
		int num = 0;
		for (int i = 1; i < 1000000000; i += 100) {
			for (int j = 0; j < 100; j++)
				arr[j] = i + j;
			for (int j = 0; j < 25; j++) {
				int prime = primeList[j];
				int n = (prime - (i % prime)) == prime ? 0 : prime - (i % prime);
				for (int k = n; k < 100; k += prime) {
					do arr[k] /= prime;
					while (arr[k] % prime == 0);
				}
			}
			num += IntStream.range(0, 100).filter(j -> arr[j] == 1).count();
		}
		System.out.println(num);
	}
}
