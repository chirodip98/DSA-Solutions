import java.io.*;
public class BinaryExponention
{
	static final long MOD = (long)1e9;

	public static long binaryExponention(long base, long power)
	{
		if(power == 0) return 1L;
		long res = 1;

		while(power!=0)
		{
			if((power & 1) == 0) 
			{
				base = ((base % MOD) * (base % MOD)) % MOD; 
				power= power >> 1;
			}
			else { res = (res  * base) % MOD; power--; }
		}
		return res;
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());

		while(T!=0)
		{
			long base = Long.parseLong(reader.readLine());
			long power = Long.parseLong(reader.readLine());
			System.out.println(base+" raised to power "+power+" is: "+binaryExponention(base,power));
			T--;
		}
	}
}