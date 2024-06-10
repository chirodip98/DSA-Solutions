class ClearStrings {
    public static String clearDigits(String s) {
        
        int left =0, right=0;
        char stringArr[] = s.toCharArray();

        while(right<s.length())
        {
            if(stringArr[right]==' ') { right++; continue;}
            if(!Character.isDigit(stringArr[right])) { left = right;}
            if(Character.isDigit(stringArr[right])) 
                { stringArr[left]=' '; 
                  stringArr[right]=' '; 
                  left=0;
                  right=-1;
                }
                
                ++right;
        }
        
        return new String(stringArr).trim();
        
    }

    public static void main(String args[])
    {
        String input = "abcd34f75"; //abc4f75 >> abf75 >> ab
        System.out.println(ClearStrings.clearDigits(input));
    }
}