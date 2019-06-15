import java.util.ArrayList;
import java.util.List;

public class Project244 {
	public static void main(String[] args) {
		long ans = 0;
		List<State> list1 = new ArrayList<>();
		list1.add(State.START);
		List<State> list2 = new ArrayList<>();
		List<State> current = list1;
		List<State> next = list2;
		boolean found = false;
		while (true) {
			next.clear();
			for (State s : current) {
				if (s.isEndState()) {
					found = true;
					ans += s.sum;
					continue;
				}
				if (!found) {
					s.mark();
					for (Direction dir : Direction.values()) {
						State ns = s.next(dir);
						if (ns != null) next.add(ns);
					}
				}
			}
			if (found)
				break;
			List<State> temp = current;
			current = next;
			next = temp;
		}
		System.out.println(ans);
	}

	enum Direction {
		L(76), R(82), U(85), D(68);
		long value;

		Direction(long v) {
			value = v;
		}

		long getValue() {
			return value;
		}
	}

	static final int SIDE = 4;
	static final int POS_BITS = 4;
	static final int SIZE = SIDE * SIDE;
	static final boolean[] MARKED = new boolean[(int) Math.pow(2, POS_BITS + SIZE)];
	static final long R = 100000007L;
	static final long M = 243;

	static class State {

		static final int BOARD_END = 0x5A5A;
		static final int BOARD_START = 0xCCCC;

		static final State START = new State(BOARD_START, 0);

		int board;
		long sum;

		State(int b, long c) {
			board = b;
			sum = c;
		}

		boolean isEndState() {
			return board == BOARD_END;
		}

		int blankPos() {
			return board >> SIZE;
		}

		int setup() {
			return board & ((1 << SIZE) - 1);
		}

		boolean isRed(int pos) {
			return (board & (1 << pos)) == 0;
		}

		int nextBlankPos(Direction dir) {
			int bp = blankPos();
			switch (dir) {
				case L:
					return (bp % SIDE != SIDE - 1) ? (bp + 1) : -1;
				case R:
					return (bp % SIDE != 0) ? (bp - 1) : -1;
				case U:
					return (bp / SIDE != SIDE - 1) ? (bp + SIDE) : -1;
				case D:
					return (bp / SIDE != 0) ? (bp - SIDE) : -1;
				default:
					return -1;
			}
		}

		State next(Direction dir) {
			int newBP = nextBlankPos(dir);
			if (newBP == -1)
				return null;
			int newBoard = newBP << SIZE | setup() & ~(1 << newBP) | (isRed(newBP) ? 0 : 1 << blankPos());
			if (MARKED[newBoard])
				return null;
			long newChecksum = (sum * M + dir.getValue()) % R;
			return new State(newBoard, newChecksum);
		}

		void mark() {
			MARKED[board] = true;
		}
	}
}
