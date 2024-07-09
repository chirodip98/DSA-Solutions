//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

import java.util.*;
public class FirstNegetiveNumberOfWindow
{
	public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long ans[] = new long[(int)1e5];
        Queue<Long> Q = new LinkedList<>();
        int r=0, lo=0, size=0, idx=0;
        
        while(r<N)
        {
            if(A[r]<0) Q.offer(A[r]);
            if(r-lo+1 == K)
            {
            	if(!Q.isEmpty())
             	 	ans[idx++] = Q.peek();
             	else
             		ans[idx++]=0;


             	if(A[lo]<0 && !Q.isEmpty()) Q.poll();
             	lo+=1;
            }
            r+=1;
            
        }
        ans = Arrays.copyOfRange(ans,0, idx);
        System.out.println(Arrays.toString(ans));
        return ans;
    }
        
    public static void main(String args[])
	{
		int k = 3;
		long nums[] = {12, -1, -7, 8, -15, 30, 16, 28};
		System.out.println(FirstNegetiveNumberOfWindow.printFirstNegativeInteger(nums, nums.length, k));
	}
        

}