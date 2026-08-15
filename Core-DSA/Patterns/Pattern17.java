
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-18
 */
public class Pattern17 {

    public static void objective(int n) {

        char start = (char)('A'+ n -1);

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i+1; j++)
            {
                System.out.print((char)(start-i+j)+" ");
            }

            System.out.println();
        }


    }

    public static void main(String args[])
    {
        Pattern17.objective(9);
    }
    
}
