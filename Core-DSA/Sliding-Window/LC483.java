public class LC483{

	/*
		Anagrams : Two string are said to be anagrams if the no of characters in them is same in both Strings
		eg ABCB - ACBB: Anagrams
		   ABCB X ABC :Not Anagrams

	*/

	public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()) return ans;


        Map<Character, Integer> sCount =  new HashMap<>();
        Map<Character, Integer> pCount =  new HashMap<>();

        for(int i=0;i<p.length();i++)
        {
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i),0)+1);   //Keeps count of initial k characters of s where k = p.length()
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i),0)+1);
        }

        if(sCount.equals(pCount)) ans.add(0);  //if both maps are same, we found our first match at index 0

        int l=0, r=p.length();
        while(r<s.length())
        {
            sCount.put(s.charAt(r), sCount.getOrDefault(s.charAt(r),0)+1);  //adding the RightMost element in map (window-expand)
            sCount.put(s.charAt(l), sCount.getOrDefault(s.charAt(l),0)-1);  //removing the leftMost element from map (window-shrink)
            if(sCount.get(s.charAt(l))==0) sCount.remove(s.charAt(l));  //If the count(leftMost_char) == 0 , get rid of the key
            l+=1; //shrink left pointer
            if(sCount.equals(pCount)) ans.add(l); //Condition Check
            r+=1; //expand right pointer
        }

        return ans;
        
    }
}