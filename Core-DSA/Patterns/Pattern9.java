
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-8
 */
public class Pattern9 {

    public static void objective(int n) {

        char space = ' ';
        char ch = '*';
        
        for(int i=n; i>0; i--)
        {
            for(int s=0; s<n-i; s++)
            {
                System.out.print(space);
            }
        
            //for character
            for(int j=0; j<2*i-1; j++)
            {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern9.objective(11);
    }
    
}
