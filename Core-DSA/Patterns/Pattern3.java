
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-3
 */
public class Pattern3 {

    public static void objective(int n) {

        for(int i=0;i<n;i++)
        {
            for(int j=0; j<=i; j++)
            {
                System.out.print(j+1);
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern3.objective(8);
    }
    
}
