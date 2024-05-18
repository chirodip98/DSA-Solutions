import java.io.*;
import java.util.*;

public class primeFactorisation
{
	static final long MOD = (long)1e9;

	public static List<List<Integer>> getPrimeFactors(int base)
	{
		List<List<Integer>> primeFactors = new ArrayList<>();
		
		for(int i=2; i*i <= base; i++)
		{
			int count = 0;
			if(base % i == 0)
			{	
				while(base%i == 0)
				{
					base /= i;
					count++;
				}

				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				temp.add(count);
				primeFactors.add(temp);
			}
		}

		if(base > 1) 
			{
				List<Integer> temp = new ArrayList<>();
				temp.add(base);
				temp.add(1);
				primeFactors.add(temp);
			}

		return primeFactors;
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());

		while(T!=0)
		{
			int base = Integer.parseInt(reader.readLine());
			System.out.println("Prime Factors of "+base+" are: "+getPrimeFactors(base));
			T--;
		}
	}
}