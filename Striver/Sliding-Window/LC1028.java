public class LC1028
{
	//LC Solution O(N) S(1)
	public int equalSubstring_lc(String s, String t, int maxCost) {
        int N = s.length();
        
        int maxLen = 0;
        // Starting index of the current substring
        int start = 0;
        // Cost of converting the current substring in s to t
        int currCost = 0;
        
        for (int i = 0; i < N; i++) {
            // Add the current index to the substring
            currCost += Math.abs(s.charAt(i) - t.charAt(i));
            
            // Remove the indices from the left end till the cost becomes less than allowed
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }

    //My-Solution O(N) S(N)
    public int equalSubstring(String s, String t, int maxCost) {

        int len=s.length();
        int prefixDiff[] = new int[len];

        for(int i=0;i<len;i++)
        {
            prefixDiff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLen=0, cost=0;
        int l=0, r=0;
        for(; r<len;)
        {
            if(cost + prefixDiff[r] <= maxCost) 
            { 
                cost+=prefixDiff[r];
                maxLen = Math.max(maxLen, (r-l+1));
                r++;
            }
            else
            {
                l+=1;
                r=l;
                cost=0; //resting Cost
            }
            
        }
        return  maxLen;
    }
}