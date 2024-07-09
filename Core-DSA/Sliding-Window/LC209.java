
//Minimum Size Subarray Sum
public class LC209
{
	public static int minSubArrayLen(int target, int[] nums) {

		int windowSize = nums.length;
		int lo=0, r=0, n=nums.length;
		int sum=0;

		while(r<n)
		{
			sum+=nums[r];
		
			while(sum>=target)
				{
					windowSize = Math.min(windowSize, r-lo+1);
					sum-=nums[lo];
					lo+=1;
				}
			r+=1;
		}

		return windowSize;
	}

	public static void main(String args[])
	{
		int target = 7;
		int nums[] = {2,3,1,2,4,3};
		System.out.println(LC209.minSubArrayLen(target, nums));
	}
}