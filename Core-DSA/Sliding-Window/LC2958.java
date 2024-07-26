public class LC2958
{
	public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int l=0, r=0, n=nums.length, maxLen=-1;
        while(r<n)
        {
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r],0)+1);
            if(freqMap.containsKey(nums[r]))
            {
                while(freqMap.get(nums[r])>k)
                {
                    freqMap.put(nums[l], freqMap.get(nums[l])-1);
                    l+=1;
                }
            }
            maxLen = Math.max(maxLen, r-l+1);
            r+=1;
        }
        
        return maxLen;
    }

    //method 2: Using Culprit
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int l=0, r=0, n=nums.length, maxLen=-1, culprit=0;
        while(r<n)
        {
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r],0)+1);
            if(freqMap.get(nums[r]) == k+1) culprit+=1;

            if(culprit>0)
            {
               freqMap.put(nums[l], freqMap.getOrDefault(nums[l],0)-1); 
               if(freqMap.get(nums[l]) == k) culprit-=1;
               l+=1;
            }
            
            if(culprit == 0)
                maxLen = Math.max(maxLen, r-l+1);
            r+=1;
        }
        
        return maxLen;
    }
}