
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-18
 */
public class Pattern18 {

    public static void objective(int n) {

        char ch = '*';
        for(int i=0;i<n; i++)
        {
            
            for(int j=0; j<n-i; j++)
            {
                System.out.print(ch);
            }

            for(int s=0; s<2*i; s++)
            {
                System.out.print(" ");
            }

            for(int j=0; j<(n-i); j++)
            {
                System.out.print(ch);
            }

            System.out.println();
        }

        //inverted lower half
        for(int i=0;i<n;i++)
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

    }

    public static void main(String args[])
    {
        Pattern18.objective(32);
    }
    
}
