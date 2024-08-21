/*

	https://leetcode.com/problems/remove-k-digits/
	Input: num = "1432219", k = 3
	Output: "1219"

	Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
*/

import java.util.*;
public class RemoveKDigits
{
	public static String removeKdigits(String num, int k) {

		Stack<Character> stack = new Stack<>();
		String result="";

		for(int i=0; i<num.length();i++)
		{
			while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k!=0) {stack.pop(); k-=1;}
			if(stack.size() > 0 || num.charAt(i)!=0) stack.push(num.charAt(i));
		}

		while(k>0 && !stack.isEmpty()) {stack.pop(); k-=1;}
		while(!stack.isEmpty()) { result = stack.pop() + result;}
		return (result.length() > 0) ? result : "0";
        
    }

	public static void main(String args[])
	{
		String num = "0000";
		int k=3;
		System.out.println(RemoveKDigits.removeKdigits(num,k));
	}
}