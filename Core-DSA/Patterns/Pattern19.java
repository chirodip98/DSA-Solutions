
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-18
 */
public class Pattern19 {

    public static void objective(int n) {

        char ch = '*';
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i+1; j++)
            {
                System.out.print(ch);
            }

            for(int s=0; s<2*(n-i-1); s++)
            {
                System.out.print(" ");
            }

            for(int j=0; j<i+1; j++)
            {
                System.out.print(ch);
            }

            System.out.println();
        }

        for(int i=(n-1); i>0; i--)
        {
            for(int j=i; j>0; j--)
            {
                System.out.print(ch);
            }

            for(int s=0; s<2*(n-i); s++)
            {
                System.out.print(" ");
            }

            for(int j=i; j>0; j--)
            {
                System.out.print(ch);
            }

            System.out.println();
        }

    }

    public static void main(String args[])
    {
        Pattern19.objective(7);
    }
    
}
