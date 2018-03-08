import java.math.BigInteger;
import java.util.Arrays;

public class Project104
{
	private static boolean judge(String str)
	{
		char[] c = str.toCharArray();
		char[] arr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		Arrays.sort(c);
		return Arrays.equals(arr, c);
	}

	public static void main(String[] args)
	{
		BigInteger a = BigInteger.ONE;
		BigInteger b = new BigInteger("2");
		int i = 3;
		while (true)
		{
			a = b;
			b = a.add(b).mod(new BigInteger("1000000000"));
			i++;
			if (judge(b.toString()))
			{

			}
		}
	}
}

/*
import math
f1 = 1
f2 = 2

i = 3
while(True):
    f2,f1 = (f2+f1)%1000000000,(f2)
    #print "%d  %d" %(f2,f1)
    i = i+1
    if( "".join(sorted(str(f2))) == "123456789"):
        #print i
        x = (i*math.log10((1+math.sqrt(5))/2)-math.log10(math.sqrt(5)))%1

        y = str (int((10**x)*10000000000))
        #print y[:9]
        if("".join(sorted(y[:9])) == "123456789"):
            print i
            break
 */
