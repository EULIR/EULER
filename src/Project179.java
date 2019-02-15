import java.util.stream.IntStream;

public class Project179 {
	public static void main(String[] args) {
		final int TARGET = 10000000;
		int[] arr = new int[TARGET + 1];
		IntStream.rangeClosed(0, TARGET).forEach(i -> arr[i] = 1);
		IntStream.rangeClosed(2, TARGET).flatMap(i -> IntStream.iterate(i, j -> j <= TARGET, j -> j + i)).forEach(j -> arr[j] += 1);
		int num = (int) IntStream.range(1, TARGET).filter(i -> arr[i] == arr[i + 1]).count();
		System.out.println(num);

	}

//	public static int countDivisor(int a) {
//		int num = 1;
//		int index = 2;
//		while (a > 1) {
//			int singlePrime = 0;
//			while (!Library.isPrime(index)) index++;
//			while (a % index == 0) {
//				a /= index;
//				singlePrime++;
//			}
//			num *= singlePrime + 1;
//			index++;
//		}
//		return num;
//	}
}
