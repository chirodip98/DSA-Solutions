
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-11
 */
public class Pattern12 {

    public static void objective(int n) {

        int bits = 1;
        for(int i=0; i< n; i++)
        {
            for(int j=0; j<i+1; j++)
            {
                System.out.print(bits+" ");
                bits = (bits == 0) ? 1 : 0;
                
            }
            bits = ((i & 1) == 0) ? 0 : 1;
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern12.objective(11);
    }
    
}
