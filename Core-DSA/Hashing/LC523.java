class LC523 {

    /*
    Recall that prefix sums are particularly useful to calculate the sum of subarrays
    https://leetcode.com/problems/continuous-subarray-sum/?envType=daily-question&envId=2024-06-08

    */
    public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(){{put(0,-1);}};;
    int runningSum = 0;
    for (int i=0;i<nums.length;i++) {
        runningSum += nums[i];
        if (k != 0) runningSum %= k; 
        Integer prev = map.get(runningSum);
        if (prev != null) {
            if (i - prev > 1) return true;
        }
        else map.put(runningSum, i);
    }
    return false;
}
}