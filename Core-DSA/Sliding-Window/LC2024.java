//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/solutions/1738775/2024-maximize-the-confusion-of-an-exam/
public class LC2024
{
	public int maxConsecutiveAnswers(String answerKey, int k) {

        if(k > answerKey.length()) return 0;
        
        int lo=0, r=0, n=answerKey.length();
        int allowedReplace = k, maxSize=-1;
        int countT = 0, countF=0;

        while(r<n)
        {
            char current = answerKey.charAt(r);
            if(current=='F') countF++;
            if(current=='T') countT++;

            int minFreq = Math.min(countF, countT);
            while(minFreq >k)
            {
                //shrink window;
                if(answerKey.charAt(lo)=='F') countF--;
                if(answerKey.charAt(lo)=='T') countT--;
                minFreq = Math.min(countF, countT);
                lo+=1;
            }
           maxSize = Math.max(maxSize, r-lo+1);
           r+=1;
        }

        return maxSize;
    }

}