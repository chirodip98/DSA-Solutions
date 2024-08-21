/*
	https://leetcode.com/problems/132-pattern/
	Example 3:

	Input: nums = [-1,3,2,0]
	Output: true
	Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

	Example 1:

	Input: nums = [1,2,3,4]
	Output: false
	Explanation: There is no 132 pattern in the sequence.


*/


public class Pattern132
{
	//brute-force
    // public boolean find132pattern(int[] nums) {

    //     boolean ans = false;
    //     for(int i=0; i<nums.length;i++)
    //     {
    //         for(int j=i+1; j< nums.length;j++)
    //         {
    //             for(int k=j+1; k<nums.length; k++)
    //             {
    //                 ans = (nums[i]<nums[k]) && (nums[k] < nums[j]) && (nums[i] < nums[j]);
    //                 if(ans) return ans;
    //             }
    //         }

    //     }


    //Optimal-Solution
    public boolean find132pattern(int[] nums) {

        int num3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i=nums.length-1; i>=0; i--)
        {
            if(nums[i] < num3) return true;
            while(!stack.isEmpty() && stack.peek() < nums[i])
            {
                num3=stack.pop();
            }
            stack.push(nums[i]);
        }
        
        return false;
    }
}