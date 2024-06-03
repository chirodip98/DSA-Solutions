import java.io.*;
import java.util.*;


public class MakePallindrome
{
	/*
	1. Re-arrange the string however you want (this operation is free)
	2. Add a new character to the end of the string (this operation will cost 1Re)
	*/

	/*
	Concept : Even / Odd pallindrome
	In pallindrome only one character can exists for a odd no of times
	thus we need to keep track of odd num of elements.
	Ans is Max of 0 , countOdd - 1


	*/
	public static long minCost(String st)
	{
		int freqMap[] = new int[26];
		long minCost_ = 0;
		int countOne=0, count=0;

		for(int i=0; i<st.length(); i++)
			freqMap[st.charAt(i)-'a']++;

		for(int i=0;i<26;i++)
			{
				if((freqMap[i] & 1) !=0) countOne++;
				count+=freqMap[i];
			}

		if(countOne>1) minCost_ = countOne-1;

		return minCost_;

	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		while(T!=0)
		{
			String st = reader.readLine();
			System.out.println("Min Cost for "+st+": "+minCost(st));
			T-=1;
		}

	}
}