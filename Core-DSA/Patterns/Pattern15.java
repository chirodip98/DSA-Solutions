
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-16
 */
public class Pattern15 {

    public static void objective(int n) {

        char ch = 'A';
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i+1; j++)
            {
                System.out.print((char)(ch+i));
            }

            System.out.println();
        }

    }

    public static void main(String args[])
    {
        Pattern15.objective(9);
    }
    
}
