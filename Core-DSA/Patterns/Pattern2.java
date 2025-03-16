/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-2?tab=submissions
 */

public class Pattern2 {
    
    public static void objective(int n) {

        char ch = '*';
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<=i; j++)
            {
                System.out.print(ch);
            }

            System.out.println();
        }

    }

    public static void main(String args[])
    {
        Pattern2.objective(8);
    }
    
}
