public class LC992
{
	/*Pattern Ans = ans(k) - ans(k-n)

	Input: nums = [1,2,1,2,3], k = 2
	Output: 7
	Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
	https://leetcode.com/problems/subarrays-with-k-different-integers/description/
	*/
	public int helper(int[] nums, int k)
    {
        Map<Integer, Integer> track = new HashMap<>();
        int l=0, r=0, n=nums.length, count=0;

        while(r<n)
        {
            track.put(nums[r], track.getOrDefault(nums[r],0)+1);
            while(track.size() > k)
            {
                track.put(nums[l], track.getOrDefault(nums[l],0)-1);
                if(track.get(nums[l])==0) track.remove(nums[l]);
                l+=1;
            }

            count+=r-l+1;
            r+=1;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {

        return helper(nums, k) - helper(nums, k-1);  // calculate all subarrays having k,k-1, k-2 ... 1 distinct element - calculate all subarrays having k-1, k-2 ... 1 distinct element
    												// Yeilds subarrays having exactly k distinct elements
    }
}