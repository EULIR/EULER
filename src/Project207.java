public class Project207 {
	public static void main(String[] args) {
		long index = 1;
		long ans = 2;
		while (ans <= 12345 * index)
			if ((ans & ++ans) == 0)
				index++;
		System.out.println(ans * (ans + 1));
	}
}