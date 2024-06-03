import java.io.*;
import java.util.*;

public class KMP
{
	public static int[] getLCS(String pattern)
	{
		int n = pattern.length();

		int LPS[] = new int[n];
		int idx = 0;

		for(int j=1;j<n;j++)
		{
			idx = LPS[j-1];

			while(idx >0 && pattern.charAt(idx) != pattern.charAt(j))
			{
				idx = LPS[idx-1];
			}
			
			if(pattern.charAt(idx) == pattern.charAt(j)) ++idx;
			LPS[j] = idx;
		}

		System.out.println("LPS Array: "+Arrays.toString(LPS));
		return LPS;
	}

	public static void performPatternMatch(String Text, String pattern)
	{
		int LPS[] = getLCS(pattern);
		int j=0;

		for(int i=0;i<Text.length();)
		{
			if(Text.charAt(i)==pattern.charAt(j)) 
				{ 
					++i; ++j; 
					
					if(j>=pattern.length())
					{
						System.out.println("Pattern found at: "+ (i - pattern.length()));
						return;
					}
			    }
			  else
			  {
			  	if(j > 0) j = LPS[j-1];
			  	else i++;
			  }
		}

		System.out.println("Pattern not found");
		return;
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String Text = sc.nextLine();
		String pattern = sc.nextLine();

		KMP.performPatternMatch(Text, pattern);
	}


}