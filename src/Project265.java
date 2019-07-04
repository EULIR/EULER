import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Project265 {
	private static SortedSet<String> sequence = new TreeSet<>();

	public static void main(String args[]) {
		HashMap<String, Boolean> d = new HashMap<>();
		String init = "000001";
		for (int i = 0; i < 32; i++) {
			String binrep = Integer.toBinaryString(i);
			String pad = IntStream.range(0, (5 - binrep.length())).mapToObj(j -> "0").collect(Collectors.joining());
			binrep = pad + binrep;
			d.put(binrep, Boolean.FALSE);
		}
		d.put("00000", Boolean.TRUE);
		d.put("00001", Boolean.TRUE);
		check(init, d);
		Iterator i = sequence.iterator();
		long result = 0;
		while (i.hasNext()) {
			String s = (String) i.next();
			int bin = Integer.parseInt(s, 2);
			result += bin;
		}
		System.out.println(result);
	}

	static void check(String seq, HashMap<String, Boolean> d) {
		String n = seq.substring(seq.length() - 4);
		if (seq.length() == 32) {
			if (!d.get(seq.substring(seq.length() - 4) + "0")) {
				d.put(seq.substring(seq.length() - 4) + "0", Boolean.TRUE);
				if (!d.get(seq.substring(seq.length() - 3) + "00")) {
					d.put(seq.substring(seq.length() - 3) + "00", Boolean.TRUE);
					if (!d.get(seq.substring(seq.length() - 2) + "000")) {
						d.put(seq.substring(seq.length() - 2) + "000", Boolean.TRUE);
						if (!d.get(seq.substring(seq.length() - 1) + "0000"))
							sequence.add(seq);
					}
				}
			}
			return;
		}
		if (!d.get(n + "0")) {
			HashMap<String, Boolean> dd = new HashMap<>(d);
			dd.put(n + "0", Boolean.TRUE);
			check(seq + "0", dd);
		}
		if (!d.get(n + "1")) {
			HashMap<String, Boolean> dd = new HashMap<>(d);
			dd.put(n + "1", Boolean.TRUE);
			check(seq + "1", dd);
		}
	}
}
