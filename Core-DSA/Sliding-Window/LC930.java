public class LC930
{
	class Solution {

    //Method 1 : Using Maps O(n) SC: O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);

        int l=0, r=0, n=nums.length, sum=0, result=0;
        while(r<n)
        {
            sum+=nums[r];
            if(freqMap.containsKey(sum-goal))
            {
                result+=freqMap.get(sum-goal);
            }

            freqMap.put(sum, freqMap.getOrDefault(sum,0)+1);
            r+=1;
        }

        return result;
        
    }

    //Method 2 : Sliding Windows O(n) SC: O(1)
    /*
		Zeros dont contribute to the sum. even if we are removing zeros from the current window
		we are not impacting the sum accumulated so far...
		ie. 0 1 0 1 0
		if i=0, j=4 : sum[i..j] = 4
		if i=1, j=4 : sum[i..j] = 4 (still same!)

		So when we are removing zero , we can keep a track how many zeros are removed from prefix
		The no of zeros removed will also contribute to the number of subarrays (as the sum still being the same)
		1,0,1,0,1
		sub arrays: 1 0 1, 1 0 1 0, 0 1 0 1, 1 0 1


    */
    public int numSubarraysWithSum(int[] nums, int goal) {

        int l=0, r=0, n=nums.length, sum=0, result=0, zeros_seen_before=0;
        while(r<n)
        {
            sum+=nums[r];

            while(l<r && (nums[l]==0 || sum>goal))
            {
                if(nums[l]==0) zeros_seen_before++;
                else zeros_seen_before=0;

                sum-=nums[l];
                l+=1;
            }
           
            if(sum==goal)
            {
                result = result+1+zeros_seen_before;
            }
            r+=1;
        }

        return result;
        
    }
}
}