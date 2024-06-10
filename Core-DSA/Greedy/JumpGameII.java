class JumpGameII {

    //https://leetcode.com/problems/jump-game-ii/
    //best Solution : Two Pointers
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // If the array length is less than or equal to 1, no jump is needed
        
        int count = 0; // Count of jumps
        int left = 0, right = 0; // Window boundaries
        int mxIdx = nums[0]; // Farthest index reachable from the current window

        while (left < n) {
            left = right + 1; // Move to the next window
            right = Math.min(mxIdx, n - 1); // Define the next window
            count++; // Increment count for the jump taken to reach this window
            
            if (right >= n - 1) {
                return count; // If we've reached the last index, return count
            }
            
            // Find the farthest index we can reach within the current window
            while (left <= right) {
                mxIdx = Math.min(Math.max(mxIdx, left + nums[left]), n - 1);
                left++;
            }
        }
        return count;
    }

    public static int jump(int[] nums) {

        int currPos = 0;
        int maxJump = nums[0];
        int step=0;

        while(currPos!=nums.length-1)
        {
            int idx = currPos + 1; //2
            int len = currPos+maxJump; //1+3 = 4
            while(idx <= len)
            {
                if (idx >= nums.length) break;
                if (idx == nums.length-1) return step+1;
                if(nums[idx]>=maxJump)
                {
                    maxJump = nums[idx];
                    currPos=idx;
                }

                idx++;
            }

            step++; //1
        }

        return step;
    }

    public static void main(String args[])
    {
        int jumps[] = {2,3,1,1,4};
        System.out.println(JumpGameII.jump(jumps));
    }
}