/*
https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/

Input: nums = [2,6,7,3,1,7], m = 3, k = 4
Output: 18
Explanation: There are 3 almost unique subarrays of size k = 4. 
These subarrays are [2, 6, 7, 3], [6, 7, 3, 1], and [7, 3, 1, 7]. 
Among these subarrays, the one with the maximum sum is [2, 6, 7, 3] 
which has a sum of 18.
*/

public class LC2841
{
	public long maxSum(List<Integer> nums, int m, int k) {
        
        long maxSum = 0, sum = 0;
        int n = nums.size();
        int l=0, r=0;

        Map<Integer,Integer> countMap = new HashMap<>();
        while(r<n)
        {
            sum+=nums.get(r);
            countMap.put(nums.get(r), countMap.getOrDefault(nums.get(r),0)+1);

            if(r-l+1 >= k)
            {
                    if(countMap.size() >= m)
                        maxSum = Math.max(sum, maxSum);
                    sum-=nums.get(l);
                    countMap.put(nums.get(l), countMap.getOrDefault(nums.get(l),0)-1);
                    if(countMap.get(nums.get(l))==0) countMap.remove(nums.get(l));
                    l+=1;
            }
            r+=1;
        }

        return maxSum;
    }
}