public class LC239
{
	//https://leetcode.com/problems/sliding-window-maximum/
	public int[] maxSlidingWindow(int[] nums, int k) {
        

        Deque<Integer> Q = new LinkedList<>();   //Monotonic Decreasing Queue
        int lo=0, r=0, n=nums.length, idx=0;
        int ans[] = new int[n-k+1];

        while(r<n)
        {
            
            while(!Q.isEmpty() && Q.getFirst() <= r-k)   // Check for validity of Window
            {
                Q.removeFirst();
            }

            while(!Q.isEmpty() && nums[r] > nums[Q.getLast()])  // Monotoncity Check ie. till current element is greater, remove from queue
            {
                Q.removeLast();
            }

            Q.offerLast(r);  // Insert into Queue

            if(r>=k-1)  // We reached the window, start inserting into ans array
            {
                ans[idx++]=nums[Q.peek()];
                System.out.println(Q.toString());
                
            }

            r+=1;
        }

        
        return ans;
    }
}