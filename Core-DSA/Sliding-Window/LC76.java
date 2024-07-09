//https://leetcode.com/problems/minimum-window-substring/
import java.util.*;
public class LC76
{
	public static String minimunWindowSubstring(String s, String t)
	{
		if(t.length() > s.length()) return "";

		Map<Character, Integer> tCount = new HashMap<>();
		Map<Character, Integer> sCount = new HashMap<>();
		String ans = "";
		
		
		//Map consisting Frequency Character Count of t
		for(char ch : t.toCharArray())
		{
			tCount.put(ch, tCount.getOrDefault(ch,0)+1);
		}

		int lo=0, hi=0, size = t.length(), maxSize=Integer.MAX_VALUE, start=0;
		while(hi<s.length())
		{
			
			char k = s.charAt(hi);
			if(tCount.getOrDefault(k,0)>0) size-=1;
			tCount.put(k, tCount.getOrDefault(k,0)-1);
		
			while(size==0)
			{
				if(maxSize > hi-lo+1)
				{
					maxSize = hi-lo+1;
					start=lo;
				}
				
				char k1 = s.charAt(lo);
				tCount.put(k1, tCount.getOrDefault(k1,0)+1);
				if(tCount.get(k1)>0) size+=1;
				lo+=1;
			}

			hi++;

		}



		return maxSize == Integer.MAX_VALUE ? "" : s.substring(start, start+maxSize);
	}

	public static void main(String args[])
	{
		String s = "aa";
		String t = "aa";
		String ans = LC76.minimunWindowSubstring(s, t);
		System.out.println("Minimum Window Substring: "+ans);
	}
}