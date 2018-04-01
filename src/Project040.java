public class Project040
{
	public static void main(String[] args)
	{
		var s = new StringBuilder(" ");
		var n = 0;
		while (s.length() <= 1000000)
		{
			n++;
			s.append(n);
		}
		long t = Integer.parseInt(String.valueOf(s.charAt(1))) * Integer.parseInt(String.valueOf(s.charAt(10))) * Integer.parseInt(String.valueOf(s.charAt(100))) * Integer.parseInt(String.valueOf(s.charAt(1000))) * Integer.parseInt(String.valueOf(s.charAt(10000))) * Integer.parseInt(String.valueOf(s.charAt(100000))) * Integer.parseInt(String.valueOf(s.charAt(1000000)));
		System.out.println(t);
	}
}
