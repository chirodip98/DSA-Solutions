public class LC1493
{
	public int longestSubarray(int[] nums) {

        int maxSize = -1;
        int countZeros=0;
        int lo=0, r=0 ,n=nums.length;

        while(r<n)
        {
            if(nums[r]==0) countZeros+=1;
            if(countZeros>1)
            {
                maxSize = Math.max(maxSize, r-lo-1);
                if(nums[lo]==0) { countZeros-=1;}
                lo+=1;
            }
            r+=1;
        }

        if(countZeros==1) return r-lo-1;
        return maxSize == -1? n-1 : maxSize;
        
    }
}