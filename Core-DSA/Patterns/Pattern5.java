
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-5
 */
public class Pattern5 {

    public static void objective(int n) {

        for(int i=0;i<n;i++)
        {
            for(int j=0; j<=i; j++)
            {
                System.out.print(i+1);
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern5.objective(8);
    }
    
}
