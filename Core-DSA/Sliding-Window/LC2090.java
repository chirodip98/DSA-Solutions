public class LC2090
{
	public int[] getAverages(int[] nums, int k) {
        
        int center=0, winSize=0, n=nums.length;
        long sum=0;
        List<Integer> averages = new ArrayList<>();
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        if(n < 2*k+1) return ans;
        if(k==0) return nums;
    
        

        int divisor = 2*k+1;
        center = k;
        int left = 0;
        int right = 2*k;
        for(int i=left;i<=right;i++) sum+=(long)nums[i];
        long avg = (long)(sum/divisor);
        ans[center++]=((int)avg);
        right+=1;
       

        while(right<n)
        {
            int newAdd = nums[right];
            int oldAdd = nums[left];
            sum= (long)(sum + newAdd - oldAdd);
            avg = (long)(sum/divisor);
            ans[center]=((int)avg);
            center+=1;
            left+=1;
            right+=1;
        }

        return ans;

    }
}