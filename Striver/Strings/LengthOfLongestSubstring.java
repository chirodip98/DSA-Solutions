class LengthOfLongestSubstring {

    //O(n^2) SC: O(s.length())
    public static int lengthOfLongestSubstring(String s) {

        int maxLen = 0, l=0, e=0;
        String tempString="";

       while(e<s.length())
        {
            char curr = s.charAt(e);
            
            System.out.println("STRING: "+tempString);

            if(tempString.contains(Character.toString(curr)))
            {
                l+=1;
                e=l;
                maxLen = Math.max(maxLen, tempString.length());
                tempString="";
            }
            else
                {
                    tempString+=curr;
                    e++;
                }
        }
        
        maxLen = Math.max(maxLen, tempString.length());
        return maxLen;
    }

    public static void main(String args[])
    {
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("dvdf"));
    }
}