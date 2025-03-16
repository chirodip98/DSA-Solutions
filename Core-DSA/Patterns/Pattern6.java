
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-6
 */
public class Pattern6 {

    public static void objective(int n) {

        char ch = '*';
        for(int i=n; i>0; i--)
        {
            for(int j=i; j>0; j--)
            {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern6.objective(8);
    }
    
}
