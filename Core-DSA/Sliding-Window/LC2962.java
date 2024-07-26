public class LC2692
{
	public long countSubarrays(int[] nums, int k) {

        int maxE = Arrays.stream(nums).max().getAsInt();
        int countMax=0;
        int l=0, r=0, n=nums.length;
        long subArrayCount=0;

        while(r<n)
        {
            if(nums[r]==maxE) countMax++;
                while(countMax >= k)
                {
                    subArrayCount+=(long)(n-r);
                    if(nums[l]==maxE) countMax-=1;
                    l+=1;
                }
            r+=1;
        }
        
        return subArrayCount;
    }
}