
/*
https://leetcode.com/problems/single-number-iii/description/
https://www.youtube.com/watch?v=faoVORjd-T8

XOR Properties : a ^ a = 0 , a ^ b =1
If we see all the elements except two elements say x, y will appear twice.
That is if we do the xor of all elements we will end up with having x ^ y
Now how to derive x^y from x and y?
eg : 4 : 1 0 0
     6 : 1 1 0
     ==========
     xor:0 1 0

if we carefully observe the x^y , there is a set bit on 2nd position (position is irrelevant)
which means either x has 1 on that bit position and y has 0 or vice versa
if we can create a  mask out of it which will segregate all the nums in array which has set pos on that
index in one group and nums which dont have into other

mask = 0 1 0 : 2

i.e group 1 : has set bit
	3-0011
	3-0011
	6- 0110
	7- 0111
	7- 0111
		 -

	group 2
	5-0101
	5-0101
	4-0100
	8-1000
	8-1000
		-

if we xor all elements in a group we will filter the single element : As a ^ a ^ b = b
TC: O(n)

*/

import java.util.Arrays;
public class SingleDigitIII
{
	 public static int[] singleNumber(int[] nums) {

	 	int xor_orig = 0;
	 	
	 	for(int i : nums)
	 		{
	 			xor_orig = xor_orig ^ i;
	 		}

	 	int last_bit = 1;

	 	while((last_bit & xor_orig)==0) 
	 		last_bit = last_bit << 1;             //finding the mask which gives the first set bit from L -> R in xor_orig

	 	int result[] = new int[2];
	 	
	 	for(int i : nums)
	 	{
	 		if((last_bit & i) == 0) { result[0]^=i;}
	 		else result[1]^=i;
	 	}

	 	return result;
	 }

	 public static void main(String args[])
	 {
	 	int nums[] = new int[]{1,1,4,3,5,3,5,6,7,8,7,8};
	 	System.out.println(Arrays.toString(singleNumber(nums)));

	 }
}