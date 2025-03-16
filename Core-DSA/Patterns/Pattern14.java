
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-15
 */
public class Pattern14 {

    public static void objective(int n) {

        char ch = 'A';
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n-i; j++)
            {
                System.out.print((char)(ch+j));
            }

            System.out.println();
        }

    }

    public static void main(String args[])
    {
        Pattern14.objective(9);
    }
    
}
