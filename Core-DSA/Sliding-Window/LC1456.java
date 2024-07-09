public class LC1456
{
	public int maxVowels(String s, int k) {

        int lo=0, r=0, n=s.length(), size=0, winSize=0, vowelCount=0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        while(r<n)
        {
            char ch = s.charAt(r);
            if(vowels.contains(ch)) vowelCount+=1;

            while(r-lo+1==k)
            {
                winSize = Math.max(winSize, vowelCount);
                if(vowels.contains(s.charAt(lo))) vowelCount-=1;
                lo+=1;
            }
            r+=1;
        }
        
        return winSize;
    }
}