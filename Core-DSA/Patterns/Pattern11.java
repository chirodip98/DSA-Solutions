
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-10
 */
public class Pattern11 {

    public static void objective(int n) {

        char ch = '*';

        for(int i=0; i< n; i++)
        {
            for(int j=0; j<i+1;j++)
            {
                System.out.print(ch);
            }

            System.out.println();  
        }

        for(int i=0; i< n-1; i++)
        {
            for(int j=0; j<n-i-1;j++)
            {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern11.objective(11);
    }
    
}
