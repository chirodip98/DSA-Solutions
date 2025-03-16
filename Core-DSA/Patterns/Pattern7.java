
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-6
 */
public class Pattern7 {

    public static void objective(int n) {

        for(int i=n;i>0;i--)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern7.objective(8);
    }
    
}
