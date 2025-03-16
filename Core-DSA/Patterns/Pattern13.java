
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-11
 */
public class Pattern13 {

    public static void objective(int n) {

        int j =0;

        for(int i=0; i<n ;i++)
        {
            for(j=0; j<i+1; j++)
            {
                System.out.print(j+1);
            }

            for(int s=0; s<2*(n-(i+1)); s++)
            {
                System.out.print(" ");
            }

            for(;j>0; j--)
            {
                System.out.print(j);
            }

            System.out.println();
        }

    }

    public static void main(String args[])
    {
        Pattern13.objective(9);
    }
    
}
