import java.io.*;
import java.util.*;

public class KarpRabin
{
	static final int PRIME=53;

	public static double calcHash(String text)
	{
		double myHash = 0;
		int idx=0;
		
		for(char ch : text.toCharArray())
		{
			myHash+= (ch-'a'+1) * Math.pow(PRIME,idx);
			++idx;
		}

		return myHash;
	}

	public static double updateHash(double oldHash, char oldChar, char newChar, int length)
	{
		double newHash = (oldHash - (oldChar -'a' +1))/PRIME;
		newHash+= (newChar-'a'+1) * Math.pow(PRIME,length-1);
		return newHash;
	}

	public static void patternSearch(String Text, String pattern)
	{
		double textHash = calcHash(Text.substring(0, pattern.length()));
		double patternHash = calcHash(pattern);
		int len = Text.length()-pattern.length();

		for(int i=0;i<=len;i++)
		{
			if(textHash == patternHash)
			{
				if(Text.substring(i,i+pattern.length()).equals(pattern)) 
				{
					System.out.println(Text.substring(i,i+pattern.length())+" "+pattern);
					System.out.println("Pattern found at: "+i);
					return;
				}
			}

			if(i < len){
				textHash = updateHash(textHash, Text.charAt(i),Text.charAt(i+pattern.length()),pattern.length());
			}
		}

		System.out.println("Pattern not found");
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String Text = sc.nextLine();
		String pattern = sc.nextLine();

		KarpRabin.patternSearch(Text, pattern);
	}
}