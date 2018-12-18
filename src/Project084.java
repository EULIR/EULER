import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Project084 {
	public HashMap<Integer, Double> runStates(int diceSides) {
		final double ROLL = 1.0 / Math.pow(diceSides, 2);
		final int NUM = 50;
		HashMap<Integer, Double> prev = new HashMap<>();
		HashMap<Integer, Double> init = new HashMap<>();
		HashMap<Integer, Double> curr = new HashMap<>();
		for (int i = 0; i < 40; i++) {
			curr.put(i, 0.0);
			prev.put(i, 0.0);
			init.put(i, 0.0);
		}
		curr.put(0, 1.0);
		while (!underThreshold(prev, curr, .000001)) {
			prev.putAll(curr);
			curr.putAll(init);
			for (int sq = 0; sq < 40; sq++) {
				if (prev.get(sq) == 0) continue;
				for (int d1 = 1; d1 < diceSides + 1; d1++) {
					for (int d2 = 1; d2 < diceSides + 1; d2++) {
						double noJail = 1;
						if (d1 == d2) {
							noJail = 1 - twoDoublesOdds(diceSides, NUM);
							curr.put(10, curr.get(10)
									+ prev.get(sq) * (1 - noJail) * ROLL);
						}
						double probToHere = prev.get(sq) * noJail * ROLL;
						int nextSquare = (sq + d1 + d2) % 40;
						if (nextSquare == 30) {
							curr.put(10, curr.get(10) + probToHere);
						} else if (nextSquare == 2 || nextSquare == 17
								|| nextSquare == 33) {
							int[] cc = new int[16];
							cc[0] = 0;
							cc[1] = 10;
							for (int j = 2; j < 16; j++)
								cc[j] = nextSquare;
							for (int i = 0; i < 16; i++) {
								curr.put(cc[i],
										curr.get(cc[i]) + probToHere / 16);
							}
						} else if (nextSquare == 7 || nextSquare == 22
								|| nextSquare == 36) {
							chanceCards(nextSquare,
									curr, probToHere);
						} else {
							curr.put(nextSquare, curr.get(nextSquare) + probToHere);
						}
					}
				}
			}
		}
		return curr;
	}

	public double twoDoublesOdds(int diceSides, int loops) {
		double[] numDoubles = new double[]{1, 0, 0, 0};
		int noDouble = diceSides * diceSides - diceSides;
		for (int i = 0; i < loops; i++) {
			double nD0 = numDoubles[0] * noDouble + numDoubles[1] * noDouble + numDoubles[2] * noDouble + numDoubles[3] * noDouble;
			double nD1 = numDoubles[0] * diceSides + numDoubles[3] * diceSides;
			double nD2 = numDoubles[1] * diceSides;
			double nD3 = numDoubles[2] * diceSides;
			numDoubles = new double[]{nD0, nD1, nD2, nD3};
		}
		double sum = numDoubles[0] + numDoubles[1] + numDoubles[2] + numDoubles[3];
		return numDoubles[2] / sum;

	}

	public boolean underThreshold(HashMap<Integer, Double> prev, HashMap<Integer, Double> curr, double thresh) {
		for (int i = 0; i < 40; i++) if (Math.abs(prev.get(i) - curr.get(i)) > thresh) return false;
		return true;
	}

	public void chanceCards(int pos, HashMap<Integer, Double> curr, double probToHere) {
		int nextR = 0;
		int nextU = 0;
		int backSquare = 0;
		switch (pos) {
			case 7:
				nextR = 15;
				nextU = 12;
				backSquare = 4;
				break;
			case 22:
				nextR = 25;
				nextU = 28;
				backSquare = 19;
				break;
			case 36:
				nextR = 5;
				nextU = 12;
				backSquare = 33;
				break;
		}
		int[] chance = {0, 10, 11, 24, 39, 5, nextR, nextR,
				nextU, backSquare, pos, pos, pos, pos, pos, pos};
		for (int i = 0; i < 16; i++) {
			if (chance[i] == 33) {
				int[] cc = new int[16];
				cc[0] = 0;
				cc[1] = 10;
				for (int j = 2; j < 16; j++) cc[j] = backSquare;
				for (int k = 0; k < 16; k++) {
					curr.put(cc[k], curr.get(cc[k]) + probToHere / 16 / 16);
				}
			} else {
				curr.put(chance[i], curr.get(chance[i]) + probToHere / 16);
			}
		}
	}

	public static void main(String[] args) {
		new Project084().runStates(4).entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.limit(3)
				.forEach(System.out::println);
	}
}