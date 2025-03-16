
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-1
 */
public class Pattern1 {

    public static void objective(int n) {

        char ch = '*';
        for(int i=0;i<n;i++)
        {
            for(int j=0; j<n ;j++)
            {
                System.out.print(ch);
            }
            System.out.println();
        }

    }

    public static void main(String args[])
    {
        Pattern1.objective(8);
    }
    
}
