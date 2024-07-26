import java.util.*;

public class LC187
{
	final static long PRIME=31;

	public static long calculateHash(String s)
	{
		long hashValue=0;

		for(int i=0; i<10;i++)
		{
			hashValue+=(long) (Math.pow(PRIME,i+1) * (s.charAt(i) - 'A'));
		}

		System.out.println("Hash: "+hashValue+" String: "+s.substring(0,10));
		return hashValue;
	}

	public static long RecalculateHash(String s, long oldHash, int oldIdx, int newIdx)
	{
		long newHash = oldHash;
		newHash-= (long)(Math.pow(PRIME,oldIdx)*(s.charAt(oldIdx)-'A'));
		newHash+=(long)(Math.pow(PRIME,newIdx)*(s.charAt(newIdx)-'A'));
		System.out.println("Hash: "+newHash+" String: "+s.substring(oldIdx+1,newIdx+1));
		return newHash;
	}

	public static List<String> findRepeatedDnaSequences_rollingHash(String s) {

        Map<Long, String> countMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        String currentSequence = "";
        long currentHash = LC187.calculateHash(s);

        int l=0, r=9, n=s.length();

        while(r<n-10)
        {
           	currentSequence=s.substring(l,l+10);
           	if(countMap.containsKey(currentHash))
           	{
           		result.add(currentSequence);
           		countMap.remove(currentHash);
           	}
           	else
           		countMap.put(currentHash, currentSequence);

           	r+=1;
			currentHash = LC187.RecalculateHash(s, currentHash,l,r);
           	l+=1;

        }
        
        return result;
    }
	public static List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> countMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        String currentSequence = "";

        int l=0, r=0, n=s.length();

        while(r<n)
        {
            currentSequence+=s.charAt(r);
            while(currentSequence.length() >= 10)
            {
                countMap.put(currentSequence, countMap.getOrDefault(currentSequence,0)+1);
                if(countMap.get(currentSequence)>1) 
                {
                    if(!result.contains(currentSequence))
                        result.add(currentSequence);
                    countMap.remove(currentSequence);
                }
                currentSequence = currentSequence.substring(1, currentSequence.length());
                l+=1;
            }
            r+=1;
        }
        
        return result;
    }

    public static void main(String args[])
    {
    	String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	System.out.println(LC187.findRepeatedDnaSequences_rollingHash(s));
    }
}