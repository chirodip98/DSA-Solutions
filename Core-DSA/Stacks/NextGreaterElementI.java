/*
	https://leetcode.com/problems/next-greater-element-i/
	Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
	Output: [-1,3,-1]
	Explanation: The next greater element for each value of nums1 is as follows:
	- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
	- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
	- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
*/


public class NextGreaterElementI
{
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length, r=0;
        while(r<n)
        {
            while(!stack.isEmpty() && stack.peek() < nums2[r]) {map.put(stack.pop(), nums2[r]);}
            stack.push(nums2[r]);
            r+=1;
        }

        for(int i=0; i<nums1.length;i++)
        {
            nums1[i] =  map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}