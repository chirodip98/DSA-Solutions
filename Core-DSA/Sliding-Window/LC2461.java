import java.util.*;

/* https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/ 
	Input: nums = [1,5,4,2,9,9,9], k = 3
	Output: 15
	Explanation: The subarrays of nums with length 3 are:
	- [1,5,4] which meets the requirements and has a sum of 10.
	- [5,4,2] which meets the requirements and has a sum of 11.
	- [4,2,9] which meets the requirements and has a sum of 15.
	- [2,9,9] which does not meet the requirements because the element 9 is repeated.
	- [9,9,9] which does not meet the requirements because the element 9 is repeated.
	We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
*/

public class LC2461
{
	public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> freqCount = new HashMap<>();
     
        int lo=0, r=0;
        long maxSum=0, sum=0;
        while(r<n)
        {
            freqCount.put(nums[r], freqCount.getOrDefault(nums[r],0)+1);
            sum+=(long)nums[r];

            //condition evaluation
            if(r-lo+1 == k)
            {
                if(freqCount.size()==k)
                    maxSum=(long)Math.max(maxSum, sum);
                
                sum-=nums[lo];
                freqCount.put(nums[lo], freqCount.get(nums[lo])-1);
                if(freqCount.get(nums[lo])==0) freqCount.remove(nums[lo]);
                lo++;  //shrink and expand
            }

            r++;
        }
       
        
        return maxSum;
    }
}