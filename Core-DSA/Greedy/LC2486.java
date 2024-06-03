class LC2486 {

    /*

    https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/

    Input: s = "coaching", t = "coding"
    Output: 4
    Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
    Now, t is a subsequence of s ("coachingding").
    It can be shown that appending any 3 characters to the end of s will never make t a subsequence.

    */


    public static int appendCharacters(String s, String t) {

       int ptr1=0, ptr2=0;
       while(ptr1<s.length() && ptr2 <t.length())
       {
            if(s.charAt(ptr1)==t.charAt(ptr2)) {ptr1++; ptr2++;}
            else ptr1++;
       }
        
        return t.length()-ptr2;
    }

    public static void main(String args[])
    {
        String s ="coaching";
        String t ="coding";

        System.out.println("Minimum appends needed: "+LC2486.appendCharacters(s,t));
    }
}