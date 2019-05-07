import java.util.ArrayDeque;

public class Project198 {
	public static void main(String[] args) {
		final long SIZE = 100000000;
		final long leftBound = 1;
		final long rightBound = 100;
		ArrayDeque<Long> list = new ArrayDeque<>();
		long left1 = 0;
		long left2 = 1;
		long right1 = 1;
		long right2 = 1;
		long ans = 0;
		while (true) {
			long times = 2 * left2 * right2;
			if (times <= SIZE) {
				long sum = left2 * right1 + left1 * right2;
				if (sum * rightBound < leftBound * times) ans++;
				long mid1 = left1 + right1;
				long mid2 = left2 + right2;
				if ((mid1 * rightBound <= leftBound * mid2)) {
					list.push(left2);
					list.push(left1);
					left1 = mid1;
					left2 = mid2;
				} else {
					right2 = mid2;
					right1 = mid1;
				}
			} else {
				if (list.isEmpty()) break;
				right1 = left1;
				right2 = left2;
				left1 = list.pop();
				left2 = list.pop();
			}
		}
		System.out.println(ans);
	}
}